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

// Font modules
import javafx.scene.text.Font;

// ========================================================================================

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

		// Fonts
		//Font title_fontt = Font.loadFont(getClass().getResourceAsStream("fonts/font1.ttf"), 30);
		//Font title_font = Font.loadFont(getClass().getResourceAsStream("fonts/font3.ttf"), 30);
        
        // (VB) Wifi Monster - Image
        Image monster = new Image(getClass().getResourceAsStream("src/test_banner.png"));
        ImageView image_view = new ImageView(monster);
        image_view.setFitWidth(700);
        image_view.setPreserveRatio(true);
        
        VBox image_box = new VBox(image_view);
        
        // (HB) Select Wifi Adapter - Label & Wifi Adapter - ComboBox 
        Label select_wifi_adapter = new Label("Select wifi adapter: ");
        
        String[] items = { "ec1", "ec2", "ec3" };
        ComboBox<String> wifi_adapter_cb = new ComboBox<>();
        wifi_adapter_cb.getItems().addAll(items);
        
        HBox adapter_box = new HBox(5);
        adapter_box.getChildren().addAll(select_wifi_adapter, wifi_adapter_cb);
        
        // (HB) Select Wifi Adapter - Label & Wifi Adapter - ComboBox 
        
        // Layout Arrangement
        VBox main_box = new VBox(150);
        main_box.getChildren().addAll(image_box, adapter_box);
        main_box.setAlignment(javafx.geometry.Pos.CENTER);
        
        adapter_box.setAlignment(javafx.geometry.Pos.CENTER);
        image_box.setAlignment(javafx.geometry.Pos.CENTER);
             
        // Root Properties
        root.getChildren().addAll(main_box);
        root.setStyle("-fx-background-color: #fe8568;");
        
        Scene scene = new Scene(root, 750, 700);
        primaryStage.setTitle("PayDOS");
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("src/icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}