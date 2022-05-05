import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

import static javafx.scene.paint.Color.GREEN;
import static javafx.scene.paint.Color.RED;


public class CreateShiftsController implements AppContact {

    @FXML
    private APPHANDLER app;

    @Override
    public void setApp(APPHANDLER app) {
        this.app = app;
    }

    public void GoBackMenuR(MouseEvent mouseEvent) throws IOException {
        app.GoBackToRmenu();
    }

    public void logout(MouseEvent mouseEvent) throws IOException {
        app.logout1();
    }

    public Label foundor;
    public TextField fullname;
    public DatePicker date;
    public TextField hours;
    public TextField task;
    public Label succesfully;

    public void confirm(MouseEvent mouseEvent) throws IOException {


        String name = fullname.getText();



        User user = Database.getUserFromName(name);
        if (user != null) {
            foundor.setText("Person found!");
            foundor.setTextFill(GREEN);

        } else {
            foundor.setText("Person not found in system");
            foundor.setTextFill(RED);
        }
    }

    public void submitS(MouseEvent mouseEvent) throws IOException {
        String navn = fullname.getText();
        addshift(navn);
    }

    public void addshift(String name) throws IOException {
        LocalDate dato = date.getValue();
        String task1 = task.getText();
        String timer = hours.getText();

        User user = Database.getUserFromName(name);
        if (user == null) {
            succesfully.setText("User not found");
        } else {
            Shift shift = new Shift(dato.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), task1, timer, user);
            user.addShift(shift);
            succesfully.setText("Shift added");
        }
    }
}



