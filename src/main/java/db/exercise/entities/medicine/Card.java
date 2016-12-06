package db.exercise.entities.medicine;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Card {

	private String patientName;
	private String doctorName;
	private Date visitDate;
	private String diseaseTitle;

}
