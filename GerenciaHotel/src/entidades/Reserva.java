package entidades;
import java.time.LocalDate;

public class Reserva {
    private Quarto quartoReservado;
    private Hospede hospedeQueReservou;
    private int numReserva;
    private LocalDate dataEntrada;
    private LocalDate dataSaida;
    private int hospedesTotais;
    private boolean checkIn;
    private boolean checkOut;
    
    
    public Reserva(Quarto quartoReservado, Hospede hospedeQueReservou, int numReserva, LocalDate dataEntrada, LocalDate dataSaida,
            int hospedesTotais) {
        this.quartoReservado = quartoReservado;
        this.hospedeQueReservou = hospedeQueReservou;
        this.numReserva = numReserva;
        this.dataEntrada = dataEntrada;
        this.dataSaida = dataSaida;
        this.hospedesTotais = hospedesTotais;
        checkIn = false;
        checkOut = false;
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


    public LocalDate getDataEntrada() {
        return dataEntrada;
    }


    public void setDataEntrada(LocalDate dataEntrada) {
        this.dataEntrada = dataEntrada;
    }


    public LocalDate getDataSaida() {
        return dataSaida;
    }


    public void setDataSaida(LocalDate dataSaida) {
        this.dataSaida = dataSaida;
    }


    public int getHospedesTotais() {
        return hospedesTotais;
    }


    public void setHospedesTotais(int hospedesTotais) {
        this.hospedesTotais = hospedesTotais;
    }


    public boolean isCheckIn() {
        return checkIn;
    }


    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }


    public boolean isCheckOut() {
        return checkOut;
    }


    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + numReserva;
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
        Reserva other = (Reserva) obj;
        if (numReserva != other.numReserva)
            return false;
        return true;
    }
    
  
    
    
}
