package db.exercise.entities.boats;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transport {

	private String title;
	private String number;
	private String state;
	private String type;
	private boolean availability;

}
