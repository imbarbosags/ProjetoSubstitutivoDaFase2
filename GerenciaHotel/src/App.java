import java.util.Date;

import entidades.Hospede;
import entidades.Quarto;
import enums.TipoQuarto;
import gerenciadores.GerenciadorDeHospede;
import gerenciadores.GerenciadorDeQuartos;
import gerenciadores.GerenciadorDeReserva;

public class App {

    private static GerenciadorDeQuartos gerenciadorDeQuartos = new GerenciadorDeQuartos();
    private static GerenciadorDeReserva gerenciadorDeReserva = new GerenciadorDeReserva();
    private static GerenciadorDeHospede gerenciadorDeHospede = new GerenciadorDeHospede();

    public static void main(String[] args) {
        gerenciadorDeQuartos.cadastrarNovoQuarto("QuartoTestado", TipoQuarto.SUITE, 999, 0.5);
        gerenciadorDeQuartos.cadastrarNovoQuarto("Quarto2", TipoQuarto.CASAL, 10, 105);
        gerenciadorDeHospede.cadastrarNovoHospede("Barbosa", "123", null, "Rua Ruada", "(83)99999-9999");
        reserva(gerenciadorDeQuartos.findQuartoByNumeroQuarto("Quarto2"), gerenciadorDeHospede.getHospedeByCpf("123"), null, null, 4);
    }


    private static void reserva(Quarto quarto, Hospede hospede, Date dataEntrada, Date dataSaida,
            int hospedesTotais){
               System.out.println(gerenciadorDeReserva.novaReserva(quarto, hospede, dataEntrada, dataSaida, hospedesTotais));
            }
}