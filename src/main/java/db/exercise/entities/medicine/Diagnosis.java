package db.exercise.entities.medicine;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Diagnosis {

	private long id;
	private long patientId;
	private long doctorId;
	private long diseaseId;
	private long visitId;

}
