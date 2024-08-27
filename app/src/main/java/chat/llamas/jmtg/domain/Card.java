package chat.llamas.jmtg.domain;

import lombok.Data;

@Data
public abstract class Card {
    protected String name;
    protected CardType type;
    private ManaCost manaCost;
    private boolean tapped;
    
    public Card(String name, CardType type, ManaCost manaCost) {
        this.name = name;
        this.type = type;
        this.manaCost = manaCost;
    }

    public String getName() {
        return name;
    }

    public CardType getType() {
        return type;
    }

    public ManaCost getManaCost() {
        return manaCost;
    }


    @Override
    public String toString() {
        return String.format("Card[name=%s, type=%s, manaCost=%d]", name, type, manaCost);
    }
}