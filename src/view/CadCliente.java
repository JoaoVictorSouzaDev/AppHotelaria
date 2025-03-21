package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;



public class CadCliente extends Application {

    @Override
    public void start(Stage stage) throws Exception {

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
        TextField txtCpf = createMaskField("###.###.###-##");
        txtCpf.setMaxWidth(200);

        Label lblTelefone = new Label("Telefone");
        TextField txtTelefone = createMaskField("(##) #####-####");
        txtTelefone.setMaxWidth(200);

        Label lblEmail = new Label("Email");
        TextField txtEmail = new TextField();
        txtEmail.setMinWidth(200);

        ComboBox emailOpt = new ComboBox();
        emailOpt.getItems().addAll("@gmail.com", "@email.com","@yahoo.com");
        emailOpt.setMinWidth(120);

        GridPane gridEmail = new GridPane();
        gridEmail.add(txtEmail, 1, 0);
        gridEmail.add(emailOpt, 2, 0);
        gridEmail.setMaxWidth(200);

        GridPane fromGrid = new GridPane();
        fromGrid.setAlignment(Pos.CENTER);
        fromGrid.add(lblNome,0, 0);
        fromGrid.add(txtNome, 1, 0);
        fromGrid.add(lblCpf, 0, 1);
        fromGrid.add(txtCpf, 1, 1);
        fromGrid.add(lblTelefone, 0, 2);
        fromGrid.add(txtTelefone, 1, 2);
        fromGrid.add(lblEmail, 0, 3);
        fromGrid.add(gridEmail, 1, 3);
        fromGrid.setHgap(10);
        fromGrid.setVgap(10);

        Button btnCadastrar = new Button("Cadastrar", iconCadastrar);
        btnCadastrar.setMaxWidth(105);
        Button btnAtualizar = new Button("Atualizar",iconAtualizar);
        btnAtualizar.setMaxWidth(105);
        Button btnExcluir = new Button("Excluir",iconExcluir);
        btnExcluir.setMaxWidth(105);

        HBox buttonsBox = new HBox (btnAtualizar, btnCadastrar, btnExcluir);
        buttonsBox.setPadding(new Insets(20,20,20,20));
        buttonsBox.setSpacing(20);
        buttonsBox.setAlignment(Pos.CENTER);

        VBox layout = new VBox(tituloBox, fromGrid, buttonsBox);
        layout.setAlignment(Pos.CENTER);
        StackPane root = new StackPane();
        root.getChildren().addAll(layout);

        Scene scene = new Scene(root, 500,700);
        stage.setTitle("Cadastro de Cliente");
        stage.setScene (scene);
        stage.show();
    }

    private TextField createMaskField(String mask) {
        TextField txtMask = new TextField();
        txtMask.textProperty().addListener((observable, oldValue, newValue) -> {
            String value = newValue.replaceAll("[^0-9]", "");
            StringBuilder formatField = new StringBuilder();
            int index = 0;
            for (char caracter : mask.toCharArray()) {
                if (caracter == '#') {
                    if (index < value.length()) {
                        formatField.append(value.charAt(index));
                        index++;
                    } else {
                        break;
                    }
                } else {
                    formatField.append(caracter);
                }
            }
            txtMask.setText(formatField.toString());
        });
        return txtMask;
    }

    public static void main(String[] args) {
        launch(args);
    }
}