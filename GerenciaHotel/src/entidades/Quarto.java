package entidades;

import enums.StatusQuarto;
import enums.TipoQuarto;

public class Quarto {
    
    // Foi escolhido String porque existem hoteis que utilizam simbolos do alfabeto
    // ex: Quarto 04A
    private String numeroQuarto;
    
    private TipoQuarto tipoQuarto;

    private int capacidade;

    private double preco;

    private StatusQuarto statusQuarto;

    public Quarto(String numeroQuarto, TipoQuarto tipoQuarto, int capacidade, double preco) {
        this.numeroQuarto = numeroQuarto;
        this.tipoQuarto = tipoQuarto;
        this.capacidade = capacidade;
        this.preco = preco;
        this.statusQuarto = StatusQuarto.DISPONÍVEL;
    }

    public String getNumeroQuarto() {
        return numeroQuarto;
    }

    public void setNumeroQuarto(String numeroQuarto) {
        this.numeroQuarto = numeroQuarto;
    }

    public TipoQuarto getTipoQuarto() {
        return tipoQuarto;
    }

    public void setTipoQuarto(TipoQuarto tipoQuarto) {
        this.tipoQuarto = tipoQuarto;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public StatusQuarto getStatusQuarto() {
        return statusQuarto;
    }

    public void setStatusQuarto(StatusQuarto statusQuarto) {
        this.statusQuarto = statusQuarto;
    }

    @Override
    public String toString() {
        return "Quarto " + numeroQuarto + ", do tipo " + tipoQuarto + ", tem a capacidade de abrigar " + capacidade
                + " hospedes, pelo valor de " + preco + ", no momento, o quarto se encontra " + statusQuarto;
    }

    

 
}
