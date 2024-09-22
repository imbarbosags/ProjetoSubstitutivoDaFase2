package entidades;
import java.util.Date;

public class Reserva {
    private Quarto quartoReservado;
    private Hospede hospedeQueReservou;
    private int numReserva;
    private Date dataEntrada;
    private Date dataSaida;
    private int hospedesTotais;
    
    
    public Reserva(Quarto quartoReservado, Hospede hospedeQueReservou, int numReserva, Date dataEntrada, Date dataSaida,
            int hospedesTotais) {
        this.quartoReservado = quartoReservado;
        this.hospedeQueReservou = hospedeQueReservou;
        this.numReserva = numReserva;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.hospedesTotais = hospedesTotais;
    }


    public Quarto getQuartoReservado() {
        return quartoReservado;
    }


    public void setQuartoReservado(Quarto quartoReservado) {
        this.quartoReservado = quartoReservado;
    }


    public Hospede getHospedeQueReservou() {
        return hospedeQueReservou;
    }


    public void setHospedeQueReservou(Hospede hospedeQueReservou) {
        this.hospedeQueReservou = hospedeQueReservou;
    }


    public int getNumReserva() {
        return numReserva;
    }


    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }


    public Date getDataEntrada() {
        return dataEntrada;
    }


    public void setDataEntrada(Date dataEntrada) {
        this.dataEntrada = dataEntrada;
    }


    public Date getDataSaida() {
        return dataSaida;
    }


    public void setDataSaida(Date dataSaida) {
        this.dataSaida = dataSaida;
    }


    public int getHospedesTotais() {
        return hospedesTotais;
    }


    public void setHospedesTotais(int hospedesTotais) {
        this.hospedesTotais = hospedesTotais;
    }
    
  
    
    
}
