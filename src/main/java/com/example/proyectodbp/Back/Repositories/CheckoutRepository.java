package com.example.proyectodbp.Back.Repositories;

import com.example.proyectodbp.Back.Entities.Checkout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<Checkout, Long> {
}
