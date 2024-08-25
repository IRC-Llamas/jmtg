package chat.llamas.jmtg.domain;

import java.util.Collection;

import lombok.Data;

@Data
public class CombatResults {
	private Collection<CreatureCard> survivingAttackers;
	
	private Collection<CreatureCard> survivingDefenders;
	
	private int leftoverDamage;
}
