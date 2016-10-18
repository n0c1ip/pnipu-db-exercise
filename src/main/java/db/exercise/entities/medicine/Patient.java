package db.exercise.entities.medicine;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class Patient {

	private long id;
	private String lastName;
	private String address;
	private Date birthDay;
	private List<Diagnosis> diagnoses;

}
