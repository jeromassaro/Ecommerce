package com.Ecommerce.services;

import com.Ecommerce.dtos.ProductDTO;
import com.Ecommerce.models.Product;
import com.Ecommerce.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getProductbyID(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public Product updateProduct(ProductDTO product, Long id) {
        Product oldProduct = productRepository.findById(id).orElse(null);
        if (oldProduct != null) {
            oldProduct.setPrice(product.getPrice());
            oldProduct.setImage(product.getImage());
            return productRepository.save(oldProduct);
        }
        return null;
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
