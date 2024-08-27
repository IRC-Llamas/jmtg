package chat.llamas.jmtg.domain;

public interface Effect {
    void apply(GameState gameState, Card card);
}
