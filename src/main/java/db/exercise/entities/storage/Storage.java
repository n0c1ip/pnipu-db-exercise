package db.exercise.entities.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Storage {

	private long id;
	private String titleId;
	private Owner ownerId;
	private Integer capacity;

}
