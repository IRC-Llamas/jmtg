package chat.llamas.jmtg.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ManaCost {
    private Map<ManaType, Integer> costMap;

    public ManaCost() {
        costMap = new HashMap<>(Stream.of(StandardManaType.values()).collect(Collectors.toMap(x -> x, x -> 0)));
    }

    public void addMana(ManaType type, int amount) {
        costMap.put(type, costMap.get(type) + amount);
    }

    public int getAmount(ManaType type) {
        return costMap.getOrDefault(type, 0);
    }

    public void setAmount(ManaType type, int amount) {
        costMap.put(type, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<ManaType, Integer> entry : costMap.entrySet()) {
            if (entry.getValue() > 0) {
                sb.append(entry.getKey().toString() + ":" + entry.getValue() + System.lineSeparator());
            }
        }
        return sb.toString();
    }

    // Additional methods for equality, hashCode, etc., can be added
}
