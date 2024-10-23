package com.gastos.seguimiento.controller.gastos;

import com.gastos.seguimiento.model.gasto.Gastos;
import com.gastos.seguimiento.service.gatos.GastosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gastos")
public class GastosController {

    @Autowired
    private GastosService gastosService;

    // Obtener todos los gastos
    @GetMapping
    public List<Gastos> getAllGastos() {
        return gastosService.findAll();
    }

    // Obtener un gasto por ID
    @GetMapping("/{id}")
    public ResponseEntity<Gastos> getGastoById(@PathVariable String id) {
        Gastos gasto = gastosService.findById(id);
        if (gasto != null) {
            return new ResponseEntity<>(gasto, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Crear un nuevo gasto
    @PostMapping
    public Gastos createGasto(@RequestBody Gastos gasto) {
        return gastosService.save(gasto);
    }

    // Eliminar un gasto por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteGasto(@PathVariable String id) {
        gastosService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // Actualizar un gasto existente
    @PutMapping("/{id}")
    public ResponseEntity<Gastos> updateGasto(@PathVariable String id, @RequestBody Gastos gastoDetails) {
        Gastos gasto = gastosService.findById(id);
        if (gasto != null) {
            gasto.setDescripcion(gastoDetails.getDescripcion());
            gasto.setMonto(gastoDetails.getMonto());
            gasto.setCategoria(gastoDetails.getCategoria());
            gasto.setFecha(gastoDetails.getFecha());
            return new ResponseEntity<>(gastosService.save(gasto), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}