package view;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;

public class Login extends Application {

    @Override
    public void start (Stage stage) throws Exception {

        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansRegular.ttf"), 12);
        Font fontSemiBold = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansSemiBold.ttf"), 12);

        String styleSemiBold = "-fx-text-fill: #000000;" +
                "-fx-font-size: 18;" +
                "-fx-font-family: '" + fontSemiBold.getFamily() + "';";

        String styleRegular = "-fx-text-fill: #000000;" +
                "-fx-font-size: 12;" +
                "-fx-font-family: '" + fontRegular.getFamily() + "';";

        StackPane esquerda = new StackPane();
        esquerda.setPrefWidth(400);
        esquerda.setStyle("-fx-background-image: url('/view/resources/img/Hotel.jpeg'); -fx-background-repeat: stretch; -fx-background-size: cover");

        Label lblTitulo = new Label("Faça seu login");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-text-fill: #000000");
        lblTitulo.setFont(Font.font(fontSemiBold.getFamily(), 35));

        Label lblUsuario = new Label("Usuário:");

        TextField txtUsuario = new TextField();
        txtUsuario.setPromptText("Digite seu usuário");

        Label lblSenha = new Label("Senha:");
        lblSenha.setFont(Font.font(fontRegular.getFamily(), 15));

        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");

        Button botaoLogin = new Button("Login");
        botaoLogin.setFont(Font.font(fontRegular.getFamily(), 12));

        GridPane gridForm = new GridPane();
        gridForm.setHgap(10);
        gridForm.setVgap(15);
        gridForm.setAlignment(Pos.CENTER);
        gridForm.add(lblUsuario, 0, 0);
        gridForm.add(txtUsuario, 1, 0);
        gridForm.add(lblSenha, 0, 1);
        gridForm.add(campoSenha, 1, 1);
        gridForm.add(botaoLogin, 1, 2);

        VBox boxLogin = new VBox(20, lblTitulo, gridForm);
        boxLogin.setAlignment(Pos.CENTER);
        boxLogin.setPadding(new Insets(40));
        boxLogin.setStyle("-fx-background-color: #ffffff; -fx-border-radius: 10px; -fx-background-radius: 10px;");
        boxLogin.setPrefWidth(400);
        HBox layoutPrincipal = new HBox(esquerda, boxLogin);

        Scene scene = new Scene(layoutPrincipal, 750,500);
        stage.setTitle("Login");
        stage.setScene (scene);
        stage.setResizable(false);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
