package com.example.proyecto.servicio.Implementacion;

import com.example.proyecto.modelo.FabricaTarjeta;
import com.example.proyecto.modelo.TipoTarjeta;
import com.example.proyecto.peticion.Operacion;
import com.example.proyecto.servicio.OperacionServicio;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OperacionServicioImpl implements OperacionServicio {

    public Operacion calculoTasa(Operacion operacion) {
        TipoTarjeta tarjeta = FabricaTarjeta.obtenerTarjeta(operacion.getMarca(),  "Axel Cespedes", "26/06/2025", 1345436254);
        operacion.setTasa((operacion.getImporte()*tarjeta.calculoTasa())/100);
        return operacion;
    }
}
