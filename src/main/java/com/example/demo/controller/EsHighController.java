package com.example.demo.controller;



import org.elasticsearch.client.ElasticsearchClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EsHighController {

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;

//    @RequestMapping("/xxx")
//    public String xxx(){
//        elasticsearchRestTemplate.
//    }


}
