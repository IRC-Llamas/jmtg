package chat.llamas.jmtg.domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public interface CustomManaType extends ManaTypeInterface {
	static class DefaultCustomManaType implements ManaTypeInterface {
		
		private ManaColor[] colors;
		
		
		@Override
		public ManaColor[] getColors() {
			return colors;
		}
		
	}
	default ManaTypeInterface get(ManaColor... colors) {
		if (Objects.isNull(colors) || colors.length == 0) {
			throw new RuntimeException();
		}
        Arrays.sort(colors);
        return CustomManaTypePrivate.getManaType(colors);
	}
}
class CustomManaTypePrivate implements CustomManaType {
	private static final Map<ManaColor[], CustomManaType> manaTypeMap = new HashMap<>();
	private final ManaColor[] colors;
	
	public static CustomManaType getManaType(ManaColor[] colors) {
		for (ManaColor[] color : manaTypeMap.keySet()) {
			if (Arrays.equals(color, colors)) {
				return manaTypeMap.get(color);
			}
		}
		return manaTypeMap.put(colors, new CustomManaTypePrivate(colors));
	}
	private CustomManaTypePrivate(ManaColor[] colors) {
		this.colors = colors;
	}
	@Override
	public ManaColor[] getColors() {
		return colors;
	}
	
}