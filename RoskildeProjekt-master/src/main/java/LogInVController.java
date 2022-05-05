import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LogInVController implements AppContact {

    @FXML
    private APPHANDLER app;

    @Override
    public void setApp(APPHANDLER apphandler) {
        this.app = apphandler;
    }

    public TextField username;
    public PasswordField password;
    public Label login;
    public static String usernameuse;


    public void back(MouseEvent mouseEvent) throws IOException {
        app.GoBackToChooseRorV();
    }


    public void logininfo(MouseEvent mouseEvent) throws IOException {
        String passworduse = password.getText();
        usernameuse = username.getText();

        User user = Database.getUserFromName(usernameuse);
        if (user != null && !user.isResponsible()){
            if (user.getPassword().equals(passworduse)){
                app.OpenStartV();
            }
                login.setText("Wrong username or password");
                login.setTextFill(Color.web("#FF0000"));
        }
            login.setText("Wrong username or password");
            login.setTextFill(Color.web("#FF0000"));
    }

}



