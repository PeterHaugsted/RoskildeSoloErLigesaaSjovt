import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class forsideController implements appContact {

    @FXML
    private appHandler app;

    @Override
    public void setApp(appHandler apphandler) {
        this.app = apphandler;
    }


    public void LogInR(MouseEvent mouseEvent) throws IOException {
        app.loginR();
    }


    public void LogInV(MouseEvent mouseEvent) throws IOException {
        app.loginV();
    }


}
