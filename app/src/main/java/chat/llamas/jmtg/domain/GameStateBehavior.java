package chat.llamas.jmtg.domain;

import java.util.List;

import chat.llamas.jmtg.domain.card.Card;

public interface GameStateBehavior {
	public void turn();
	
	public Player getCurrentPlayer();
	
	public List<Player> getPlayers();
	
	public boolean isGameComplete();
	
	public void playCard(Player player, Card card);
	
	public void removeCardFromPlay(Card card);
}
