package db.exercise.entities.boats;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Transport {

	private long id;
	private String title;
	private String number;
	private TransportState state;
	private TransportType type;
	private boolean availability;

}
