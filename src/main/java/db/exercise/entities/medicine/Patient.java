package db.exercise.entities.medicine;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Patient {

	private String lastName;
	private String address;
	private Date birthDay;

}
