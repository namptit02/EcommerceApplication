package org.example.cartservice.service;

//import org.example.cartservice.dto.request.IncreaseItemRequest;
import org.example.cartservice.dto.response.ProductResponse;
import org.example.cartservice.model.CartItem;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CartService {
//    private final Map<String, IncreaseItemRequest> cartItems = new HashMap<>();
//
//    public void increaseCartItem(String productId, int quantity) {
//        if (cartItems.containsKey(productId)) {
//            IncreaseItemRequest existingProduct = cartItems.get(productId);
//            existingProduct.setQuantity(existingProduct.getQuantity() + quantity);
//        } else {
//            // Handle case when the product is not in the cart
//        }
//    }
    private List<ProductResponse> productResponses = new ArrayList<>();

    public void addProductToCart(ProductResponse productResponse) {
        productResponses.add(productResponse);
    }

    public List<ProductResponse> getCartItems() {
        return productResponses;
    }
}
