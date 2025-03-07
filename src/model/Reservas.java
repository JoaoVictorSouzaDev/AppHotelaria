package model;

import java.util.Date;

public class Reservas {

    private int id;
    private int idPedido;
    private int idQuarto;
    private int idAdicional;
    private Date fim;
    private Date Inicio;

    public Reservas(int idPedido, int idQuarto, int idAdicional, Date fim, Date inicio) {
        this.idPedido = idPedido;
        this.idQuarto = idQuarto;
        this.idAdicional = idAdicional;
        this.fim = fim;
        Inicio = inicio;
    }

    public int getId() {return id;}
    public int getIdPedido() {return idPedido;}
    public int getIdQuarto() {return idQuarto;}
    public int getIdAdicional() {return idAdicional;}
    public Date getFim() {return fim;}
    public Date getInicio() {return Inicio;}

    public void setIdPedido(int idPedido) {this.idPedido = idPedido;}
    public void setIdQuarto(int idQuarto) {this.idQuarto = idQuarto;}
    public void setIdAdicional(int idAdicional) {this.idAdicional = idAdicional;}
    public void setFim(Date fim) {this.fim = fim;}
    public void setInicio(Date inicio) {Inicio = inicio;}

}
