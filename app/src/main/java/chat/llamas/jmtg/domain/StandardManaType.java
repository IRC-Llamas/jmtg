package chat.llamas.jmtg.domain;

import java.util.Arrays;

public enum StandardManaType implements ManaType {
    WHITE(ManaColor.WHITE),
    BLUE(ManaColor.BLUE),
    BLACK(ManaColor.BLACK),
    RED(ManaColor.RED),
    GREEN(ManaColor.GREEN),
    ANY(ManaColor.values());
	
	private ManaColor[] colors;

	StandardManaType(ManaColor[] colors) {
		this.colors = Arrays.copyOf(colors, colors.length);
		Arrays.sort(this.colors);
	}
	StandardManaType(ManaColor color) {
		this.colors = new ManaColor[] { color };
	}
	StandardManaType(ManaColor color, ManaColor... colors) {
		// TODO: Weed out dupes.
		this.colors = new ManaColor[colors.length + 1];
		this.colors[0] = color;
		for (int x = 0; x < colors.length; x++) {
			this.colors[x + 1] = colors[x];
		}
		Arrays.sort(this.colors);
	}
	
	@Override
	public ManaColor[] getColors() {
		return colors;
	}
}
