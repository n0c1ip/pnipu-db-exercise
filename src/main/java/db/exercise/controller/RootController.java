package db.exercise.controller;


import db.exercise.controller.medicine.*;
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

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
	}

	public void showMedicineTables() {
		showDoctorTable();
		showPatientsTable();
		showDiagnosisTable();
		showVisitsTable();
		showDiseasesTable();
		showCardTable();
	}

	public void closeAllTabs(){
		tabLayout.getTabs().remove(0, tabLayout.getTabs().size());

	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
}
