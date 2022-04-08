package com.example.proyecto.modelo;

public class FabricaTarjeta {

    public static final String VISA = "VISA";
    public static final String NARA = "NARA";
    public static final String AMEX = "AMEX";

    public static TipoTarjeta obtenerTarjeta(String tipo, String cardHolder, String fechaVencimiento, int nroTarjeta) {
        switch (tipo) {
            case VISA:
                return new Visa(cardHolder, fechaVencimiento, nroTarjeta);
            case NARA:
                return new Nara(cardHolder, fechaVencimiento, nroTarjeta);
            case AMEX:
                return new Amex(cardHolder, fechaVencimiento, nroTarjeta);
            default:
                return null;
        }
    }
}
