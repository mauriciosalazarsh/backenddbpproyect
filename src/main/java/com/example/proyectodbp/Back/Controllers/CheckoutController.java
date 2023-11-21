package com.example.proyectodbp.Back.Controllers;

import com.example.proyectodbp.Back.Services.CheckoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.proyectodbp.Back.Entities.Checkout;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/checkouts")
public class CheckoutController {
    private final CheckoutService checkoutService;

    @Autowired
    public CheckoutController(CheckoutService checkoutService) {
        this.checkoutService = checkoutService;
    }

    @GetMapping
    public List<Checkout> getAllCheckouts() {
        return checkoutService.findAllCheckouts();
    }

    @GetMapping("/{id}")
    public Optional<Checkout> getCheckoutById(@PathVariable Long id) {
        return checkoutService.findCheckoutById(id);
    }

    @PostMapping
    public Checkout createCheckout(@RequestBody Checkout checkout) {
        return checkoutService.saveCheckout(checkout);
    }

    @PutMapping("/{id}")
    public Checkout updateCheckout(@PathVariable Long id, @RequestBody Checkout checkout) {
        return checkoutService.saveCheckout(checkout);
    }

    @DeleteMapping("/{id}")
    public void deleteCheckout(@PathVariable Long id) {
        checkoutService.deleteCheckout(id);
    }
}
