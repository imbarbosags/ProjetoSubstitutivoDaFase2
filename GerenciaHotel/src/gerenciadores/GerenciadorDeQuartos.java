package gerenciadores;

import java.util.HashSet;

import entidades.Quarto;
import enums.TipoQuarto;

public class GerenciadorDeQuartos {
    private HashSet<Quarto> todosQuartos = new HashSet<>();

    public String getAllQuartosDisponiveis(){
        HashSet<String> quartosDisponiveis = new HashSet<>();
        for (Quarto quarto: todosQuartos){
            if(quarto.isQuartoDisponivel()){
                quartosDisponiveis.add(quarto.getNumeroQuarto());
            }
        }
        return quartosDisponiveis.toString();
    }
    public String cadastrarNovoQuarto(String numeroQuarto, TipoQuarto tipoQuarto, int capacidade, double preco){
        Quarto quarto = new Quarto(numeroQuarto, tipoQuarto, capacidade, preco);
        todosQuartos.add(quarto);
        return "Novo quarto cadastrado com sucesso!";
    }
}
