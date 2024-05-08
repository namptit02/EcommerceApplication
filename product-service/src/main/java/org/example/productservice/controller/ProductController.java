package org.example.productservice.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.productservice.dto.request.AddProductRequest;
import org.example.productservice.dto.request.ProductCreateRequest;
import org.example.productservice.dto.request.ProductUpdateRequest;
import org.example.productservice.dto.response.ApiResponse;
import org.example.productservice.dto.response.ProductResponse;
import org.example.productservice.repository.httpclient.CartClient;
import org.example.productservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@Slf4j
@CrossOrigin(origins = "http://localhost:3000/")
public class ProductController {
    @Autowired
    ProductService productService;
//

    //    @PostMapping("/{productId}/add-to-cart")
//    ApiResponse<ProductResponse> addProductToCart(@PathVariable String productId) {
//        AddProductRequest request = AddProductRequest.builder()
//                .productId(productId)
//
//                .build();
//        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
//        apiResponse.setResult(cartClient.addProductToCart(request));
//        return apiResponse;
//    }
//
//@PostMapping("/{productId}/add-to-cart")
//
//public ResponseEntity<ProductResponse> addProductToCart(@PathVariable String productId) {
//    ProductResponse response = productService.addProductToCart(productId);
//    return ResponseEntity.ok(response);
//}
    @PostMapping("/add-to-cart/{productId}")
    public ApiResponse<ProductResponse> addProductToCart(@PathVariable String productId) {
        ProductResponse response = productService.addProductToCart(productId);
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(response);
        return apiResponse;
    }


    @PostMapping
    ApiResponse<ProductResponse> createProduct(@RequestBody ProductCreateRequest productRequest) {
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.createProduct(productRequest));
        return apiResponse;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    ApiResponse<List<ProductResponse>> getAllProducts() {
        ApiResponse<List<ProductResponse>> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getAllProducts());
        return apiResponse;
    }

    @GetMapping("/{productId}")
    ApiResponse<ProductResponse> getProduct(@PathVariable("productId") String productId) {
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.getProduct(productId));
        return apiResponse;
    }

    @PatchMapping("/{productId}")
    ApiResponse<ProductResponse> updateProduct(@PathVariable String productId, @RequestBody ProductUpdateRequest
            request) {
        ApiResponse<ProductResponse> apiResponse = new ApiResponse<>();
        apiResponse.setResult(productService.updateProduct(productId, request));
        return apiResponse;
    }


}

