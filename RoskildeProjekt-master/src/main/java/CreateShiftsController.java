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
    //Here is where a responsible would create a shift

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
            //Here the system searches for the user, if it's in the system, it prints a message

        } else {
            foundor.setText("Person not found in system");
            foundor.setTextFill(RED);
            //This is the errormessage if a person wasn't found
        }
    }

    public void submitS(MouseEvent mouseEvent) throws IOException {
        String navn = fullname.getText();
        addshift(navn);
        //This is where you submit the found name
    }

    public void addshift(String name) throws IOException {
        //This is where I add all the shifts, here we create a date, a task and what hours they should be working
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
            //The date is set up with the "DateTimeFormatter" whereas I set the pattern to specifically be Year, month, date
        }
    }
}



