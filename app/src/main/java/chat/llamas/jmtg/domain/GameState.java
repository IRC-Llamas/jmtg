package chat.llamas.jmtg.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.Getter;

public class GameState implements GameStateBehavior {
	private List<Player> players = new ArrayList<>();
	
	private Optional<Player> activePlayer = Optional.empty();

    public GameState(List<Player> players) {
    	this.players.addAll(players);
    }

    public List<Player> getPlayers() {
    	return List.copyOf(players);
    }

    public void turn() {
    	if (activePlayer.isEmpty() || Objects.equals(activePlayer.get(), players.getLast())) {
    		activePlayer = Optional.of(players.getFirst());
    	}
    	else {
    		activePlayer = Optional.of(players.get(players.indexOf(activePlayer.get()) + 1));
    	}
    }
    
    public Player getCurrentPlayer() {
    	return activePlayer.get();
    }
    
    public boolean isGameComplete() {
    	return players.stream().filter(x -> x.isLost()).count() >= players.size() - 1;
    }

	@Override
	public void playCard(Player player, Card card) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeCardFromPlay(Card card) {
		// TODO Auto-generated method stub
		
	}
	
	public class GameStateMemento {
		@Getter
		private final List<Player> players;
		
		@Getter
		private final Player activePlayer;
		
		private GameStateMemento(List<Player> players, Player activePlayer) {
			this.players = List.copyOf(players);
			
			this.activePlayer = activePlayer;
		}
	}
	
	/**
	 * @return An immutable copy of the game state.
	 */
	public GameStateMemento createMemento() {
		GameStateMemento m = new GameStateMemento(players, activePlayer.get());
		
		return m;
	}
	
	public void restore(GameStateMemento m) {
		this.players.clear();
		this.activePlayer = Optional.of(m.getActivePlayer());
		this.players.addAll(m.getPlayers());
		// TODO: Not clear yet if the Player class needs
		// the restore functionality of the memento.
	}
}