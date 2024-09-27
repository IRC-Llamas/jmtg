package chat.llamas.jmtg.domain.card;

public enum CardType {
	LAND(CardTypeType.PERMANENT),
	CREATURE(CardTypeType.PERMANENT),
	ARTIFACT(CardTypeType.PERMANENT),
	ENCHANTMENT(CardTypeType.PERMANENT),
	PLANESWALKER(CardTypeType.PERMANENT),
	BATTLE(CardTypeType.PERMANENT),
	INSTANT(CardTypeType.SPELL),
	SORCERY(CardTypeType.SPELL);
	
	private CardTypeType typetype;
	CardType(CardTypeType typetype) {
		this.typetype = typetype;
	}
	
	public boolean isPermanent() {
		return typetype == CardTypeType.PERMANENT;
	}
}
