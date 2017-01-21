package db.exercise.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class DataConfig {

	@Bean
	public JdbcTemplate medicineTemplate() {
		return new JdbcTemplate(medicineDataSource());
	}

	@Bean(name = "medicineDataSource")
	@Primary
	public DataSource medicineDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/dispanser");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}

}
