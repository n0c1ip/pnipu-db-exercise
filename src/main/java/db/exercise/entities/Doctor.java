package db.exercise.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Doctor {

	private long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String specialization;
	private String qualification;
	private boolean vacation;

	@Override
	public String toString() {
		return lastName + " " + firstName + " " + middleName;
	}

}
