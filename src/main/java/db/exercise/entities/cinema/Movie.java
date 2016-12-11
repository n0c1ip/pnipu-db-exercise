package db.exercise.entities.cinema;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

	private long id;
	private String title;
	private long director;
	private Date createdDate;
	private long country;
	private Integer seriesCount;
	private long theme;

}
