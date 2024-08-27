package chat.llamas.jmtg.domain;

public interface Condition {
    boolean isSatisfied(GameState gameState, Card card);
}