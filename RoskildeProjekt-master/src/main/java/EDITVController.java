import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;

import static javafx.scene.paint.Color.*;

public class EDITVController implements AppContact {


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


    public TextField fullname;
    public TextField email;
    public TextField phonenr;
    public TextField address;
    public String name;
    public Label notfound;
    public String password;
    public Label changedS;
    public Button areyousure;

    public void search(MouseEvent mouseEvent) throws IOException {

        name = fullname.getText();
        User user = Database.getUserFromName(name);
        if (user != null) {
            fullname.setPromptText(user.getName());
            email.setPromptText(user.geteMail());
            phonenr.setPromptText(user.getTlfNr());
            address.setPromptText(user.getAddress());
            notfound.setText("  ");
            notfound.setTextFill(WHITE);

        } else {
            notfound.setText("Person not found in system");
            notfound.setTextFill(RED);
        }
    }

    public void save(MouseEvent mouseEvent) throws IOException {
        String newName = fullname.getText();
        String newEMail = email.getText();
        String newNumber = phonenr.getText();
        String newAddress = address.getText();

        redigerP(newName, newEMail, newNumber, newAddress);

    }

    public void redigerP(String name, String eMail, String number, String address) {
        User user = Database.getUserFromName(name);
        if (user != null) {
            user.setName(name);
            user.seteMail(eMail);
            user.setTlfNr(number);
            user.setAddress(address);
            Database.saveVToFile();
            changedS.setText("Information changed succesfully!");
            changedS.setTextFill(GREEN);
        } else {
            changedS.setText("Person not found, ERROR");
            changedS.setTextFill(RED);
        }




    }

    public void delete(MouseEvent mouseEvent) {
        areyousure.setVisible(true);
    }

    public void SLET(MouseEvent mouseEvent) throws IOException {

        sletperson(name);
    }

    public void sletperson(String name) {
        User user = Database.getUserFromName(name);
        if (user != null) {
            Database.removePerson(user);
            changedS.setText("Person deleted successfully");
            changedS.setTextFill(RED);
        } else {
            changedS.setText("User not found");
            changedS.setTextFill(RED);
        }

    }
}
