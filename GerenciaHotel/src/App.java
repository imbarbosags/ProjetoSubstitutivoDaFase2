import entidades.Quarto;
import enums.TipoQuarto;
import gerenciadores.GerenciadorDeQuartos;

public class App {
    private static GerenciadorDeQuartos gerenciadorDeQuartos = new GerenciadorDeQuartos();
    
    public static void main(String[] args){
        String x = gerenciadorDeQuartos.getAllQuartosDisponiveis();
        System.out.println(x);
        gerenciadorDeQuartos.cadastrarNovoQuarto("QuartoTestado", TipoQuarto.SUITE, 999, 0.5);
        gerenciadorDeQuartos.cadastrarNovoQuarto("QuartoTestado2", TipoQuarto.CASAL, 999, 0.5);
        x = gerenciadorDeQuartos.getAllQuartosDisponiveis();
        System.out.println(x);
    }
}