package mvc.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import mvc.controller.BtnLogin;
import mvc.controller.BtnSing;

public class LoginStage extends Stage {
        private static LoginStage instance;

        private Label lbUsername = new Label("Username: 👇");
        private TextField txUser = new TextField();

        private Label lbPassword = new Label("Password: ⏬");
        private PasswordField psPassword = new PasswordField();

        private Button btnLogin = new Button("Log in");
        private Button btnSing = new Button("Sign up");

        private LoginStage() {
                init();
        }

        public static LoginStage getInstance() {
                if (instance == null) {
                        instance = new LoginStage();
                }
                return instance;
        }

        private void init() {
                super.setTitle("Sign up");


                btnSing.setOnAction(new BtnSing(this));
                btnLogin.setOnAction(new BtnLogin(this));

                txUser.setPromptText("Email...");
                psPassword.setPromptText("Password...");


                ImageView logo = new ImageView(new Image("file:E:\\OOP-zadaci\\Aplikacija\\WhatsApp Image 2024-08-28 at 17.28.37_44620e20.jpg"));
                logo.setFitWidth(100);
                logo.setFitHeight(100);
                logo.setPreserveRatio(true);

                // Create a circular clip
                Circle clip = new Circle(50, 50, 50);
                logo.setClip(clip);


                GridPane gridPane = new GridPane();
                gridPane.addColumn(0, lbUsername, txUser);
                gridPane.addColumn(1, lbPassword, psPassword);
                gridPane.setAlignment(Pos.CENTER);
                gridPane.setPadding(new Insets(30, 20, 30, 20));
                gridPane.setVgap(10);
                gridPane.setHgap(10);
                gridPane.setStyle("-fx-background-color: #2E4053; -fx-background-radius: 10;");

                styleLabel(lbUsername);
                styleLabel(lbPassword);


                styleTextField(txUser);
                styleTextField(psPassword);


                styleButton(btnLogin, "#4CAF50", "#FFFFFF");
                styleButton(btnSing, "#2196F3", "#FFFFFF");

                VBox root = new VBox();
                root.setAlignment(Pos.CENTER);
                root.setSpacing(20);
                root.getChildren().addAll(logo, gridPane, btnLogin, btnSing);
                root.setPadding(new Insets(20));


                StackPane stackPane = new StackPane();
                stackPane.getChildren().addAll(root);

                Scene scene = new Scene(stackPane, 400, 500);
                super.setScene(scene);
        }

        private void styleLabel(Label label) {
                label.setFont(Font.font("Arial", FontWeight.BOLD, 16));
                label.setTextFill(Color.WHITE);
                label.setEffect(new DropShadow(5, Color.BLACK));
        }

        private void styleTextField(TextField textField) {
                textField.setPrefWidth(250);
                textField.setStyle("-fx-font-size: 14px; -fx-background-radius: 5; -fx-padding: 8px; -fx-border-color: white; -fx-border-radius: 5;");
                textField.setEffect(new DropShadow(5, Color.BLACK));
        }

        private void styleButton(Button button, String bgColor, String textColor) {
                button.setFont(Font.font("Arial", FontWeight.BOLD, 14));
                button.setStyle("-fx-background-color: " + bgColor + "; -fx-text-fill: " + textColor + "; -fx-background-radius: 10;");
                button.setPrefSize(150, 40);
                button.setEffect(new DropShadow(5, Color.BLACK));
        }

        public TextField getTxUser() {
                return txUser;
        }

        public PasswordField getPsPassword() {
                return psPassword;
        }
}
