package db.exercise.controller;


import db.exercise.controller.cinema.*;
import db.exercise.controller.medicine.*;
import db.exercise.dao.jdbc.cinema.*;
import db.exercise.dao.jdbc.medicine.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;
import org.springframework.context.ApplicationContext;

import java.io.IOException;

public class RootController {

	private MainController mainController;
	private TabPane tabLayout;
	private ApplicationContext applicationContext;


	//TABLES MEDICINE
	public void showDoctorTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/doctors.fxml"));
			Pane table = loader.load();
			DoctorController controller = loader.getController();
			controller.setDoctorDaoJdbc(applicationContext.getBean(DoctorDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Doctors");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showPatientsTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/patients.fxml"));
			Pane table = loader.load();
			PatientController controller = loader.getController();
			controller.setDoctorDaoJdbc(applicationContext.getBean(PatientDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Patients");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showDiagnosisTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/diagnoses.fxml"));
			Pane table = loader.load();
			DiagnosisController controller = loader.getController();
			controller.setDiagnosisDaoJdbc(applicationContext.getBean(DiagnosisDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Diagnosis");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showVisitsTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/visits.fxml"));
			Pane table = loader.load();
			VisitController controller = loader.getController();
			controller.setVisitDaoJdbc(applicationContext.getBean(VisitDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Visits");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showDiseasesTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/diseases.fxml"));
			Pane table = loader.load();
			DiseaseController controller = loader.getController();
			controller.setDiseaseDaoJdbc(applicationContext.getBean(DiseaseDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Diseases");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showCardTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/card.fxml"));
			Pane table = loader.load();
			CardController controller = loader.getController();
			controller.setCardDaoJdbc(applicationContext.getBean(CardDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Card");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	//TABLES CINEMA
	public void showCinemaTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/cinemas.fxml"));
			Pane table = loader.load();
			CinemaController controller = loader.getController();
			controller.setCinemaDaoJdbc(applicationContext.getBean(CinemaDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Cinemas");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showMoviesTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/movies.fxml"));
			Pane table = loader.load();
			MoviesController controller = loader.getController();
			controller.setMovieDaoJdbc(applicationContext.getBean(MovieDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Movies");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showShowsTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/shows.fxml"));
			Pane table = loader.load();
			ShowsController controller = loader.getController();
			controller.setShowDaoJdbc(applicationContext.getBean(ShowDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Shows");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showDirectorsTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/directors.fxml"));
			Pane table = loader.load();
			DirectorsController controller = loader.getController();
			controller.setMovieDaoJdbc(applicationContext.getBean(DirectorDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Directors");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showThemeTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/themes.fxml"));
			Pane table = loader.load();
			ThemesController controller = loader.getController();
			controller.setThemeDaoJdbc(applicationContext.getBean(ThemeDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Themes");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showTypesTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/types.fxml"));
			Pane table = loader.load();
			TypesController controller = loader.getController();
			controller.setTypeDaoJdbc(applicationContext.getBean(TypeDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Types");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showCountriesTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/countries.fxml"));
			Pane table = loader.load();
			CountriesController controller = loader.getController();
			controller.setCountryDaoJdbc(applicationContext.getBean(CountryDaoJdbc.class));
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Countries");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	//BUTTONS
	public void showMedicineTables() {
		showDoctorTable();
		showPatientsTable();
		showDiseasesTable();
		showVisitsTable();
		showDiagnosisTable();
		showCardTable();
	}

	public void showCinemaTables() {
		showDirectorsTable();
		showThemeTable();
		showCountriesTable();
		showCinemaTable();
		showMoviesTable();
		showShowsTable();
		showTypesTable();
	}

	public void closeAllTabs(){
		tabLayout.getTabs().remove(0, tabLayout.getTabs().size());

	}

	//REFS
	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
}
