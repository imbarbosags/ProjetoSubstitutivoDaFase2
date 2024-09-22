package gerenciadores;

import java.util.HashSet;

import entidades.Quarto;
import entidades.Reserva;
import enums.StatusQuarto;
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

    public Quarto findQuartoByNumeroQuarto(String numeroQuarto) {
        Quarto quarto = null;
        for (Quarto q : todosQuartos) {
            if (q.getNumeroQuarto().equals(numeroQuarto)) {
                quarto = q;
            }
        }
        return quarto;
    }

    private String ocuparQuarto(String quarto) {
        Quarto quartoASerReservado = findQuartoByNumeroQuarto(quarto);
        if (quartoASerReservado == null) {
            return "O quarto desejado não existe";
        }
        quartoASerReservado.setStatusQuarto(StatusQuarto.OCUPADO);
        return "Checkin feito no quarto " + quartoASerReservado.getNumeroQuarto() + " para o cliente: ";
    }

    public String statusQuarto(String numeroQuarto) {
        Quarto status = findQuartoByNumeroQuarto(numeroQuarto);
        if (status == null)
            return "O quarto desejado não existe!";
        return status.getStatusQuarto().toString();
    }
}
