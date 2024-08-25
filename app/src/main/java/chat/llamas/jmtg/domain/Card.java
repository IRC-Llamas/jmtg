package chat.llamas.jmtg.domain;

public abstract class Card {
    private String name;
    private String type;
    private int manaCost;

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

    // Abstract method to be implemented by subclasses for applying effects
    public abstract void applyEffect(GameState gameState);

    @Override
    public String toString() {
        return String.format("Card[name=%s, type=%s, manaCost=%d]", name, type, manaCost);
    }
}