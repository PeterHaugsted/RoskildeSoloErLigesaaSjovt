import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.ArrayList;

public class volunteerMenuController implements appContact {


    @FXML
    private appHandler app;

    @Override
    public void setApp(appHandler apphandler) {
        this.app = apphandler;
    }


    public void logout(MouseEvent mouseEvent) throws IOException {
        app.logout1();
    }

    public void myinfo(MouseEvent mouseEvent) throws IOException {
        app.MyInfo();
    }

    public void contactR(MouseEvent mouseEvent) throws IOException {
        app.ContactR();
    }

    public Label shifts;
    public Label shift2;
    public Label shift3;

    public void show1(ActionEvent actionEvent) throws IOException {
        //String username1 = logInVController.usernameuse;
        User user = Database.getUserFromName(logInVController.usernameuse);
        Shift shift = user.getNextShift();
        if (shift != null) {
            shifts.setText("");
            shift2.setText("");
            shift3.setText("");
            shifts.setText(shift.stringToPrint());
        } else {
            shifts.setText("No occurring shift");
        }
    }


    public void show3(ActionEvent actionEvent) throws IOException {
        shifts.setText("");
        shift2.setText("");
        shift3.setText("");
        User user = Database.getUserFromName(logInVController.usernameuse);
        ArrayList<Shift> moreShifts = user.getNext3Shifts();
        switch (moreShifts.size()) {
            case 0:
                shifts.setText("No occurring shift");
                break;
            case 1:
                shifts.setText(moreShifts.get(0).stringToPrint());
                shift2.setText("No occurring shifts");
                break;
            case 2:
                shifts.setText(moreShifts.get(0).stringToPrint());
                shift2.setText(moreShifts.get(1).stringToPrint());
                shift3.setText("No occurring shifts");
                break;
            case 3:
                shifts.setText(moreShifts.get(0).stringToPrint());
                shift2.setText(moreShifts.get(1).stringToPrint());
                shift3.setText(moreShifts.get(2).stringToPrint());
                break;
            default:
                shifts.setText("ERROR");
                break;
        }
    }
}
