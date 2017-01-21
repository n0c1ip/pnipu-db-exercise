package db.exercise.entities.medicine;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Patient {

	private long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String address;
	private Date birthDay;
	private String diagnoses;

	@Override
	public String toString() {
		return lastName + " " + firstName + " " + middleName;
	}
}
