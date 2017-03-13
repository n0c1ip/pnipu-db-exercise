package db.exercise.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class Scheduler {

	private int id;
	private Date date;
	private Doctor doctor;
	private Patient patient;

}
