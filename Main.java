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

// Label modules
import javafx.scene.control.Label;

// ========================================================================================

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();
        
        // (VB) Wifi Monster - Image
        Image monster = new Image(getClass().getResourceAsStream("src/monster.jpeg"));
        ImageView image_view = new ImageView(monster);
        image_view.setFitWidth(300);
        image_view.setPreserveRatio(true);
        
        VBox image_box = new VBox(image_view);
        
        // (HB) Select Wifi Adapter - Label & Wifi Adapter - ComboBox 
        Label select_wifi_adapter = new Label("Select wifi adapter: ");
        
        String[] items = { "ec1", "ec2", "ec3" };
        ComboBox<String> wifi_adapter_cb = new ComboBox<>();
        wifi_adapter_cb.getItems().addAll(items);
        
        HBox adapter_box = new HBox(5);
        adapter_box.getChildren().addAll(select_wifi_adapter, wifi_adapter_cb);
        
        // Layout Arrangement
        HBox main_box = new HBox(150);
        main_box.getChildren().addAll(image_box, adapter_box);
         
        adapter_box.setAlignment(javafx.geometry.Pos.CENTER);
        image_box.setAlignment(javafx.geometry.Pos.CENTER);
        
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