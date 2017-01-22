package db.exercise.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
public class Research {

	private Date date;
	private String title;
	private Patient patient;
	private Doctor doctor;
	private String result;
	private int type;

}
