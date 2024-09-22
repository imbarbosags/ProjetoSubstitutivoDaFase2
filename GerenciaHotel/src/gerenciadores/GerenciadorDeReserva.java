package gerenciadores;

import java.util.Date;
import java.util.HashSet;

import entidades.Hospede;
import entidades.Quarto;
import entidades.Reserva;

public class GerenciadorDeReserva {
    private HashSet<Reserva> reservas = new HashSet<>();

    public String novaReserva(Quarto quarto, Hospede hospede, Date dataEntrada, Date dataSaida,
            int hospedesTotais) {
        if (quarto == null)
            return "Quarto não existe!";
        if (hospede == null)
            return "Não há nenhum hospede cadastrado com esse CPF!";
        if (!quarto.isDisponivel())
            return "O quarto não se encontra disponível para reserva!";

        Reserva novaReserva = new Reserva(quarto, hospede, reservas.size() + 1, dataEntrada, dataSaida, hospedesTotais);
        reservas.add(novaReserva);
        return "Reserva Feita com sucesso!";
    }
}
