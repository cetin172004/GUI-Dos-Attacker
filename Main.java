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

// TextField modules
import javafx.scene.control.TextField;

// Button modules
import javafx.scene.control.Button;

// IOException
import java.io.IOException;

// File Reader
import java.io.BufferedReader;
import java.io.FileReader;

// ========================================================================================

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

		// Fonts
		Font font1 = Font.loadFont(getClass().getResourceAsStream("fonts/font2.ttf"), 20);
		Font font2 = Font.loadFont(getClass().getResourceAsStream("fonts/font2.ttf"), 40);
		
		// (VB) Title
		Label title = new Label("PayDOS aircrack-ng");
		title.setFont(font2);
		
		VBox title_box = new VBox(title);
		
        // (VB) Wifi Monster - Image
        Image monster = new Image(getClass().getResourceAsStream("src/image.jpeg"));
        ImageView image_view = new ImageView(monster);
        image_view.setFitWidth(400);
        image_view.setPreserveRatio(true);
        
        VBox image_box = new VBox(image_view);
        
        // (VB) Select Wifi Adapter & Select Wireless Network & Enter Number of Deauth
        
        Label select_wifi_adapter = new Label("Select wifi adapter: ");
        select_wifi_adapter.setFont(font1);
        select_wifi_adapter.setStyle("-fx-text-fill: #021526;");
        
        Label select_wireless_network = new Label("Select wireless network: ");
        select_wireless_network.setFont(font1);
        select_wireless_network.setStyle("-fx-text-fill: #021526;");
        
        Label enter_deauth_number = new Label("Enter number of deauth: ");
        
        enter_deauth_number.setFont(font1);
        enter_deauth_number.setStyle("-fx-text-fill: #021526;");
        
        VBox label_box = new VBox(40);
        label_box.getChildren().addAll(select_wifi_adapter, select_wireless_network, enter_deauth_number);
        
        // (VB) Wifi Adapter & Wireless Network & Deauth Area
        
        String[] adapter_items = { "Please scan first" };
        ComboBox<String> wifi_adapter_cb = new ComboBox<>();
        wifi_adapter_cb.getItems().addAll(adapter_items);
        wifi_adapter_cb.setValue("Please scan first");
        wifi_adapter_cb.setStyle("-fx-font-family: '" + font1.getName() + "'; -fx-font-size: 20px; -fx-background-radius: 50; -fx-background-color: white;");
        wifi_adapter_cb.setPrefWidth(300);
        
        String[] wifi_items = { "Please scan first" };
        ComboBox<String> wireless_network_cb = new ComboBox<>();
        wireless_network_cb.getItems().addAll(wifi_items);
        wireless_network_cb.setValue("Please scan first");
        wireless_network_cb.setStyle("-fx-font-family: '" + font1.getName() + "'; -fx-font-size: 20px; -fx-background-radius: 50; -fx-background-color: white;");
        wireless_network_cb.setPrefWidth(300);
        
        TextField deauth_area = new TextField();
        deauth_area.setPromptText("Enter a number");
        deauth_area.setStyle("-fx-font-family: '" + font1.getName() + "'; -fx-font-size: 20px; -fx-background-radius: 50; -fx-background-color: white;");
        deauth_area.setPrefWidth(300);
        
        VBox cb_box = new VBox(25);
        cb_box.getChildren().addAll(wifi_adapter_cb, wireless_network_cb, deauth_area);
        
        // (HB) Start Button & Scan Button
        Button start_button = new Button("Start Attack");
        start_button.setFont(font1);
        start_button.setStyle("-fx-text-fill: #021526; -fx-background-color: white;");
        start_button.setPrefWidth(300);
        
        Button scan_button = new Button("Scan");
        scan_button.setFont(font1);
        scan_button.setStyle("-fx-text-fill: #021526; -fx-background-color: white;");
        scan_button.setPrefWidth(300);
        
        scan_button.setOnAction(event -> {
            try {
				ProcessBuilder processBuilder = new ProcessBuilder("bash", "scan.sh");
				Process process = processBuilder.start();
				process.waitFor();
			
				wifi_adapter_cb.getItems().clear();
				BufferedReader br = new BufferedReader(new FileReader("interfaces"));
				String line;
				boolean is_first = false;
				while ((line = br.readLine()) != null) {
					if (is_first == true) {
						wifi_adapter_cb.getItems().addAll(line);
					} else {
						wifi_adapter_cb.getItems().addAll(line);
						is_first = true;
						wifi_adapter_cb.setValue(line);
					}
				
				}
			
				wireless_network_cb.getItems().clear();
				BufferedReader br2 = new BufferedReader(new FileReader("networks"));
				String line2;
				boolean is_first2 = false;
				while ((line2 = br2.readLine()) != null) {
					wireless_network_cb.getItems().addAll(line2);
				}
			
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
    
        });
        
        HBox button_box = new HBox(10);
		button_box.getChildren().addAll(start_button, scan_button);
		
        // Layout Arrangement
        HBox panel_box = new HBox(20);
        panel_box.getChildren().addAll(label_box, cb_box);
        panel_box.setAlignment(javafx.geometry.Pos.CENTER);
        
		VBox settings_box = new VBox(30);
        settings_box.getChildren().addAll(panel_box, button_box);
		settings_box.setAlignment(javafx.geometry.Pos.CENTER);
        
        VBox side_box = new VBox(60);
        side_box.getChildren().addAll(title_box, settings_box);
		side_box.setAlignment(javafx.geometry.Pos.CENTER);
        
        image_box.setAlignment(javafx.geometry.Pos.CENTER);
        
        button_box.setAlignment(javafx.geometry.Pos.CENTER);
        
        title_box.setAlignment(javafx.geometry.Pos.CENTER);
        
        HBox main_box = new HBox(5);
        main_box.getChildren().addAll(image_box, side_box);
             
        // Root Properties
        root.getChildren().addAll(main_box);
        root.setStyle("-fx-background-color: #fac74a;");
        
        Scene scene = new Scene(root, 1050, 500);
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