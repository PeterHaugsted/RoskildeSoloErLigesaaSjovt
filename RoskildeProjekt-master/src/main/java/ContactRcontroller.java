import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ContactRcontroller implements AppContact {


    @FXML
    private APPHANDLER app;

    @Override
    public void setApp(APPHANDLER apphandler) {
        this.app = apphandler;
    }

    public TextField responsibleName;
    public Label responsiblenumber;
    public Label responsiblemail;
    public Label notfound;


    public void logout(MouseEvent mouseEvent) throws IOException {
        app.logout1();
    }

    public void GoBackMenuV(MouseEvent mouseEvent) throws IOException {
        app.GoBackToVMenu();
    }

    public void search(MouseEvent mouseEvent) throws IOException {
        String name = responsibleName.getText();
        User user = Database.getUserFromName(name);
        if (user != null){
            responsiblemail.setText(user.geteMail());
            responsiblenumber.setText(user.getTlfNr());
        } else {
            notfound.setText("Responsible not found");
        }
    }
}

