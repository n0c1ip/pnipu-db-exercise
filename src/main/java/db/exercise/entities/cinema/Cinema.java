package db.exercise.entities.cinema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Cinema {

	private long id;
	private String title;
	private String address;
	private String phone;
	private long type;
	private Integer capacity;
	private Integer hallCount;

}
