package com.empresa.inventario.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.inventario.model.MovimientoInventario;
import com.empresa.inventario.repository.MovimientoInventarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoInventarioService {
    @Autowired
    private MovimientoInventarioRepository movimientoInventarioRepository;

    public List<MovimientoInventario> listarMovimientos() {
        return movimientoInventarioRepository.findAll();
    }

    public Optional<MovimientoInventario> obtenerMovimientoPorId(Long id) {
        return movimientoInventarioRepository.findById(id);
    }

    public MovimientoInventario guardarMovimiento(MovimientoInventario movimiento) {
        return movimientoInventarioRepository.save(movimiento);
    }

    public void eliminarMovimiento(Long id) {
        movimientoInventarioRepository.deleteById(id);
    }
}

