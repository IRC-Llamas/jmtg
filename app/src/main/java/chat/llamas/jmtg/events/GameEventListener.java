package chat.llamas.jmtg.events;

public interface GameEventListener<T extends GameEventArgs> {
	void onEvent(T args);
}
