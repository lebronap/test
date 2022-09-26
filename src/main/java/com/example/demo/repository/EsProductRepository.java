package com.example.demo.repository;

import com.example.demo.doc.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface EsProductRepository extends ElasticsearchRepository<Product, String> {

    List<Product> findBySkuNoAndTitle(String sku, String title);

    List<Product> findByTitleLike(String title);


    List<Product> findByPriceGreaterThan(Double price);
}
