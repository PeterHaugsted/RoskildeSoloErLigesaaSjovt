import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;


import java.io.IOException;

public class editShiftsController implements appContact {

    @Override
    public void setApp(appHandler app) {
        this.app = app;
        ObservableList<Shift> list = FXCollections.observableArrayList(Database.getOBSShift());
        name.setCellValueFactory(new PropertyValueFactory("volunteer"));
        date.setCellValueFactory(new PropertyValueFactory("date"));
        task.setCellValueFactory(new PropertyValueFactory("task"));
        time.setCellValueFactory(new PropertyValueFactory("time"));
        table.setItems(List);
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


}



