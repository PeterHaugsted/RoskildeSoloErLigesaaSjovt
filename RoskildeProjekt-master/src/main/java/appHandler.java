import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


public class appHandler extends Application {
    //I handle the apps, starting scenes changing scenes and to which.

    Scene sceneStart;
    private Stage stageStart;

    @Override
    public void start(Stage stage) throws Exception {
        Database.loadVolunteerDataFromFileToUsers();
        FXMLLoader fxmlLoader = new FXMLLoader(appHandler.class.getResource("/Forside.fxml"));
        sceneStart = fxmlLoader.load();
        forsideController controllerstart = fxmlLoader.getController();
        controllerstart.setApp(this);
        stage.setScene(sceneStart);
        stage.show();
        this.stageStart = stage;
    }


    public void changeScene(String gui) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(gui));
        Scene load = loader.load();
        appContact controller = (appContact) loader.getController();
        controller.setApp(this);
        stageStart.setScene(load);
    }

    public static void run() {
        launch();
    }

    public void loginR() throws IOException {
        changeScene("LogInR.fxml");
    }

    public void OpenStartR() throws IOException {
        changeScene("RESPONSIBLE_MENU.fxml");
    }

    public void GoBackToChooseRorV() throws IOException {
        changeScene("Forside.fxml");
    }

    public void logout1() throws IOException {
        changeScene("Forside.fxml");
    }

    public void CreateV() throws IOException {
        changeScene("CreateVolunteer.fxml");
    }

    public void CreateShift() throws IOException {
        changeScene("CreateShifts.fxml");
    }

    public void EditShifts() throws IOException {
        changeScene("EditShifts.fxml");
    }

    public void EditV() throws IOException {
        changeScene("EDITVOLUNTEER.fxml");
    }

    public void GoBackToRmenu() throws IOException {
        changeScene("RESPONSIBLE_MENU.fxml");
    }

    public void CreateBod() throws IOException {
        changeScene("CreateBod.fxml");
    }

    public void CheckUp() throws IOException {
        changeScene("CheckUp.fxml");
    }

    public void loginV() throws IOException {
        changeScene("LogInV.fxml");
    }

    public void OpenStartV() throws IOException {
        changeScene("VOLUNTEER_MENU.fxml");
    }

    public void MyInfo() throws IOException {
        changeScene("MyInfo.fxml");
    }

    public void GoBackToVMenu() throws IOException {
        changeScene("VOLUNTEER_MENU.fxml");
    }

    public void ContactR() throws IOException {
        changeScene("contactR.fxml");
    }

    public void ChangePass() throws IOException {
        changeScene("ChangePass.fxml");
    }
}