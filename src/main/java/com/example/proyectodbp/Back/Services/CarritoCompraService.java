package com.example.proyectodbp.Back.Services;

import com.example.proyectodbp.Back.Entities.CarritoCompra;
import com.example.proyectodbp.Back.Repositories.CarritoCompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarritoCompraService {
    private final CarritoCompraRepository carritoCompraRepository;

    @Autowired
    public CarritoCompraService(CarritoCompraRepository carritoCompraRepository) {
        this.carritoCompraRepository = carritoCompraRepository;
    }

    public List<CarritoCompra> findAllCarritosCompra() {
        return carritoCompraRepository.findAll();
    }

    public Optional<CarritoCompra> findCarritoCompraById(Long id) {
        return carritoCompraRepository.findById(id);
    }

    public CarritoCompra saveCarritoCompra(CarritoCompra carritoCompra) {
        return carritoCompraRepository.save(carritoCompra);
    }

    public void deleteCarritoCompra(Long id) {
        carritoCompraRepository.deleteById(id);
    }

    // Puedes agregar métodos adicionales según tus necesidades
}