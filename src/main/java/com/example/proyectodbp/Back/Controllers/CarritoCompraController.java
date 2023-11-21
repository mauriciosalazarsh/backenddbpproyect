package com.example.proyectodbp.Back.Controllers;

import com.example.proyectodbp.Back.Services.CarritoCompraService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.proyectodbp.Back.Entities.CarritoCompra;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/carritos")
public class CarritoCompraController {
    private final CarritoCompraService carritoCompraService;

    @Autowired
    public CarritoCompraController(CarritoCompraService carritoCompraService) {
        this.carritoCompraService = carritoCompraService;
    }

    @GetMapping
    public List<CarritoCompra> getAllCarritosCompra() {
        return carritoCompraService.findAllCarritosCompra();
    }

    @GetMapping("/{id}")
    public Optional<CarritoCompra> getCarritoCompraById(@PathVariable Long id) {
        return carritoCompraService.findCarritoCompraById(id);
    }

    @PostMapping
    public CarritoCompra createCarritoCompra(@RequestBody CarritoCompra carritoCompra) {
        return carritoCompraService.saveCarritoCompra(carritoCompra);
    }

    @PutMapping("/{id}")
    public CarritoCompra updateCarritoCompra(@PathVariable Long id, @RequestBody CarritoCompra carritoCompra) {
        return carritoCompraService.saveCarritoCompra(carritoCompra);
    }

    @DeleteMapping("/{id}")
    public void deleteCarritoCompra(@PathVariable Long id) {
        carritoCompraService.deleteCarritoCompra(id);
    }

}

