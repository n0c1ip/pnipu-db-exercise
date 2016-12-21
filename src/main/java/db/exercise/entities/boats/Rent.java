package db.exercise.entities.boats;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Rent {

  private String client;
  private String title;
  private String type;
  private String water;
  private java.sql.Timestamp rented_at;
  private java.sql.Timestamp rented_to;

}
