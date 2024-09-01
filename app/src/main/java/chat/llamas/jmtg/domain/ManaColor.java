package chat.llamas.jmtg.domain;

public enum ManaColor {
    WHITE(false, true),
    BLUE(false, true),
    BLACK(false, true),
    RED(false, true),
    GREEN(false, true),
    COLORLESS(false, false);
	
	private boolean custom;
	private boolean rigid;
	
	ManaColor(boolean custom, boolean rigid) {
		this.custom = custom;
		this.rigid = rigid;
	}
}
