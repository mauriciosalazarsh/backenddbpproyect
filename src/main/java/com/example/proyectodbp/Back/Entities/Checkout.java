package com.example.proyectodbp.Back.Entities;

import jakarta.persistence.*;

@Entity
@Table(name = "Checkout")
public class Checkout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "carrito_compra_id", unique = true)
    private CarritoCompra carritoCompra;

    // Constructor, getters y setters

    public Checkout() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CarritoCompra getCarritoCompra() {
        return carritoCompra;
    }

    public void setCarritoCompra(CarritoCompra carritoCompra) {
        this.carritoCompra = carritoCompra;
    }
}
