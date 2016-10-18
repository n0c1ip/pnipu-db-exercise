package db.exercise.entities.medicine;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Doctor {

	private long id;
	private String lastName;
	private String specialization;
	private String qualification;

}
