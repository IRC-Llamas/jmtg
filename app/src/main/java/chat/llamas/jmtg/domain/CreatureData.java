package chat.llamas.jmtg.domain;

import lombok.Getter;

public class CreatureData {
	@Getter
	private final int power;
	@Getter
	private final int toughness;
	private boolean summoningSickness = true;
	public CreatureData(int power, int toughness) {
		super();
		this.power = power;
		this.toughness = toughness;
	}
	
}
