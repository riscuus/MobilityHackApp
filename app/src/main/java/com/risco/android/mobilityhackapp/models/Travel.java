package com.risco.android.mobilityhackapp.models;

/**
 * Created by Albert Risco on 10/03/2018.
 */

public class Travel {
    private String destino, fecha, origen;
    private int id, km, horaInicio, horaFinal;

    public Travel(String destino, String fecha, String origen, int id, int km, int horaInicio, int horaFinal) {
        this.destino = destino;
        this.fecha = fecha;
        this.origen = origen;
        this.id = id;
        this.km = km;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
    }

    @Override
    public String toString() {
        return "Travel{" +
                "destino='" + destino + '\'' +
                ", fecha='" + fecha + '\'' +
                ", origen='" + origen + '\'' +
                ", id=" + id +
                ", km=" + km +
                ", horaInicio=" + horaInicio +
                ", horaFinal=" + horaFinal +
                '}';
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(int horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(int horaFinal) {
        this.horaFinal = horaFinal;
    }
}
