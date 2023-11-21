package com.example.proyectodbp.Back.Services;

import com.example.proyectodbp.Back.Entities.Checkout;
import com.example.proyectodbp.Back.Repositories.CheckoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CheckoutService {
    private final CheckoutRepository checkoutRepository;

    @Autowired
    public CheckoutService(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
    }

    public List<Checkout> findAllCheckouts() {
        return checkoutRepository.findAll();
    }

    public Optional<Checkout> findCheckoutById(Long id) {
        return checkoutRepository.findById(id);
    }

    public Checkout saveCheckout(Checkout checkout) {
        return checkoutRepository.save(checkout);
    }

    public void deleteCheckout(Long id) {
        checkoutRepository.deleteById(id);
    }
}
