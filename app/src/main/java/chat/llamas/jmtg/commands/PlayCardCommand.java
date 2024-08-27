package chat.llamas.jmtg.commands;

import chat.llamas.jmtg.domain.Card;
import chat.llamas.jmtg.domain.GameState;
import chat.llamas.jmtg.domain.Player;

public class PlayCardCommand implements Command {
    private Player player;
    private Card card;

    public PlayCardCommand(Player player, Card card) {
        this.player = player;
        this.card = card;
    }

    @Override
    public void execute(GameState game) {
    	game.playCard(player, card);
    }

    @Override
    public void undo(GameState game) {
    	game.removeCardFromPlay(card);
    }

    @Override
    public void redo(GameState game) {
        execute(game);
    }
}