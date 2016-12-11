package db.exercise.dao.jdbc.cinema;

import db.exercise.dao.mapper.cinema.ThemeMapper;
import db.exercise.entities.cinema.Theme;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ThemeDaoJdbc {

	private static final String query = "SELECT * FROM movie_themes";

	@Autowired
	@Qualifier(value = "cinemaTemplate")
	private JdbcTemplate jdbcTemplate;

	public List<Theme> findAll(){
		return jdbcTemplate.query(query, new ThemeMapper());
	}


}