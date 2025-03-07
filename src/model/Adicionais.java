package model;

public class Adicionais {
    private int id;
    private String nome;
    private String preco;

    public Adicionais(String nome, String preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {return id;}
    public String getNome() {return nome;}
    public String getPreco() {return preco;}

    public void setId(int id) {this.id = id;}
    public void setNome(String nome) {this.nome = nome;}
    public void setPreco(String preco) {this.preco = preco;}
}
