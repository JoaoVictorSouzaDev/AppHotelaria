package view.components;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.control.Button;
import javafx.scene.text.Font;


public class Buttons extends HBox {

    public Button btnAtualizar = new Button("Atualizar");
    public Button btnCadastrar = new Button("Cadastrar");
    public Button btnExcluir = new Button("Excluir");

    public Buttons() {

        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansRegular.ttf"), 12);
        Font fontSemiBold = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansSemiBold.ttf"), 12);

        btnAtualizar.setFont(Font.font(fontRegular.getFamily(), 20));
        btnAtualizar.setStyle("-fx-text-fill: #000000; -fx-font-size: 12;");
        btnCadastrar.setFont(Font.font(fontRegular.getFamily(), 20));
        btnCadastrar.setStyle("-fx-text-fill: #000000; -fx-font-size: 12;");
        btnExcluir.setFont(Font.font(fontRegular.getFamily(), 20));
        btnExcluir.setStyle("-fx-text-fill: #000000; -fx-font-size: 12;");

        Image iconBtnCadastrar = new Image(getClass().getResourceAsStream("/view/resources/img/Mais.png"));
        Image iconBtnAtualizar = new Image(getClass().getResourceAsStream("/view/resources/img/Atualizar.png"));
        Image iconBtnExcluir = new Image(getClass().getResourceAsStream("/view/resources/img/Lixo.png"));

        ImageView viewIconCadastrar = new ImageView(iconBtnCadastrar);
        viewIconCadastrar.setFitHeight(30);
        viewIconCadastrar.setFitWidth(30);

        ImageView viewIconAtualizar = new ImageView(iconBtnAtualizar);
        viewIconAtualizar.setFitHeight(30);
        viewIconAtualizar.setFitWidth(30);

        ImageView viewIconExcluir = new ImageView(iconBtnExcluir);
        viewIconExcluir.setFitHeight(30);
        viewIconExcluir.setFitWidth(30);

        btnCadastrar.setGraphic(viewIconCadastrar);
        btnAtualizar.setGraphic(viewIconAtualizar);
        btnExcluir.setGraphic(viewIconExcluir);
        setSpacing(15);
        getChildren().addAll(btnCadastrar, btnAtualizar, btnExcluir);
    }
}
