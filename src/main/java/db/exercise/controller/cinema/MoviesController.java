package db.exercise.controller.cinema;

import db.exercise.dao.jdbc.cinema.MovieDaoJdbc;
import db.exercise.entities.cinema.Movie;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.text.SimpleDateFormat;

public class MoviesController {

	private MovieDaoJdbc movieDaoJdbc;

	@FXML
	private TableView<Movie> tableView;
	@FXML
	public TableColumn<Movie, Long> id;
	@FXML
	public TableColumn<Movie, String> title;
	@FXML
	public TableColumn<Movie, Long> director;
	@FXML
	public TableColumn<Movie, String> date;
	@FXML
	public TableColumn<Movie, Long> country;
	@FXML
	public TableColumn<Movie, Integer> seriesCount;
	@FXML
	public TableColumn<Movie, Long> theme;

	private SimpleDateFormat sf = new SimpleDateFormat("yyyy");


	@FXML
	private void initialize() {
		id.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getId()));
		title.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTitle()));
		director.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getDirector()));
		date.setCellValueFactory(param -> new SimpleObjectProperty<>(sf.format(param.getValue().getCreatedDate())));
		country.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getCountry()));
		seriesCount.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getSeriesCount()));
		theme.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getTheme()));
	}

	public void setMovieDaoJdbc(MovieDaoJdbc movieDaoJdbc) {
		this.movieDaoJdbc = movieDaoJdbc;
		tableView.setItems(FXCollections.observableArrayList(movieDaoJdbc.findAll()));
	}


}
