package chat.llamas.jmtg.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import chat.llamas.jmtg.domain.card.Card;


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
}
