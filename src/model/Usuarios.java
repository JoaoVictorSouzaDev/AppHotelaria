package model;

public class Usuarios extends Pessoa{

    private int id, roleId;
    private String senha;

    public Usuarios(String nome, String email, String senha, int roleId) {
        super(nome, email);
        this.senha = senha;
        this.roleId = roleId;
    }

    public int getId() {return id;}
    public String getSenha() {return senha;}
    public int getRoleId() {return roleId;}

    public void setId(int id) {this.id = id;}
    public void setSenha(String senha) {this.senha = senha;}
    public void setRoleId(int roleId) {this.roleId = roleId;}
}
