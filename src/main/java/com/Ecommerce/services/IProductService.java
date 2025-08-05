package com.Ecommerce.services;

import com.Ecommerce.dtos.ProductDTO;
import com.Ecommerce.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {

    List<Product> getProducts();
    Product getProductbyID(Long id);
    Product updateProduct(ProductDTO product, Long id);
    void deleteProduct(Long id);
    Product createProduct(Product product);
}
