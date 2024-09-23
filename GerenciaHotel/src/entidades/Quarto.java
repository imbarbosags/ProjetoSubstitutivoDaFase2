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
        return "O quarto " + numeroQuarto + ", do tipo " + tipoQuarto + ", tem a capacidade máxima de " + capacidade
                + " pessoas.\nA diária do quarto custa R$" + preco + " e, no momento, o quarto se encontra "
                + statusQuarto;
    }

    // Metodo auxiliar para verificar se um quarto esta disponivel, usado em outras
    // classes. O que evita de ter que checar sempre o se "quarto.getStatusQuarto() == StatusQuarto."DISPONIVEL"
    public boolean isDisponivel(){
        return this.getStatusQuarto() == StatusQuarto.DISPONÍVEL;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((numeroQuarto == null) ? 0 : numeroQuarto.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Quarto other = (Quarto) obj;
        if (numeroQuarto == null) {
            if (other.numeroQuarto != null)
                return false;
        } else if (!numeroQuarto.equals(other.numeroQuarto))
            return false;
        return true;
    }

}
