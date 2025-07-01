package controller;

import dao.UsuariosDao;
import model.Usuarios;

public class UsuariosController {
    private final UsuariosDao usuariosDao;

    public UsuariosController() {
        this.usuariosDao = new UsuariosDao();
    }

    public boolean veririficarCredencias(String email, String senha) {
        if (email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
            return false;
        }
        Usuarios usuario = new Usuarios("", email, senha, 0);
        return usuariosDao.autenticarUsuario(usuario);
    }
}
