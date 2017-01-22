package db.exercise.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@NoArgsConstructor
public class Patient {

	private long id;
	private String firstName;
	private String lastName;
	private String middleName;
	private String address;
	private Date birthDay;
	private String diagnoses;
	private String cardNumber;
	private String snils;
	private String polis;
	private String phone;
	private Short male;
	private String workInfo;
	private boolean onControl;

	public Patient(String firstName, String lastName, String middleName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
	}

	@Override
	public String toString() {
		return lastName + " " + firstName + " " + middleName;
	}
}
