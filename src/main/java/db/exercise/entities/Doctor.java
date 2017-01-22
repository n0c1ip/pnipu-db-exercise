package db.exercise.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Doctor {

	private long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String specialization;
	private String qualification;
	private boolean vacation;

	public Doctor(String firstName, String lastName, String middleName, String specialization) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.specialization = specialization;
	}

	@Override
	public String toString() {
		return lastName + " " + firstName + " " + middleName;
	}

}
