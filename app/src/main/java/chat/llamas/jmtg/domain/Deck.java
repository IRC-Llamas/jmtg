package chat.llamas.jmtg.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import chat.llamas.jmtg.domain.GameState.GameStateMemento;
import lombok.Getter;


public class Deck {
    private List<Card> cards;

    public Deck() {
        this.cards = new ArrayList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public void shuffle() {
        Collections.shuffle(cards);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            return null;
            // Maybe throw an exception?
            
        }
        return cards.remove(cards.size() - 1);
    }

    public int size() {
        return cards.size();
    }

    @Override
    public String toString() {
        return "Deck[size=" + size() + "]";
    }
    
    public static class DeckMemento {
    	@Getter
    	private final List<Card> cards;
    	
    	public DeckMemento(List<Card> cards) {
    		this.cards = List.copyOf(cards);
    	}
    }
    
	/**
	 * @return An immutable copy of the deck.
	 */
	public DeckMemento createMemento() {
		DeckMemento m = new DeckMemento(cards);
		
		return m;
	}
	
	public void restore(DeckMemento m) {
		this.cards.clear();
		
		this.cards.addAll(m.getCards());
	}
}
