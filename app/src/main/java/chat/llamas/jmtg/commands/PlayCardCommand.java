package chat.llamas.jmtg.commands;

import chat.llamas.jmtg.domain.GameState;
import chat.llamas.jmtg.domain.Player;
import chat.llamas.jmtg.domain.card.Card;

public class PlayCardCommand implements GameCommand {
    private Player player;
    private Card card;

    public PlayCardCommand(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    @Override
    public void execute(GameState game) {
    	game.playCard(player, card);
    }

	@Override
	public void validate(GameState game) throws InvalidCommandException {
		// TODO Auto-generated method stub
		
	}
    /*

    @Override
    public void undo(GameState game) {
    	game.removeCardFromPlay(card);
    }

    @Override
    public void redo(GameState game) {
        execute(game);
    }
    
    */
}