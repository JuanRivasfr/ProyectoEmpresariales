package com.empresa.inventario.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.empresa.inventario.model.MovimientoInventario;
import com.empresa.inventario.service.MovimientoInventarioService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/movimientos")
public class MovimientoInventarioController {
    @Autowired
    private MovimientoInventarioService movimientoInventarioService;

    @GetMapping
    public List<MovimientoInventario> listarMovimientos() {
        return movimientoInventarioService.listarMovimientos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovimientoInventario> obtenerMovimiento(@PathVariable Long id) {
        Optional<MovimientoInventario> movimiento = movimientoInventarioService.obtenerMovimientoPorId(id);
        return movimiento.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public MovimientoInventario crearMovimiento(@RequestBody MovimientoInventario movimiento) {
        return movimientoInventarioService.guardarMovimiento(movimiento);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMovimiento(@PathVariable Long id) {
        movimientoInventarioService.eliminarMovimiento(id);
        return ResponseEntity.noContent().build();
    }
}
