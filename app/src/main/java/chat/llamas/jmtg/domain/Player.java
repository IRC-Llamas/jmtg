package chat.llamas.jmtg.domain;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

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
}
