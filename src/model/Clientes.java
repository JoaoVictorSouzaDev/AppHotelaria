package model;

public class Clientes extends Pessoa{
    private int id;
    private String cpf;
    private String telefone;

    public Clientes(String cpf, String telefone, String nome, String email) {
        super(nome, email);
        this.cpf = cpf;
        this.telefone = telefone;
    }

    public int getId() {return id;}
    public String getCpf() {return cpf;}
    public String getTelefone() {return telefone;}

    public void setId(int id) {this.id = id;}
    public void setCpf(String cpf) {this.cpf = cpf;}
    public void setTelefone(String telefone) {this.telefone = telefone;}
}
