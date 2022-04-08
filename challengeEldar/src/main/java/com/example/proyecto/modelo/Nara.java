package com.example.proyecto.modelo;

import com.example.proyecto.excepcion.TarjetaExcepcion;

import java.time.LocalDate;

public class Nara extends TipoTarjeta {

    public Nara(String cardHolder, String fechaVencimiento, int nroTarjeta) throws TarjetaExcepcion {
        setCardHolder(cardHolder);

        try {
            setFechaVencimiento(LocalDate.parse(fechaVencimiento, formatter));
        } catch (Exception e) {
            throw TarjetaExcepcion.errorFormatoFecha();
        }

        setMarca(FabricaTarjeta.NARA);
        setNroTarjeta(nroTarjeta);
    }

    @Override
    public boolean esOperacionValida(double consumo) {
        if(consumo > 1000)
            return false;
        return true;
    }

    @Override
    public boolean esTarjetaValida() {
        if(this.fechaVencimiento.isAfter(LocalDate.now()))
            return true;
        return false;
    }

    @Override
    public double calculoTasa() {
        double tasa = LocalDate.now().getDayOfMonth() * 0.5;

        if(tasa > this.TASA_MAXIMO)
            return this.TASA_MAXIMO;

        if(tasa < this.TASA_MINIMO)
            return this.TASA_MINIMO;

        return tasa;
    }

    @Override
    public String informarOperacion(double importe) {
        return "Informe Operación: [marca=" + marca + ", importe=" + importe
                + ", tasa=" + (importe*calculoTasa())/100  + "]";
    }
}
