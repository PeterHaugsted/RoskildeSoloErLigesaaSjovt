import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

import java.io.IOException;


public class ForsideController implements AppContact {

    @FXML
    private AppHandler app;

    @Override
    public void setApp(AppHandler apphandler) {
        this.app = apphandler;
    }


    public void LogInR(MouseEvent mouseEvent) throws IOException {
        app.loginR();
    }


    public void LogInV(MouseEvent mouseEvent) throws IOException {
        app.loginV();
    }


}
