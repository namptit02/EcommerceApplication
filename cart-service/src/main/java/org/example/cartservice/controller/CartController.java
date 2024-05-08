package org.example.cartservice.controller;

import org.example.cartservice.dto.response.ProductResponse;
import org.example.cartservice.model.CartItem;
import org.example.cartservice.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin(origins = "http://localhost:3000/")

public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void addProductToCart(@RequestBody ProductResponse productResponse) {
        cartService.addProductToCart(productResponse);
    }

    @GetMapping
    public List<ProductResponse> getCartItems() {
        return cartService.getCartItems();
    }
}
