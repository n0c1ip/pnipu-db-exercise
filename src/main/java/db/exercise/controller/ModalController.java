package db.exercise.controller;

import db.exercise.controller.medicine.PatientCardController;
import db.exercise.entities.Patient;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class ModalController {

	private Stage primaryStage;
	private MainController mainController;

	public ModalController(Stage primaryStage, MainController mainController) {
		this.primaryStage = primaryStage;
		this.mainController = mainController;
	}

	public void showPatientEditDialog(String title, Patient patient) {
		final Stage dialog = new Stage();
		dialog.getIcons().add(new Image("/pic/app_icon.png"));
		try {
			dialog.setTitle(title);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(primaryStage);
			dialog.setResizable(false);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/patientCard.fxml"));
			AnchorPane patientCard = loader.load();
			PatientCardController controller = loader.getController();
			controller.setPatient(patient);
			dialog.setScene(new Scene(patientCard));
			dialog.showAndWait();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
