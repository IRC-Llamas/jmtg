package chat.llamas.jmtg.domain;

public abstract class Card {
    protected String name;
    protected String type;
    protected int manaCost;

    public Card(String name, String type, int manaCost) {
        this.name = name;
        this.type = type;
        this.manaCost = manaCost;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getManaCost() {
        return manaCost;
    }


    @Override
    public String toString() {
        return String.format("Card[name=%s, type=%s, manaCost=%d]", name, type, manaCost);
    }
}