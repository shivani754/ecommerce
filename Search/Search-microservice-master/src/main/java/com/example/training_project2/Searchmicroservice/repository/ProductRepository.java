package com.example.training_project2.Searchmicroservice.repository;

import com.example.training_project2.Searchmicroservice.model.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findByProductNameAndProductCategory(String text);
    List<Product> findByProductCategory(String text);

}
