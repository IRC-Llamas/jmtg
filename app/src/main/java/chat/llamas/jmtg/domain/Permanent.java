package chat.llamas.jmtg.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

/**
 * https://mtg.fandom.com/wiki/Permanent
 * A permanent is a card or token on the battlefield. 
 * A permanent remains on the battlefield indefinitely. 
 * A card or token becomes a permanent as it enters the 
 * battlefield and it stops being a permanent as it’s moved 
 * to another zone by an effect or rule.
 */
public class Permanent {
	private Player controller;
	private Card parent;
	private Set<PermanentType> permanentTypes = new HashSet<>();
	private Optional<CreatureData> creatureData = Optional.empty();
	public Permanent(Player controller, Card parent, PermanentType... types) {
		this.controller = controller;
		this.parent = parent;
		permanentTypes.addAll(Arrays.asList(types));
	}
}
