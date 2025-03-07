package view;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class CadFuncionario extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        Label lblnome = new Label("Nome do Funcionario");
        TextField txtNome = new TextField();
        txtNome.setMaxWidth(200);

        Label lblrg = new Label("RG do Funcionario");
        TextField txtRg = new TextField();
        txtRg.setMaxWidth(200);

        Label lblbox = new Label("Setor do Funcionario");
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Limpeza", "Organizacao", "Segurança","IT","Professor","Diretor","Cordenador","Cozinha","Gestao");
        comboBox.setValue("Selecione uma opção");
        Label resulBox = new Label("Opção selecionada: Nenhuma");
        comboBox.setOnAction(e -> {
            String selecionado = comboBox.getValue();
            resulBox.setText("Opção selecionada: " + selecionado);
        });

        VBox layout = new VBox(10, lblnome, txtNome, lblrg, txtRg,lblbox,comboBox, resulBox);
        layout.setAlignment(Pos.CENTER);

        StackPane root = new StackPane();
        root.getChildren().addAll(layout);

        Scene scene = new Scene(root, 350, 400);
        scene.setFill(Color.DARKGRAY);

        stage.setTitle("Cadastro de Funcionario");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}