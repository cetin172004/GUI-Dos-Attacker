// Base modules
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

// Image modules
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

// Box modules
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

// ComboBox modules
import javafx.scene.control.ComboBox;

import java.util.Arrays;
import java.util.List;

// ========================================================================================

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        
        // Wifi Monster - Image
        Image monster = new Image(getClass().getResourceAsStream("src/monster.jpeg"));
        ImageView image_view = new ImageView(monster);
        image_view.setFitWidth(300);
        image_view.setPreserveRatio(true);
        
        // Wifi Adapter - ComboBox
        String[] items = { "Seçenek 1", "Seçenek 2", "Seçenek 3" };
        
        ComboBox<String> select_wifi_adapter = new ComboBox<>();
        select_wifi_adapter.getItems().addAll(items);
        
        // Layout Arrangement
        HBox main_box = new HBox(200);
        main_box.getChildren().addAll(image_view, select_wifi_adapter);
        main_box.setAlignment(javafx.geometry.Pos.CENTER);
        
        // Root Properties
        root.getChildren().addAll(main_box);
        root.setStyle("-fx-background-color: #3d758e;");
        
        Scene scene = new Scene(root, 1000, 500);
        primaryStage.setTitle("PayDOS");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("src/app-icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}