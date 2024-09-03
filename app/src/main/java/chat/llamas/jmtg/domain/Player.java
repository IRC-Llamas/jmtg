package chat.llamas.jmtg.domain;
import java.util.ArrayList;
import java.util.List;

import chat.llamas.jmtg.domain.Deck.DeckMemento;
import lombok.Data;
import lombok.Getter;

@Data
public class Player {
	String name;
	int lifeTotal;

    private List<Card> hand;

    private Deck deck;

    
	public Player(String name, int lifeTotal) {
		this.name = name;
		this.lifeTotal = lifeTotal;
		
		hand = new ArrayList<>();
	}

    
	public Player(String name, int lifeTotal, Deck deck) {
		this(name, lifeTotal);
		this.deck = deck;
	}
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	public void applyDamage(int damage) {
		lifeTotal = lifeTotal - damage;
	}

    public void drawCard() {
        Card drawnCard = deck.drawCard();
        if (drawnCard != null) {
            hand.add(drawnCard);
            System.out.println(name + " drew a card: " + drawnCard);
        } else {
            System.out.println(name + " cannot draw a card; the deck is empty.");
            
            // Maybe throw exception?
        }
    }

    @Override
    public String toString() {
        return name + " (Life: " + lifeTotal + ", Hand: " + hand.size() + " cards)";
    }
    
    public boolean isLost() {
    	return lifeTotal <= 0;
    }
    
	public static class PlayerMemento {

		@Getter
		private final Player parentPlayer;
		
		@Getter
		private final String name;
		
		@Getter
		private final int lifeTotal;
		
		@Getter
		private final List<Card> hand;

		@Getter
	    private final DeckMemento deck;
		
		private PlayerMemento(Player parentPlayer, String name, int lifeTotal, List<Card> hand, Deck deck) {
			this.parentPlayer = parentPlayer;
			
			this.hand = List.copyOf(hand);
			
			this.name = name;
			
			this.lifeTotal = lifeTotal;
			
			this.deck = deck.createMemento();					
		}
	}
	
	/**
	 * @return An immutable copy of the Player.
	 */
	public PlayerMemento createMemento() {
		PlayerMemento m = new PlayerMemento(this, name, lifeTotal, hand, deck);
		
		return m;
	}
	
	public void restore(PlayerMemento m) {
		this.name = m.getName();
		
		this.lifeTotal = m.getLifeTotal();
		
		this.hand.clear();
		
		this.hand.addAll(m.getHand());		
	}
}
