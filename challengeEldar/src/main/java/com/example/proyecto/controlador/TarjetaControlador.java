package com.example.proyecto.controlador;

import com.example.proyecto.peticion.Operacion;
import com.example.proyecto.servicio.OperacionServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculoTasa")
@AllArgsConstructor
public class TarjetaControlador {

    @Autowired
    private OperacionServicio servicio;

    @PostMapping
    public ResponseEntity<Operacion> calculoTasa(@RequestBody(required = true) Operacion operacion) {
        return ResponseEntity.ok(servicio.calculoTasa(operacion));
    }


}
