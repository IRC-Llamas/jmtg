package chat.llamas.jmtg.domain.card;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

import chat.llamas.jmtg.domain.ManaCost;
import chat.llamas.jmtg.domain.Rule;
import lombok.Data;


@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = CreatureCard.class, name = "creature")
})
@Data
public abstract class Card {
    protected String name;
    protected CardType type;
    private ManaCost manaCost;
    private boolean tapped;
    private List<Rule> rules;
    
    public Card(String name, CardType type, ManaCost manaCost) {
        this.name = name;
        this.type = type;
        this.manaCost = manaCost;
    }

    public String getName() {
        return name;
    }

    public CardType getType() {
        return type;
    }

    public ManaCost getManaCost() {
        return manaCost;
    }


    @Override
    public String toString() {
        return String.format("Card[name=%s, type=%s, manaCost=%d]", name, type, manaCost);
    }
}