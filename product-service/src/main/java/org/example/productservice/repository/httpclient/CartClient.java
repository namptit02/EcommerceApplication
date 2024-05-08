package org.example.productservice.repository.httpclient;

import org.example.productservice.dto.request.AddProductRequest;
import org.example.productservice.dto.response.ProductResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "cart-service", url = "http://localhost:8081")

public interface CartClient {
    @PostMapping(value = "/cart", produces = MediaType.APPLICATION_JSON_VALUE)
    ProductResponse addProductToCart(@RequestBody AddProductRequest request);}
