package db.exercise.entities.storage;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supply {

	private long id;
	private Truck truckId;
	private Product productId;
	private Storage storageId;
	private Integer count;

}
