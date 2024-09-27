package chat.llamas.jmtg.events;

import io.reactivex.rxjava3.subjects.PublishSubject;
import lombok.Getter;

public class GameEventManager 
{
	private PublishSubject<TapEventArgs> preTapEvent = PublishSubject.create();
	private PublishSubject<TapEventArgs> postTapEvent = PublishSubject.create();
	private PublishSubject<TapEventArgs> preUntapEvent = PublishSubject.create();
	private PublishSubject<TapEventArgs> postUntapEvent = PublishSubject.create();
	
	@Getter
	private GameEventPublisher gameEventPublisher = new GameEventPublisher(this);
	
	
	private static class GameEventPublisher {
		
		private GameEventManager manager;
		private GameEventPublisher(GameEventManager manager) {
			this.manager = manager;
		}
		
		public void firePreTapEvent(TapEventArgs e) {
			manager.preTapEvent.onNext(e);
		}
		
		// TODO: Implement the rest of the events.
	}
}
