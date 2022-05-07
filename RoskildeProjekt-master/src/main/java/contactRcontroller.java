import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class contactRcontroller implements appContact {
    //This function is for when a volunteer has problems, and need to contact a responsible


    @FXML
    private appHandler app;

    @Override
    public void setApp(appHandler apphandler) {
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
        //This is the search function integrated with the database
        String name = responsibleName.getText();
        User user = Database.getUserFromName(name);
        if (user != null) {
            responsiblemail.setText(user.geteMail());
            responsiblenumber.setText(user.getTlfNr());
        } else {
            notfound.setText("Responsible not found");
        }
    }
}

