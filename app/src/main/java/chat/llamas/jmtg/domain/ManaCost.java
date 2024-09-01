package chat.llamas.jmtg.domain;

import java.util.HashMap;
import java.util.Map;

public class ManaCost {
    private Map<StandardManaType, Integer> costMap;

    public ManaCost() {
        costMap = new HashMap<>();
        for (StandardManaType type : StandardManaType.values()) {
            costMap.put(type, 0);
        }
    }

    public void addMana(StandardManaType type, int amount) {
        costMap.put(type, costMap.get(type) + amount);
    }

    public int getAmount(StandardManaType type) {
        return costMap.getOrDefault(type, 0);
    }

    public void setAmount(StandardManaType type, int amount) {
        costMap.put(type, amount);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<StandardManaType, Integer> entry : costMap.entrySet()) {
            if (entry.getValue() > 0) {
                sb.append(entry.getKey().toString().charAt(0)) // Example: 'W' for white
                   .append(entry.getValue());
            }
        }
        return sb.toString();
    }

    // Additional methods for equality, hashCode, etc., can be added
}
