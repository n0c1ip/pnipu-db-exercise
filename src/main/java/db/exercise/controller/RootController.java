package db.exercise.controller;


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

	public void showPatientsTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/patients.fxml"));
			Pane table = loader.load();
			PatientController controller = loader.getController();
			controller.setDaoJdbc(applicationContext.getBean(PatientDaoJdbc.class),
					 			  applicationContext.getBean(DiagnosisDaoJdbc.class),
								  applicationContext.getBean(ResearchDaoJdbc.class));
			controller.setMainController(mainController);
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Реестр пациентов");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
	}

	public void showDoctorsTable() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/doctors.fxml"));
			Pane table = loader.load();
			DoctorController controller = loader.getController();
			controller.setDoctorDaoJdbc(applicationContext.getBean(DoctorDaoJdbc.class));
			controller.setMainController(mainController);
			tabLayout = (TabPane) mainController.getRootLayout().getCenter();
			Tab tab = new Tab("Реестр врачей");
			tab.setContent(table);
			tabLayout.getTabs().add(tab);
		} catch (IOException ex) {
			ex.getMessage();
		}
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


