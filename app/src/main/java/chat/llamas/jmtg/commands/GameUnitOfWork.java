package chat.llamas.jmtg.commands;

import java.util.ArrayList;
import java.util.List;

import chat.llamas.jmtg.domain.GameState;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class GameUnitOfWork {
	private List<GameCommand> commandStack = new ArrayList<>();
	
	
	public void addCommand(GameCommand command) {
		commandStack.add(command);
	}
	
	public void validate(GameState gameState) throws InvalidCommandException {
		// Validation has to consider effects of previous commands.
		// Need to find a good way to do this (clone GameState?)
		for (var command : commandStack) {
			command.validate(gameState);
		}
	}
	
    public void commit(GameState gameState) {
    	var memento = gameState.createMemento();
    			
    	try {
	        for (var command : commandStack) {
					command.execute(gameState);
	        }
	        commandStack.clear();
    	} catch (InvalidCommandException e) {
    		gameState.restore(memento);
    		
    		throw new RuntimeException(e);
    	}
    }

}
