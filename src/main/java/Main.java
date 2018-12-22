import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.Toolkit;
import java.util.Objects;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        var screensize = Toolkit.getDefaultToolkit().getScreenSize();
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getClassLoader().getResource("ui/UI.fxml")));

        Scene scene = new Scene(root, screensize.getWidth(), screensize.getHeight());
        scene.getStylesheets().add("ui/UI.css");

        primaryStage.setTitle("Paths");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
