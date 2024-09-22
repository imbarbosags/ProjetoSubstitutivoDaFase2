package gerenciadores;

import java.util.HashSet;

import entidades.Quarto;
import enums.TipoQuarto;

public class GerenciadorDeQuartos {
    private HashSet<Quarto> todosQuartos = new HashSet<>();

    public String getAllQuartosDisponiveis() {
        HashSet<String> quartosDisponiveis = new HashSet<>();
        for (Quarto quarto : todosQuartos) {
            if (quarto.isDisponivel()) {
                String quartoEDetalhes = quarto.getNumeroQuarto() + ", " + quarto.getTipoQuarto() + ", capacidade: "
                        + quarto.getCapacidade() + ", diaria: R$" + quarto.getPreco();
                quartosDisponiveis.add(quartoEDetalhes);
            }
        }
        return formataQuartosDisponiveis(quartosDisponiveis);
    }

    private String formataQuartosDisponiveis(HashSet<String> quartosDisponiveis) {
        String output = new String();
        for (String s : quartosDisponiveis) {
            output += "- " + s + "\n";
        }
        return output;
    }

    public String cadastrarNovoQuarto(String numeroQuarto, TipoQuarto tipoQuarto, int capacidade, double preco) {
        Quarto quarto = new Quarto(numeroQuarto, tipoQuarto, capacidade, preco);
        todosQuartos.add(quarto);
        return "Novo quarto cadastrado com sucesso!";
    }
}
