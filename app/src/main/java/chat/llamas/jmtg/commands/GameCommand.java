package chat.llamas.jmtg.commands;

import chat.llamas.jmtg.domain.GameState;

public interface GameCommand {
    void execute(GameState game) throws InvalidCommandException;

    void validate(GameState game) throws InvalidCommandException;

    void undo(GameState game) throws InvalidCommandException;
}