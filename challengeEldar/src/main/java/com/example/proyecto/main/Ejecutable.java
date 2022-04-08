package com.example.proyecto.main;

import com.example.proyecto.excepcion.TarjetaExcepcion;
import com.example.proyecto.modelo.FabricaTarjeta;
import com.example.proyecto.modelo.TipoTarjeta;


public class Ejecutable {

    private static TipoTarjeta tarjetaVisa;
    private static TipoTarjeta tarjetaNara;
    private static TipoTarjeta tarjetaAmex;

    public static void main(String[] args) {

     try {
         tarjetaVisa = FabricaTarjeta.obtenerTarjeta(FabricaTarjeta.VISA, "Axel Cespedes", "26/06/2025", 1234142352);
         tarjetaNara = FabricaTarjeta.obtenerTarjeta(FabricaTarjeta.NARA, "Lionel Messi", "18/07/2022", 423523452);
         tarjetaAmex = FabricaTarjeta.obtenerTarjeta(FabricaTarjeta.AMEX, "Cristiano Ronaldo", "08/04/2021", 324523451);

         System.out.println("Información de Tarjeta: " + tarjetaVisa.toString());

         System.out.println("¿Es operación válida?: " + (tarjetaVisa.esOperacionValida(1400) ? "Si, es valida" : "No es valida"));

         System.out.println("¿La tarjeta es válida?: " + (tarjetaVisa.esTarjetaValida() ? "Si, es válida" : "No es valida"));

         System.out.println(tarjetaVisa.informarOperacion(200));

         if (tarjetaVisa.hashCode() != tarjetaAmex.hashCode()) {
             System.out.println("Se identifica que las tarjetas de tipo VISA y AMEX son diferentes");
         }
        } catch (TarjetaExcepcion e) {
         System.out.println("Has ingresado la fecha de vencimiento con FORMATO INCORRECTO!");
     }
    }
}
