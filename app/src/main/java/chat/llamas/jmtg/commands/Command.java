package chat.llamas.jmtg.commands;

import chat.llamas.jmtg.domain.GameState;

public interface Command {
    void execute(GameState game);
    void undo(GameState game);
    void redo(GameState game);
}