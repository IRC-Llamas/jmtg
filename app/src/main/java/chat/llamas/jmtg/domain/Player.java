package chat.llamas.jmtg.domain;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
	String name;
	int lifeTotal;
    private Deck deck;
    private List<Card> hand;

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
}
