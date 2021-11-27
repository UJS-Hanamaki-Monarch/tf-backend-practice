package org.tf.web.backend.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.tf.web.backend.entity.Product;

public interface ProductRepository extends ElasticsearchRepository<Product,String> {
    @Override
    Iterable<Product> findAll();
}
