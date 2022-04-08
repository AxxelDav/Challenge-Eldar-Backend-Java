package com.example.proyecto.modelo;

import com.example.proyecto.excepcion.TarjetaExcepcion;

import java.time.LocalDate;

public class Visa extends TipoTarjeta {

    public Visa(String cardHolder, String fechaVencimiento, int nroTarjeta) throws TarjetaExcepcion {
        setCardHolder(cardHolder);

        try {
            setFechaVencimiento(LocalDate.parse(fechaVencimiento, formatter));
        } catch (Exception e) {
            throw TarjetaExcepcion.errorFormatoFecha();
        }

        setMarca(FabricaTarjeta.VISA);
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
        double dosDigitosAño = LocalDate.now().getYear() % 100;
        double tasa = dosDigitosAño / LocalDate.now().getMonthValue();

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
