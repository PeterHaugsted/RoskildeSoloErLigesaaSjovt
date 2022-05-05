import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.security.SecureRandom;
import java.util.Objects;
import java.util.Random;

import static javafx.scene.paint.Color.GREEN;

public class CreateVController implements AppContact {


    @FXML
    private APPHANDLER app;

    @Override
    public void setApp(APPHANDLER apphandler) {
        this.app = apphandler;
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        app.logout1();
    }

    public void GoBackMenuR(MouseEvent mouseEvent) throws IOException {
        app.GoBackToRmenu();
    }

    public TextField name;
    public TextField email;
    public TextField phonenr;
    public TextField address;
    public Label missing;
    public Label auto;
    public Label password;


    public void submit(MouseEvent mouseEvent) throws IOException {
        String name1 = name.getText();
        String email1 = email.getText();
        String phonenr1 = phonenr.getText();
        String address1 = address.getText();
        String password1;


        if (Objects.equals(name1, "") || Objects.equals(email1, "") || Objects.equals(phonenr1, "") || Objects.equals(address1, "")) {
            missing.setText("Missing information!");
        } else {
            //password gen
            char[] characters = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
            Random random = new SecureRandom();
            StringBuilder pass = new StringBuilder();
            for (int i = 0; i < 5; i++) {
                pass.append(characters[random.nextInt(characters.length)]);
            }

            password1 = String.valueOf(pass); //setup password

            User user = new User(name1, email1, phonenr1, address1, password1);//new user
            Database.addV(user);
            //display to user
            password.setText(String.valueOf(pass));
            auto.setText("Auto Generated Password:");
            missing.setTextFill(GREEN);
            missing.setText("Volunteer Created Successfully!");

        }
    }
}
