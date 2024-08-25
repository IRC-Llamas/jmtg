package chat.llamas.jmtg.domain;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Player {
	String name;
	int lifeTotal;
}
