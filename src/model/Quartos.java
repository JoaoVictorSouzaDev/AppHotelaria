package model;

public class Quartos {
    private int id;
    private String nome;
    private String numero;
    private int qtdCamaCasal;
    private int qtdCamaSolteiros;
    private double preco;
    private boolean disponivel;

    public Quartos(String s, String nome, String numero, int qtdCamaCasal, int qtdCamaSolteiros, double preco, boolean disponivel, int i) {
        this.nome = nome;
        this.numero = numero;
        this.qtdCamaCasal = qtdCamaCasal;
        this.qtdCamaSolteiros = qtdCamaSolteiros;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public int getId() {return id;}
    public String getNome() {return nome;}
    public String getNumero() {return numero;}
    public int getQtdCamaCasal() {return qtdCamaCasal;}
    public int getQtdCamaSolteiros() {return qtdCamaSolteiros;}
    public double getPreco() {return preco;}
    public boolean isDisponivel() {return disponivel;}

    public void setDisponivel(boolean disponivel) {this.disponivel = disponivel;}
    public void setPreco(double preco) {this.preco = preco;}
    public void setQtdCamaSolteiros(int qtdCamaSolteiros) {this.qtdCamaSolteiros = qtdCamaSolteiros;}
    public void setQtdCamaCasal(int qtdCamaCasal) {this.qtdCamaCasal = qtdCamaCasal;}
    public void setNumero(String numero) {this.numero = numero;}
    public void setNome(String nome) {this.nome = nome;}
    public void setId(int id) {this.id = id;}
}
