import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.io.IOException;
import java.util.ArrayList;

public class editShiftsController implements appContact {

    public Label taskFound;
    public Button taskDeleteButton;
    public TextField taskSearch;

    @Override
    public void setApp(appHandler app) {
        this.app = app;
        ObservableList<Shift> list = FXCollections.observableArrayList(Database.getOBSShift());
        name.setCellValueFactory(new PropertyValueFactory("volunteer"));
        date.setCellValueFactory(new PropertyValueFactory("date"));
        task.setCellValueFactory(new PropertyValueFactory("task"));
        time.setCellValueFactory(new PropertyValueFactory("time"));
        table.setItems(list);
    }

    @FXML
    public appHandler app;

    @FXML
    public TableView<Shift> table;

    @FXML
    public TableColumn<Shift, String> name;

    @FXML
    public TableColumn<Shift, String> date;

    @FXML
    public TableColumn<Shift, String> task;

    @FXML
    public TableColumn<Shift, String> time;

    @FXML
    public void GoBackMenuR(MouseEvent mouseEvent) throws IOException {
        app.GoBackToRmenu();
    }

    @FXML
    public void logout(MouseEvent mouseEvent) throws IOException {
        app.logout1();
    }

    public void List(appHandler app, ObservableList observableList) {

    }


    public void key() {
        //Search function that searches on keypress, find task that is corresponding, and delete it. ignores case.
        ArrayList<Shift> list = Database.getAllShifts();
        table.getItems().clear();
        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).getTask().toLowerCase().contains(taskSearch.getText().toLowerCase())) {
                //Takes every letter and makes it lowercase, list.get is a shift, and inside that, there's a function called get task, get task returns a string.
                //String is made lowercase, compares to what the user types, removes from list, if it doesn't match
                list.remove(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            table.getItems().add(list.get(i));
        }

    }

    public void delete(ActionEvent actionEvent) {
        //The ifstatement checks wheter theres a shift chosen
        //The deletefunction is called and ask for the table to return the shift chosen
        //The  table is then updated with "key"
        if (table.getSelectionModel().getSelectedIndex() != -1) {
            Database.removeShiftForEditShiftComtroller(table.getSelectionModel().getSelectedItem());
            taskSearch.setText("");
            key();
        }
    }
}



