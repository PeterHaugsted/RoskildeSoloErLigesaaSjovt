import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class APPHANDLER extends Application {

    Scene sceneStart;
    private Stage stageStart;

    @Override
    public void start(Stage stage) throws Exception {
        Database.loadVolunteerDataFromFileToUsers();
        FXMLLoader fxmlLoader = new FXMLLoader(APPHANDLER.class.getResource("/Forside.fxml"));
        sceneStart = fxmlLoader.load();
        ForsideController controllerstart = fxmlLoader.getController();
        controllerstart.setApp(this);
        stage.setScene(sceneStart);
        stage.show();
        this.stageStart = stage;
    }


    public void changescnen(String gui) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(gui));
        Scene load = loader.load();
        AppContact controller = (AppContact) loader.getController();
        controller.setApp(this);
        stageStart.setScene(load);
    }

    public static void run() {
        launch();
    }

    public void loginR() throws IOException {
        changescnen("LogInR.fxml");
    }

    public void OpenStartR() throws IOException {
        changescnen("RESPONSIBLE_MENU.fxml");
    }

    public void GoBackToChooseRorV() throws IOException {
        changescnen("Forside.fxml");
    }

    public void logout1() throws IOException {
        changescnen("Forside.fxml");
    }

    public void CreateV() throws IOException {
        changescnen("CreateVolunteer.fxml");
    }

    public void CreateShift() throws IOException {
        changescnen("CreateShifts.fxml");
    }

    public void EditShifts() throws IOException {
        changescnen("EditShifts.fxml");
    }

    public void EditV() throws IOException {
        changescnen("EDITVOLUNTEER.fxml");
    }

    public void GoBackToRmenu() throws IOException {
        changescnen("RESPONSIBLE_MENU.fxml");
    }

    public void CreateBod() throws IOException {
        changescnen("CreateBod.fxml");
    }

    public void CheckUp() throws IOException {
        changescnen("CheckUp.fxml");
    }

    public void loginV() throws IOException {
        changescnen("LogInV.fxml");
    }

    public void OpenStartV() throws IOException {
        changescnen("VOLUNTEER_MENU.fxml");
    }

    public void MyInfo() throws IOException {
        changescnen("MyInfo.fxml");
    }

    public void GoBackToVMenu() throws IOException {
        changescnen("VOLUNTEER_MENU.fxml");
    }

    public void ContactR() throws IOException {
        changescnen("contactR.fxml");
    }

    public void ChangePass() throws IOException{
        changescnen("ChangePass.fxml");
    }
}