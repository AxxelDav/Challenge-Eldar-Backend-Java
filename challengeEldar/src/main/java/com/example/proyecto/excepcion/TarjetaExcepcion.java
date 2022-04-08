package com.example.proyecto.excepcion;

import com.example.proyecto.mensaje.mensajes;

public class TarjetaExcepcion extends RuntimeException {

    private final String mensaje;

    public TarjetaExcepcion(String mensaje) {
        this.mensaje = mensaje;
    }

    public static TarjetaExcepcion errorFormatoFecha() {
        return new TarjetaExcepcion(mensajes.Error_Formato_Fecha_Vencimiento);
    }

    public String obtenerMensaje() {
        return mensaje;
    }


}
