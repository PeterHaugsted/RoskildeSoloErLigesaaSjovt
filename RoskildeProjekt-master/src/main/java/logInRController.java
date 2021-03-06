import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.IOException;


public class logInRController implements appContact {


    @FXML
    private appHandler app;

    @FXML
    public void setApp(appHandler apphandler) {
        this.app = apphandler;
    }


    public TextField username;
    public PasswordField password;
    public static String usernameuse;
    public Label login;

    public void logininfo(MouseEvent mouseEvent) throws IOException {
        String passworduse = password.getText();
        usernameuse = username.getText();

        User user = Database.getUserFromName(usernameuse);
        if (user != null && user.isResponsible()) {
            if (user.getPassword().equals(passworduse)) {
                app.OpenStartR();
            }
            login.setText("Wrong username or password");
            login.setTextFill(Color.web("#FF0000"));
        }
        login.setText("Wrong username or password");
        login.setTextFill(Color.web("#FF0000"));
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        app.GoBackToChooseRorV();
    }
}