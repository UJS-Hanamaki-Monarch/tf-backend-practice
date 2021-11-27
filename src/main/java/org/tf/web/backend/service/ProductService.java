package org.tf.web.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.tf.web.backend.entity.Product;
import org.tf.web.backend.repository.ProductRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    public Optional<Product> getProduct(String id) {
        return productRepository.findById(id);
    }

    public void deleteProduct(String id) {
        productRepository.deleteById(id);
    }

    public Iterable<Product> insertBulk(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<Product> findAll(){
        List<Product> productList = new ArrayList<>();
        Iterable<Product> productIterable = productRepository.findAll();
        productIterable.forEach(productList::add);
        return productList;
    }


}
