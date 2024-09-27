package chat.llamas.jmtg.events;

import chat.llamas.jmtg.domain.Permanent;
import chat.llamas.jmtg.domain.Player;
import lombok.Getter;

public abstract class GameEventArgs {

	@Getter
	protected final Player player;
	
	public GameEventArgs(Player player) {
		this.player = player;
	}
}
