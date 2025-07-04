package controller;

import dao.QuartosDao;
import model.Quartos;

public class QuartosController {
    private final QuartosDao quartosDao;

    public QuartosController() {
        this.quartosDao = new QuartosDao();
    }

    public boolean inserirQuartos(String nome, String numero, int qtd_cama_casal, int qtd_cama_solteiro, double preco, boolean disponivel){
        Quartos quartos = new Quartos("", nome , numero, qtd_cama_casal, qtd_cama_solteiro, preco, disponivel, 0);
        return quartosDao.inserirQuartos(quartos);
    }
}
