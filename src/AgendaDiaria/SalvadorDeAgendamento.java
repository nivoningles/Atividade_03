package AgendaDiaria;

import java.util.ArrayList;
import java.util.List;

public class SalvadorDeAgendamento {

    private List<String> comprimisso = new ArrayList<>();
    private List<String> data = new ArrayList<>();

    public void salvador(String comprimisso, String dia, String mes, String ano) {

        this.comprimisso.add(comprimisso);
        this.data.add(dia + "/" + mes + "/" + ano);

    }

    public String comprimisso(int contador){

        return comprimisso.get(contador);
    }

    public String data(int contador){

        return data.get(contador);
    }

}
