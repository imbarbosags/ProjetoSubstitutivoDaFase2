import entidades.Quarto;
import enums.TipoQuarto;

public class App {
    public static void main(String[] args) throws Exception {
        Quarto quarto = new Quarto("5C", TipoQuarto.CASAL, 10, 2000);
        System.out.println(quarto);
    }
}