package view;

import controller.UsuariosController;
import javafx.application.Application;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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
                "-fx-font-size: 32;" +
                "-fx-font-family: '" + fontSemiBold.getFamily() + "';";

        String styleRegular = "-fx-text-fill: #000000;" +
                "-fx-font-size: 14;" +
                "-fx-font-family: '" + fontRegular.getFamily() + "';";

        Image eyeOpen = new Image(getClass().getResourceAsStream("/view/resources/img/OlhoAberto.png"));
        Image eyeClosed = new Image(getClass().getResourceAsStream("/view/resources/img/OlhoFechado.png"));

        ImageView viewImgEyeOpen = new ImageView(eyeOpen);
        viewImgEyeOpen.setFitWidth(20);
        viewImgEyeOpen.setFitHeight(20);
        ImageView viewImgEyeClosed = new ImageView(eyeClosed);
        viewImgEyeClosed.setFitWidth(20);
        viewImgEyeClosed.setFitHeight(20);

        StackPane esquerda = new StackPane();
        esquerda.setPrefWidth(400);
        esquerda.setStyle("-fx-background-image: url('/view/resources/img/Hotel.jpeg'); -fx-background-repeat: stretch; -fx-background-size: cover");

        Label lblTitulo = new Label("Faça seu login");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle(styleSemiBold);

        Label lblUsuario = new Label("Usuário:");
        lblUsuario.setStyle(styleRegular);

        TextField txtUsuario = new TextField();
        txtUsuario.setPromptText("Digite seu usuário");

        Label lblSenha = new Label("Senha:");
        lblSenha.setStyle(styleRegular);

        PasswordField campoSenha = new PasswordField();
        campoSenha.setPromptText("Digite sua senha");

        TextField txtSenha = new TextField();
        txtSenha.setPromptText("Digite sua senha");
        txtSenha.setVisible(false);
        txtSenha.setManaged(false);

        StackPane senha123 = new StackPane();
        senha123.setPrefWidth(200);
        senha123.getChildren().addAll(txtSenha, campoSenha);

        Button btnEyeOpen = new Button();
        btnEyeOpen.setGraphic(viewImgEyeOpen);
        btnEyeOpen.setStyle("-fx-background-color: transparent; -fx-cursor: hand;");
        btnEyeOpen.setMaxSize(15,15);

        StackPane.setMargin(btnEyeOpen, new Insets(0, 0, 0, 0));

        final boolean[] clicado = {false};
        btnEyeOpen.setOnMouseClicked(evento -> {
            if (clicado[0]) {
                btnEyeOpen.setGraphic(viewImgEyeClosed);
                campoSenha.setText(txtSenha.getText());
                campoSenha.setVisible(true);
                campoSenha.setManaged(true);
                txtSenha.setVisible(false);
            } else {
                btnEyeOpen.setGraphic(viewImgEyeOpen);
                txtSenha.setText(campoSenha.getText());
                txtSenha.setVisible(true);
                txtSenha.setManaged(true);
                campoSenha.setVisible(false);
            }
            clicado[0] = !clicado[0];
        });

        Button botaoLogin = new Button("Login");
        botaoLogin.setFont(Font.font(fontRegular.getFamily(), 12));
        botaoLogin.setStyle("""
            -fx-background-color: #4b0505;
            -fx-text-fill: white;
            -fx-font-size: 14px;
            -fx-font-weight: bold;
            -fx-background-radius: 20px;
            -fx-padding: 5px 70px;
            -fx-cursor: hand;
        """);

        botaoLogin.setOnAction(evento -> {
            String usuario = txtUsuario.getText();
            String senha = campoSenha.isVisible() ? campoSenha.getText() : txtSenha.getText();

            UsuariosController usuariosController = new UsuariosController();
            boolean loginSucesso = usuariosController.veririficarCredencias(usuario, senha);
            if (loginSucesso) {
                System.out.println("Login efetuado com sucesso!");
            } else {
                System.out.println("Login Invalido");
            }
        });

        GridPane gridForm = new GridPane();
        gridForm.setHgap(10);
        gridForm.setVgap(15);
        gridForm.setAlignment(Pos.CENTER);
        gridForm.add(lblUsuario, 0, 0);
        gridForm.add(txtUsuario, 1, 0);
        gridForm.add(lblSenha, 0, 1);
        gridForm.add(senha123, 1, 1);
        gridForm.add(btnEyeOpen, 2, 1);
        gridForm.add(botaoLogin, 1, 2);

        ColumnConstraints col0 = new ColumnConstraints();
        col0.setPrefWidth(120);
        col0.setHgrow(Priority.NEVER);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPrefWidth(250);
        col1.setHgrow(Priority.ALWAYS);

        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPrefWidth(50);
        col2.setHgrow(Priority.NEVER);

        gridForm.getColumnConstraints().addAll(col0, col1, col2);
        GridPane.setHalignment(botaoLogin, HPos.CENTER);

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
