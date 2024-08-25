package chat.llamas.jmtg;

import chat.llamas.jmtg.domain.GameState;

public class TurnManager {
    private GameState gameState;

    public TurnManager(GameState gameState) {
        this.gameState = gameState;
    }

    public void startTurn() {
        System.out.println("Starting turn for " + gameState.getCurrentPlayer().getName());
        // Example phases
        drawPhase();
        mainPhase();
        endPhase();
        gameState.turn();
    }

    private void drawPhase() {
        System.out.println(gameState.getCurrentPlayer().getName() + " draws a card.");
        // Implement drawing a card logic
    }

    private void mainPhase() {
        System.out.println(gameState.getCurrentPlayer().getName() + " is in the main phase.");
        // Implement main phase logic (playing cards, etc.)
    }

    private void endPhase() {
        System.out.println(gameState.getCurrentPlayer().getName() + " ends their turn.");
        // Implement end phase logic
    }
}