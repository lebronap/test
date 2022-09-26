package com.example.demo.controller;


import com.example.demo.base.Result;
import com.example.demo.doc.Product;
import com.example.demo.repository.EsProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class EsController {

    @Autowired
    private EsProductRepository esProductRepository;


    @PostMapping("/addProduct")
    public Result<Product> addProduct(@RequestBody Product product){
        Product save = esProductRepository.save(product);
        return new Result<Product>().setCode(200).setData(save);
    }

    @PostMapping("/updateProduct")
    public Result<Product> updateProduct(@RequestBody Product product){
        esProductRepository.save(product);
        return new Result<Product>().setCode(200).setData(product);
    }


    @GetMapping("getProductById")
    public Result<Product> getProductById(@RequestParam String id){
        Optional<Product> optionalProduct = esProductRepository.findById(id);
        return new Result<Product>().success(optionalProduct.get());
    }


    @PostMapping("deleteById")
    public Result deleteById(@RequestParam String id){
        esProductRepository.deleteById(id);
        return new Result<String>().success("删除成功");
    }

    @GetMapping("/getPageList")
    public Result getPageList(@RequestParam int pageNum, @RequestParam int pageSize){
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Product> products = esProductRepository.findAll(pageable);
        return new Result().success(products);
    }


    @GetMapping("/findByTilteLike")
    public Result findByTilteLike(String title){
        List<Product> byTitleLike = esProductRepository.findByTitleLike(title);
        return new Result().success(byTitleLike);
    }


    @GetMapping("/findByPriceGreaterThanEqual")
    public Result findByPriceGreaterThanEqual(Double price){
        List<Product> byTitleLike = esProductRepository.findByPriceGreaterThan(price);
        return new Result().success(byTitleLike);
    }

}
