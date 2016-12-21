package db.exercise.entities.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Truck {

	private long id;
	private String model;
	private Owner ownerId;
	private Integer capacity;

}
