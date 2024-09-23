import java.time.LocalDate;
import java.util.HashSet;
import entidades.Hospede;
import entidades.Quarto;
import entidades.Reserva;
import enums.TipoQuarto;
import gerenciadores.GerenciadorDeHospede;
import gerenciadores.GerenciadorDeQuartos;
import gerenciadores.GerenciadorDeReserva;

public class App {

    private static GerenciadorDeQuartos gerenciadorDeQuartos = new GerenciadorDeQuartos();
    private static GerenciadorDeReserva gerenciadorDeReserva = new GerenciadorDeReserva();
    private static GerenciadorDeHospede gerenciadorDeHospede = new GerenciadorDeHospede();

    public static void main(String[] args) {
        LocalDate dataEntrada1 = LocalDate.of(2024, 9, 1);
        LocalDate dataSaida1 = LocalDate.of(2024, 9, 29);
        LocalDate dataRandom = LocalDate.of(2023, 2, 20);
        LocalDate dataRandom2 = LocalDate.of(2024, 9, 19);
        gerenciadorDeQuartos.cadastrarNovoQuarto("QuartoTestado", TipoQuarto.SUITE, 999, 0.5);
        gerenciadorDeQuartos.cadastrarNovoQuarto("Quarto2", TipoQuarto.CASAL, 10, 105);
        gerenciadorDeHospede.cadastrarNovoHospede("Barbosa", "123", null, "Rua Ruada", "(83)99999-9999");
        System.out.println(reserva(gerenciadorDeQuartos.findQuartoByNumeroQuarto("Quarto2"),
                gerenciadorDeHospede.getHospedeByCpf("123"),
                dataEntrada1, dataSaida1, 4));
        System.out.println(reserva(gerenciadorDeQuartos.findQuartoByNumeroQuarto("QuartoTestado"),
                gerenciadorDeHospede.getHospedeByCpf("123"),
                dataEntrada1, dataSaida1, 4));
        System.out.println(conferirQuartosDisponiveisPorData(dataEntrada1, dataSaida1));
        System.out.println(conferirQuartosDisponiveisPorData(dataRandom, dataRandom2));
        System.out.println(checkIn(1));
        System.out.println(checkOut(1));
        System.out.println(conferirQuartosDisponiveisPorData(dataEntrada1, dataSaida1));
    }

    private static String reserva(Quarto quarto, Hospede hospede, LocalDate dataEntrada, LocalDate dataSaida,
            int hospedesTotais) {
        return gerenciadorDeReserva.novaReserva(quarto, hospede, dataEntrada, dataSaida, hospedesTotais);
    }

    private static String conferirQuartosDisponiveisPorData(LocalDate dataEntrada, LocalDate dataSaida) {
        HashSet<Quarto> quartosIndisponiveis = gerenciadorDeReserva.quartosIndisponiveis(dataEntrada, dataSaida);

        HashSet<Quarto> todosOsQuartos = gerenciadorDeQuartos.getTodosQuartos();

        HashSet<String> quartosDisponiveisNoPeriodo = new HashSet<>();

        for (Quarto q : todosOsQuartos) {
            if (!quartosIndisponiveis.contains(q)) {
                quartosDisponiveisNoPeriodo.add(q.getNumeroQuarto());
            }
        }
        return "Os quartos disponiveis no periodo solicitados são: " + quartosDisponiveisNoPeriodo.toString();
    }

    private static String cancelarReserva(int numReserva) {
        return gerenciadorDeReserva.cancelarReserva(numReserva);
    }

    private static String checkIn(int idReserva){
        Reserva r = gerenciadorDeReserva.findReservaId(idReserva);
        gerenciadorDeReserva.checkIn(r);
        return gerenciadorDeQuartos.checkIn(r.getQuartoReservado().getNumeroQuarto());
    }

    private static String checkOut(int idReserva){
        Reserva r = gerenciadorDeReserva.findReservaId(idReserva);
        gerenciadorDeQuartos.checkOut(r.getQuartoReservado().getNumeroQuarto());
        return gerenciadorDeReserva.checkOut(r);
    }
}