package chat.llamas.jmtg.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class CreatureCard extends Card {
    private int power;
    private int toughness;
    
    public CreatureCard(String name, CardType type, ManaCost manaCost, int power, int toughness) {
    	super(name, type, manaCost);
    	this.power = power;
    	this.toughness = toughness;
    }

    @Override
    public String toString() {
        return String.format("CreatureCard[name=%s, manaCost=%d, power=%d, toughness=%d]", 
                             getName(), getManaCost(), power, toughness);
    }
}
