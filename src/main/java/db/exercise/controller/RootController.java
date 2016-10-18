package db.exercise.controller;


import db.exercise.controller.medicine.DoctorController;
import db.exercise.controller.medicine.PatientController;
import db.exercise.dao.jdbc.medicine.DoctorDaoJdbc;
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
			controller.setDoctorDaoJdbc(applicationContext.getBean(DoctorDaoJdbc.class));
			controller.setMainController(mainController);
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Patients");
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
	}

	public void closeAllTabs(){
		tabLayout.getTabs().remove(0, tabLayout.getTabs().size());

	}

	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}
}
