package gerenciadores;

import java.time.LocalDate;
import java.util.HashSet;
import java.time.temporal.ChronoUnit;
import entidades.Hospede;
import entidades.Quarto;
import entidades.Reserva;

public class GerenciadorDeReserva {
    private HashSet<Reserva> reservas = new HashSet<>();
    private int contadorReservas = 0;

    public String novaReserva(Quarto quarto, Hospede hospede, LocalDate dataEntrada, LocalDate dataSaida,
            int hospedesTotais) {
        if (quarto == null)
            return "Quarto não existe!";
        if (hospede == null)
            return "Não há nenhum hospede cadastrado com esse CPF!";
        if (!quarto.isDisponivel())
            return "O quarto não se encontra disponível para reserva!";
        if (quartosIndisponiveis(dataEntrada, dataSaida).contains(quarto)) {
            return "O quarto já está reservado para o período selecionado!";
        }
        if (dataSaida.isBefore(dataEntrada)) {
            return "Data de check-out deve ser posterior à data de check-in";
        }
        if (hospedesTotais>quarto.getCapacidade()){
            return "Voce esta tentando levar um numero de pessoas alem da capacidade máxima desse quarto!";
        }
        Reserva novaReserva = new Reserva(quarto, hospede, ++contadorReservas, dataEntrada, dataSaida, hospedesTotais);
        reservas.add(novaReserva);
        return "Reserva Feita com sucesso!";
    }

    public String cancelarReserva(int numReserva) {
        Reserva reserva = findReservaId(numReserva);
        if (reserva == null)
            return "Nao ha nenhuma reserva com esse codigo";
        reservas.remove(reserva);
        return "Reserva cancelada!";
    }

    public Reserva findReservaId(int id) {
        for (Reserva r : reservas) {
            if (r.getNumReserva() == id)
                return r;
        }
        return null;
    }

    // Aqui foi escolhido uma logica reversa. Tentar pegar de cara os quartos
    // disponiveis iria exigir que a classe GerenciadorDeReserva tivesse acesso a
    // classe ControladorDeQuartos, porque teriamos que ter a lista de todos os
    // quartos cadastrados, informacao que so esta disponivel nessa classe. Violando
    // boas praticas de programacao, com um controlador dentro de outro!
    // Assim, retornamos os quartos indisponiveis, e no Main, tiramos esses quartos
    // da lista de todos quartos disponiveis
    public HashSet<Quarto> quartosIndisponiveis(LocalDate dataEntrada, LocalDate dataSaida) {
        HashSet<Quarto> quartosIndisponiveis = new HashSet<>();
        for (Reserva r : reservas) {
            Quarto quartoReservado = r.getQuartoReservado();
            if (!(dataSaida.isBefore(r.getDataEntrada()) || dataEntrada.isAfter(r.getDataSaida()))) {
                quartosIndisponiveis.add(quartoReservado);
            }
        }
        return quartosIndisponiveis;
    }

    private double calcularValorReserva(Reserva r){
        return r.getQuartoReservado().getPreco() * (ChronoUnit.DAYS.between(r.getDataEntrada(), r.getDataSaida())+1);
    }

    public String checkIn(Reserva r){
        r.setCheckIn(true);
        return ("CheckIn Realizado com sucesso!");
    }

    public String checkOut(Reserva r){
        if (!r.isCheckIn()){
            return "Impossivel fazer o CheckOut sem ter realizado o checkIn antes!";
        }
        r.setCheckOut(true);
        cancelarReserva(r.getNumReserva());
        return "Checkout realizado com sucesso! \nO valor da hospedagem foi: "+ calcularValorReserva(r);
    }
}
