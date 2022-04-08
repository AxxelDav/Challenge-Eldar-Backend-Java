package com.example.proyecto.modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public abstract class TipoTarjeta {

    protected final double TASA_MINIMO = 0.3;
    protected final double TASA_MAXIMO = 5.0;
    protected final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    protected String marca;
    protected int nroTarjeta;
    protected String cardHolder;
    protected LocalDate fechaVencimiento;
    //Se considera que el usuario titular de la terjeta tiene un saldo para poder consumir.
    //protected double saldo;

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setNroTarjeta(int nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public void setCardHolder(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public void setFechaVencimiento(LocalDate fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    /*public void setSaldo(double saldo) {
        this.saldo = saldo;
    }*/

    //métodos
    public abstract boolean esOperacionValida(double consumo);

    public abstract boolean esTarjetaValida();

    public abstract double calculoTasa();

    public abstract String informarOperacion(double importe);

    //Mostrar información de tarjeta
    @Override
    public String toString() {
        return "{" +
                "marca='" + marca + '\'' +
                ", nroTarjeta=" + nroTarjeta +
                ", cardHolder='" + cardHolder + '\'' +
                ", fechaVencimiento=" + fechaVencimiento.format(formatter) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoTarjeta that = (TipoTarjeta) o;
        return nroTarjeta == that.nroTarjeta && marca.equals(that.marca) && cardHolder.equals(that.cardHolder) && fechaVencimiento.equals(that.fechaVencimiento);
    }
    //Identificador
    @Override
    public int hashCode() {
        return Objects.hash(marca, nroTarjeta, cardHolder, fechaVencimiento);
    }
}
