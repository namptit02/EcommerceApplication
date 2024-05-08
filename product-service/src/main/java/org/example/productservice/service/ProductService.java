package org.example.productservice.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.productservice.dto.request.AddProductRequest;
import org.example.productservice.dto.request.ProductCreateRequest;
import org.example.productservice.dto.request.ProductUpdateRequest;
import org.example.productservice.dto.response.ProductResponse;
import org.example.productservice.exception.AppException;
import org.example.productservice.exception.ErrorCode;
import org.example.productservice.mapper.ProductMapper;
import org.example.productservice.model.Product;
import org.example.productservice.repository.ProductRepository;
import org.example.productservice.repository.httpclient.CartClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    private CartClient cartClient;

    public ProductResponse addProductToCart(String productId) {
        // Tìm sản phẩm bằng id
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));

        // Tạo yêu cầu thêm sản phẩm vào giỏ hàng
        AddProductRequest request = AddProductRequest.builder()
                .productId(productId)
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .build();

        // Thêm sản phẩm vào giỏ hàng sử dụng client
        return cartClient.addProductToCart(request);
    }
    public ProductResponse createProduct(ProductCreateRequest request) {
        // create product
        Product product = productMapper.toProduct(request);
//        log.info("Product created: {}", product.getId() + "Is created successfully.");
        return productMapper.toProductResponse(productRepository.save(product));

    }

    public List<ProductResponse> getAllProducts() {
        // get all products
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .imageUrl(product.getImageUrl())
                .build();
    }

public ProductResponse updateProduct(String productId, ProductUpdateRequest productUpdateRequest) {
    // Tìm sản phẩm cần cập nhật từ repository
    Product product = productRepository.findById(productId)
            .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND));

    // Cập nhật các thông tin chỉ định từ productUpdateRequest
    if (productUpdateRequest.getName() != null) {
        product.setName(productUpdateRequest.getName());
    }
    if (productUpdateRequest.getDescription() != null) {
        product.setDescription(productUpdateRequest.getDescription());
    }
    if (productUpdateRequest.getPrice() != null) {
        product.setPrice(productUpdateRequest.getPrice());
    }
    if (productUpdateRequest.getImageUrl() != null) {
        product.setImageUrl(productUpdateRequest.getImageUrl());
    }

    // Lưu sản phẩm đã cập nhật vào repository
    Product updatedProduct = productRepository.save(product);

    // Chuyển đổi và trả về response
    return productMapper.toProductResponse(updatedProduct);
}


    public ProductResponse getProduct(String id) {
        return productMapper.toProductResponse(productRepository.findById(id)
                .orElseThrow(() -> new AppException(ErrorCode.PRODUCT_NOT_FOUND)));
    }



}
