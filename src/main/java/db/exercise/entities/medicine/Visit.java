package db.exercise.entities.medicine;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter @Setter
public class Visit {

	private long id;
	private long patientId;
	private long doctorId;
	private Date visitDate;

}
