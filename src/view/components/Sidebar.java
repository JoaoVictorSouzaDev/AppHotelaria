package view.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


public class Sidebar extends VBox {

    public Button btnCliente = new Button("Clientes");
    public Button btnFuncionario = new Button("Funcionarios");
    public Button btnQuarto = new Button("Quartos");
    public Button btnReserva = new Button("Reservas");
    public Button btnRelatorio = new Button("Relatorio");

    public Sidebar() {

        Font fontRegular = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansRegular.ttf"), 12);
        Font fontSemiBold = Font.loadFont(getClass().getResourceAsStream("/view/resources/fonts/DmSansSemiBold.ttf"), 12);

        btnCliente.setFont(Font.font(fontRegular.getFamily(), 20));
        btnFuncionario.setFont(Font.font(fontRegular.getFamily(), 20));
        btnQuarto.setFont(Font.font(fontRegular.getFamily(), 20));
        btnReserva.setFont(Font.font(fontRegular.getFamily(), 20));
        btnRelatorio.setFont(Font.font(fontRegular.getFamily(), 20));

        String styleButton = "-fx-background-color: transparent;"+
                             "-fx-border-color: transparent;"+
                             "-fx-graphic-text-gap: 10px;"+
                             "-fx-cursor: hand;" +
                             "-fx-text-fill: #ffffff;" +
                             "-fx-font-size: 16;" +
                             "-fx-border-radius: 10;" +
                             "-fx-font-family: '" + fontSemiBold.getFamily() + "';";
        btnCliente.setStyle(styleButton);
        btnFuncionario.setStyle(styleButton);
        btnQuarto.setStyle(styleButton);
        btnReserva.setStyle(styleButton);
        btnRelatorio.setStyle(styleButton);

        btnCliente.setOnMouseEntered(evento ->
                btnCliente.setStyle(styleButton.replace("transparent", "#E1D8C4")));
        btnCliente.setOnMouseExited(evento -> btnCliente.setStyle(styleButton));

        btnFuncionario.setOnMouseEntered(evento ->
                btnFuncionario.setStyle(styleButton.replace("transparent", "#E1D8C4")));
        btnFuncionario.setOnMouseExited(evento -> btnFuncionario.setStyle(styleButton));

        btnQuarto.setOnMouseEntered(evento ->
                btnQuarto.setStyle(styleButton.replace("transparent", "#E1D8C4")));
        btnQuarto.setOnMouseExited(evento -> btnQuarto.setStyle(styleButton));

        btnReserva.setOnMouseEntered(evento ->
                btnReserva.setStyle(styleButton.replace("transparent", "#E1D8C4")));
        btnReserva.setOnMouseExited(evento -> btnReserva.setStyle(styleButton));

        btnRelatorio.setOnMouseEntered(evento ->
                btnRelatorio.setStyle(styleButton.replace("transparent", "#E1D8C4")));
        btnRelatorio.setOnMouseExited(evento -> btnRelatorio.setStyle(styleButton));

        Image iconBtnCliente = new Image(getClass().getResourceAsStream("/view/resources/img/Pessoa.png"));
        Image iconBtnFuncionario = new Image(getClass().getResourceAsStream("/view/resources/img/Funcionario.png"));
        Image iconBtnQuarto = new Image(getClass().getResourceAsStream("/view/resources/img/Quarto.png"));
        Image iconBtnReserva = new Image(getClass().getResourceAsStream("/view/resources/img/Reserva.png"));
        Image iconBtnRelatorio = new Image(getClass().getResourceAsStream("/view/resources/img/Relatorio.png"));

        ImageView viewLogoHotel = new ImageView("/view/resources/img/LogoHotel.png");
        viewLogoHotel.setFitWidth(40);
        viewLogoHotel.setFitHeight(40);
        viewLogoHotel.setPreserveRatio(true);

        ImageView viewIconCliente = new ImageView(iconBtnCliente);
        viewIconCliente.setFitWidth(30);
        viewIconCliente.setFitHeight(30);

        ImageView viewIconFuncionario = new ImageView(iconBtnFuncionario);
        viewIconFuncionario.setFitWidth(30);
        viewIconFuncionario.setFitHeight(30);

        ImageView viewIconQuarto = new ImageView(iconBtnQuarto);
        viewIconQuarto.setFitWidth(30);
        viewIconQuarto.setFitHeight(30);

        ImageView viewIconReserva = new ImageView(iconBtnReserva);
        viewIconReserva.setFitWidth(30);
        viewIconReserva.setFitHeight(30);

        ImageView viewIconRelatorio = new ImageView(iconBtnRelatorio);
        viewIconRelatorio.setFitWidth(30);
        viewIconRelatorio.setFitHeight(30);

        btnCliente.setGraphic(viewIconCliente);
        btnFuncionario.setGraphic(viewIconFuncionario);
        btnQuarto.setGraphic(viewIconQuarto);
        btnReserva.setGraphic(viewIconReserva);
        btnRelatorio.setGraphic(viewIconRelatorio);

        setSpacing(15);
        setPadding(new Insets(20));
        Label lblMenu = new Label("Grand Hotel");

        HBox Titulo = new HBox(10);
        Titulo.getChildren().addAll(viewLogoHotel, lblMenu);
        Titulo.setAlignment(Pos.CENTER_LEFT);
        Titulo.setPadding(new Insets(5, 10, 5, 10));

        lblMenu.setStyle("-fx-text-fill: #ffffff;");
        lblMenu.setFont(Font.font(fontSemiBold.getFamily(), 20));
        setMargin( lblMenu, new Insets(5, 10, 5, 10));
        setStyle("-fx-background-color: #4b0505;");
        getChildren().addAll(Titulo, btnCliente, btnFuncionario, btnQuarto, btnReserva, btnRelatorio);
    }
}