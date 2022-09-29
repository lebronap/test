package com.example.demo.controller;


import com.example.demo.base.Result;
import com.example.demo.doc.Product;
import com.example.demo.repository.EsProductRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Api(value = "es接口", tags = "es接口")
@RestController
public class EsController {

    @Autowired
    private EsProductRepository esProductRepository;


    @ApiOperation("新增")
    @PostMapping("/addProduct")
    public Result<Product> addProduct(@RequestBody Product product){
        Product save = esProductRepository.save(product);
        return new Result<Product>().setCode(200).setData(save);
    }

    @ApiOperation("更新")
    @PostMapping("/updateProduct")
    public Result<Product> updateProduct(@RequestBody Product product){
        esProductRepository.save(product);
        return new Result<Product>().setCode(200).setData(product);
    }


    @ApiOperation("查询")
    @GetMapping("getProductById")
    public Result<Product> getProductById(@RequestParam String id){
        Optional<Product> optionalProduct = esProductRepository.findById(id);
        return new Result<Product>().success(optionalProduct.get());
    }


    @ApiOperation("删除")
    @PostMapping("deleteById")
    public Result deleteById(@RequestParam String id){
        esProductRepository.deleteById(id);
        return new Result<String>().success("删除成功");
    }

    @ApiOperation("分页查询")
    @GetMapping("/getPageList")
    public Result getPageList(@RequestParam int pageNum, @RequestParam int pageSize){
        Pageable pageable = PageRequest.of(pageNum, pageSize);
        Page<Product> products = esProductRepository.findAll(pageable);
        return new Result().success(products);
    }

    @ApiOperation("模糊查询")
    @GetMapping("/findByTilteLike")
    public Result findByTilteLike(String title){
        List<Product> byTitleLike = esProductRepository.findByTitleLike(title);
        return new Result().success(byTitleLike);
    }

    @ApiOperation("findByPriceGreaterThanEqual")
    @GetMapping("/findByPriceGreaterThanEqual")
    public Result findByPriceGreaterThanEqual(Double price){
        List<Product> byTitleLike = esProductRepository.findByPriceGreaterThan(price);
        return new Result().success(byTitleLike);
    }


    @ApiOperation("创建多个文档")
    @GetMapping("createMore")
    public Result createMore(){
        for (int i = 0; i < 500; i++) {
            Product product = new Product();
            product.setSkuNo(String.valueOf(100000+i));
            product.setPrice(new BigDecimal(i));
            product.setDate(new Date());
            product.setTitle("商品sku"+i);
            esProductRepository.save(product);
        }
        return new Result<>().success("");
    }

}
