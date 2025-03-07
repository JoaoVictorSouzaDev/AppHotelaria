package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;



public class CadCliente extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        StackPane background = new StackPane();
        Image backgroundImage = new Image(getClass().getResourceAsStream("/view/img/BackGround.jpeg"));
        BackgroundImage backGroundImg = new BackgroundImage(backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO,BackgroundSize.AUTO, false, false, true, true)
        );
        background.setBackground(new Background(backGroundImg));

        Rectangle rectangle = new Rectangle(350, 500);
        rectangle.setFill(Color.WHITE);
        rectangle.setArcHeight(60);
        rectangle.setArcWidth(60);
        rectangle.setOpacity(0.8);


        Image iconBtnCadastrar = new Image(getClass().getResourceAsStream("/view/img/mais.png"));
        Image iconBtnAtualizar = new Image(getClass().getResourceAsStream("/view/img/Atualizar.png"));
        Image iconBtnExcluir = new Image(getClass().getResourceAsStream("/view/img/lixo.png"));
        Image iconBtnPessoa = new Image(getClass().getResourceAsStream("/view/img/Pessoa.png"));

        ImageView iconCadastrar = new ImageView(iconBtnCadastrar);
        iconCadastrar.setFitWidth(30);
        iconCadastrar.setFitHeight(30);

        ImageView iconAtualizar = new ImageView(iconBtnAtualizar);
        iconAtualizar.setFitWidth(30);
        iconAtualizar.setFitHeight(30);

        ImageView iconExcluir = new ImageView(iconBtnExcluir);
        iconExcluir.setFitWidth(30);
        iconExcluir.setFitHeight(30);

        ImageView iconPessoa = new ImageView(iconBtnPessoa);
        iconPessoa.setFitWidth(20);
        iconPessoa.setFitHeight(20);

        Label lblTitulo = new Label("Cadastro de Cliente");
        lblTitulo.setAlignment(Pos.CENTER);
        lblTitulo.setStyle("-fx-font-size: 18px; -fx-font-weight: bold");
        HBox tituloBox = new HBox(iconPessoa, lblTitulo);
        tituloBox.setPadding(new Insets(20,20,20,20));
        tituloBox.setAlignment(Pos.CENTER);

        Label lblNome = new Label("Nome");
        TextField txtNome = new TextField();
        txtNome.setMaxWidth(200);

        Label lblCpf = new Label("CPF");
        TextField txtCpf = new TextField();
        txtCpf.setMaxWidth(200);

        Label lblTelefone = new Label("Telefone");
        TextField txtTelefone = new TextField();
        txtTelefone.setMaxWidth(200);

        Label lblEmail = new Label("Email");
        TextField txtEmail = new TextField();
        txtEmail.setMaxWidth(200);

        Button btnCadastrar = new Button("Cadastrar", iconCadastrar);
        btnCadastrar.setMaxWidth(105);
        btnCadastrar.setStyle("-fx-background-color: #006039");
        Button btnAtualizar = new Button("Atualizar",iconAtualizar);
        btnAtualizar.setMaxWidth(105);
        btnAtualizar.setStyle("-fx-background-color: #006039");
        Button btnExcluir = new Button("Excluir",iconExcluir);
        btnExcluir.setMaxWidth(105);
        btnExcluir.setStyle("-fx-background-color: #006039");

        VBox layout = new VBox(10, tituloBox, lblNome, txtNome, lblCpf, txtCpf, lblTelefone, txtTelefone, lblEmail, txtEmail,btnCadastrar, btnAtualizar, btnExcluir);
        layout.setAlignment(Pos.CENTER);
        StackPane root = new StackPane();
        root.getChildren().addAll(background,rectangle, layout);
        Scene scene = new Scene(root, 500,700);
        stage.setTitle("Cadastro de Cliente");
        stage.setScene (scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}