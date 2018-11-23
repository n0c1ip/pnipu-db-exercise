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
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@//192.168.0.11:1521/orcl");
		dataSource.setUsername("dispanser");
		dataSource.setPassword("dispanser");
		return dataSource;
	}

}
