package db.exercise.entities;

import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter @Setter
public class Diagnosis {

	private long id;
	private Doctor doctor;
	private Patient patient;
	private Date date;
	private String disease;
	private String comment;

}
