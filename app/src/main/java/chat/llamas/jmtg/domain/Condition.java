package chat.llamas.jmtg.domain;

import chat.llamas.jmtg.domain.card.Card;

public interface Condition {
    boolean isSatisfied(GameState gameState, Card card);
}