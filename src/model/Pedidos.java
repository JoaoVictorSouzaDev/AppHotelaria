package model;

import java.util.Date;

public class Pedidos {

    private int id;
    private int idUsuario;
    private int idCliente;
    private Date data;
    private String pagamento;

    public Pedidos(int idUsuario, int idCliente, Date data, String pagamento) {
        this.idUsuario = idUsuario;
        this.idCliente = idCliente;
        this.data = data;
        this.pagamento = pagamento;
    }

    public String getPagamento() {return pagamento;}
    public Date getData() {return data;}
    public int getIdCliente() {return idCliente;}
    public int getIdUsuario() {return idUsuario;}
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}
    public void setIdUsuario(int idUsuario) {this.idUsuario = idUsuario;}
    public void setIdCliente(int idCliente) {this.idCliente = idCliente;}
    public void setData(Date data) {this.data = data;}
    public void setPagamento(String pagamento) {this.pagamento = pagamento;}
}
