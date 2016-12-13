package db.exercise.entities.boats;

import java.util.Date;

public class Rent {
  private Long id;
  private Client client;
  private Transport transport;
  private Water water;
  private Date rentedAt;
  private Date rentedTo;
  private Briefing briefing;
  private Boolean briefing_done;

}
