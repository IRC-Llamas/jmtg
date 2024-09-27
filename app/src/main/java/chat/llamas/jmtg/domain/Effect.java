package chat.llamas.jmtg.domain;

import chat.llamas.jmtg.domain.card.Card;

public interface Effect {
    void apply(GameState gameState, Card card);
}
