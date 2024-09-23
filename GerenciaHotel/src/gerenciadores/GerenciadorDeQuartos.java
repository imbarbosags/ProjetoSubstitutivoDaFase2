package gerenciadores;

import java.util.HashSet;

import entidades.Quarto;
import enums.StatusQuarto;
import enums.TipoQuarto;

public class GerenciadorDeQuartos {
    private HashSet<Quarto> todosQuartos = new HashSet<>();
    private HashSet<Quarto> quartosAtualmenteOcupados = new HashSet<>();

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
        if (findQuartoByNumeroQuarto(numeroQuarto) != null)
            return "Já existe um quarto cadastrado com esse numero!";
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

    public String checkIn(String quarto) {
        Quarto quartoASerReservado = findQuartoByNumeroQuarto(quarto);
        if (quartoASerReservado == null) {
            return "O quarto desejado não existe";
        }
        quartoASerReservado.setStatusQuarto(StatusQuarto.OCUPADO);
        quartosAtualmenteOcupados.add(quartoASerReservado);
        return "Checkin feito no quarto " + quartoASerReservado.getNumeroQuarto() + ".";
    }

    public String statusQuarto(String numeroQuarto) {
        Quarto status = findQuartoByNumeroQuarto(numeroQuarto);
        if (status == null)
            return "O quarto desejado não existe!";
        return status.getStatusQuarto().toString();
    }

    public HashSet<Quarto> getTodosQuartos() {
        return todosQuartos;
    }

    public String checkOut(String quarto) {
        Quarto quartoASerReservado = findQuartoByNumeroQuarto(quarto);
        if (quartoASerReservado == null) {
            return "O quarto desejado não existe";
        }
        if (!quartosAtualmenteOcupados.contains(quartoASerReservado)) {
            return "O quarto informado nao esta ocupado atualmente!";
        }
        quartosAtualmenteOcupados.remove(quartoASerReservado);
        quartoASerReservado.setStatusQuarto(StatusQuarto.DISPONÍVEL);

        return "Checkout realizado com sucesso, o valor devido eh de: ";
    }

    public String removerQuarto(String quarto){
        Quarto quartoRemove = findQuartoByNumeroQuarto(quarto);
        if(quartoRemove==null) return "Nao ha quarto cadastrado com esse nome!";
        todosQuartos.remove(quartoRemove);
        if(quartosAtualmenteOcupados.contains(quartoRemove)) quartosAtualmenteOcupados.remove(quartoRemove);
        return "Quarto excluido com sucesso!";
    }
}
