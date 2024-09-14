package chat.llamas.jmtg;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import chat.llamas.jmtg.domain.CombatResults;
import chat.llamas.jmtg.domain.card.CreatureCard;

public class CombatResolver {

    // Method to resolve combat between multiple attackers and blockers
    public static CombatResults resolveCombat(List<CreatureCard> attackers, List<CreatureCard> blockers) {
        if (attackers == null || blockers == null) {
            System.out.println("Invalid combat: Attackers or blockers list is null.");
            return null;
        }

        // Ensure that all attackers and blockers are untapped
        for (CreatureCard attacker : attackers) {
            if (attacker.isTapped()) {
                System.out.println("Attacker " + attacker.getName() + " is tapped and cannot attack.");
                return null;
            }
        }
        for (CreatureCard blocker : blockers) {
            if (blocker.isTapped()) {
                System.out.println("Blocker " + blocker.getName() + " is tapped and cannot block.");
                return null;
            }
        }
        
        CombatResults results = new CombatResults();

        AtomicInteger remainderDamage = new AtomicInteger();
        // Process combat for each attacker-blocker pair
        for (CreatureCard attacker : attackers) {
            boolean blocked = false;
            for (CreatureCard blocker : blockers) {
            	// TODO: Find a way to pass remainderDamage onto the next blocker
                if (!blocker.isTapped() && canBlock(attacker, blocker)) {
                    blocked = true;
                    System.out.println(attacker.getName() + " is blocked by " + blocker.getName() + ".");

                    Collection<CreatureCard> survivors = calculateSurvivors(attacker, blocker, remainderDamage);
                    break; //TODO: handle multiple blockers
                }
            }
            if (!blocked) {
                System.out.println(attacker.getName() + " attacks unblocked.");
                // TODO: Handle unblocked attacker logic here (e.g., damage to player)
            }
        }
        return results;
    }

    private static boolean canBlock(CreatureCard attacker, CreatureCard blocker) {
        // Placeholder logic for determining if a blocker can block an attacker
        // This can be expanded with rules for flying, reach, etc.
        return true;
    }

    private static void applyDamage(CreatureCard attacker, CreatureCard defender) {
        if (attacker == null || defender == null) {
            return;
        }

        int damage = attacker.getPower();
        System.out.println(attacker.getName() + " deals " + damage + " damage to " + defender.getName() + ".");
        // Apply damage effects here
    }

    private static Collection<CreatureCard> calculateSurvivors(CreatureCard attacker, CreatureCard defender, AtomicInteger unresolvedDamage) {
    	// TODO: Consider flying
        Objects.requireNonNull(attacker);
        Objects.requireNonNull(defender);

        int defenderToughness = defender.getToughness();
        int attackerPower = attacker.getPower();
        
        Collection<CreatureCard> survivors = new HashSet<>(Set.of(attacker, defender));

        if (attackerPower >= defenderToughness) {
            System.out.println(defender.getName() + " is destroyed.");
            // Handle destruction (e.g., remove from battlefield)
            survivors.remove(defender);
        }

        // TODO: First Strike can alter this?
        int attackerToughness = attacker.getToughness();
        int defenderPower = defender.getPower();

        if (defenderPower >= attackerToughness) {
            System.out.println(attacker.getName() + " is destroyed.");
            // Handle destruction (e.g., remove from battlefield)
            survivors.remove(attacker);
            
            int remainder = defenderPower - attackerToughness;
            if (remainder > 0) {
            	unresolvedDamage.addAndGet(remainder);
            }
        }
        
        
        
        return survivors;
    }
}