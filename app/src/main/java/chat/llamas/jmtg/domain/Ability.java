package chat.llamas.jmtg.domain;

public interface Ability {
	boolean canActivate(GameState gameState);
	void activate(GameState gameState, Player player);
}
