package Cadastro_De_Contatos;

import java.util.ArrayList;
import java.util.List;

public class ControleDeContatos {

    private List<String> compromissos = new ArrayList<>();

    public void contatos(String nome, String telefone, String email) {

        this.compromissos.add(" "+nome+" "+telefone+" "+email);

    }

    public void removeComprimisso(int indice) {

        if (indice >= 0 && indice < compromissos.size()) {
            compromissos.remove(indice);
        }

    }

    public String[] getTodosContatos() {
        return compromissos.toArray(new String[0]);
    }

}
