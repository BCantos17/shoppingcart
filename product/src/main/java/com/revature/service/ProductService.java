package com.revature.service;


import com.revature.data.Product;
import com.revature.data.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getProductById(int id) {
        return productRepository.findOne(id);
    }

    public void save(Product product) {
        productRepository.save(product);
    }
}
