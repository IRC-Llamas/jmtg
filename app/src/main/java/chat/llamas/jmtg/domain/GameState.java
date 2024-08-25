package chat.llamas.jmtg.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class GameState {
	private List<Player> players = new ArrayList<>();
	
	private Optional<Player> activePlayer = Optional.empty();
	
	private Iterator<Player> playerIterator;

    public GameState(List<Player> players) {
    	this.players.addAll(players);
    }

    public List<Player> getPlayers() {
    	return List.copyOf(players);
    }

    public void turn() {
    	if (Objects.isNull(playerIterator) || !playerIterator.hasNext()) {
    		playerIterator = players.iterator();
    		
    	}
    	activePlayer = Optional.of(playerIterator.next());
    }
    
    public Player getCurrentPlayer() {
    	return activePlayer.get();
    }
    
    public boolean isGameComplete() {
    	return players.stream().filter(x -> x.getLifeTotal() > 0).count() > 1;
    }
}