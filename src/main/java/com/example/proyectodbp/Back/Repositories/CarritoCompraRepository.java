package com.example.proyectodbp.Back.Repositories;

import com.example.proyectodbp.Back.Entities.CarritoCompra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CarritoCompraRepository extends JpaRepository<CarritoCompra, Long> {

}
