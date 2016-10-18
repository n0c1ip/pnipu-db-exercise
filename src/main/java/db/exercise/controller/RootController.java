package db.exercise.controller;


import db.exercise.controller.medicine.DoctorController;
import db.exercise.controller.medicine.PatientController;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class RootController {

	private MainController mainController;
	private TabPane tabLayout;


	public void showDoctorTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/doctors.fxml"));
			Pane table = loader.load();
			DoctorController controller = loader.getController();
			controller.setMainController(mainController);
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
}
