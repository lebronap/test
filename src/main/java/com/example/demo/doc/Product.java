package com.example.demo.doc;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * indexName是索引的名称， createIndex：true指不存在时则创建
 * @Id：索引id
 * @Field: type字段的类型， format：查询出时间格式化类型
 */
@Data
@Document(indexName = "product", createIndex = true)
public class Product implements Serializable {

    @Id
    @Field(type = FieldType.Text)
    private String id;

    @Field(type = FieldType.Text)
    private String skuNo;

    @Field(type = FieldType.Text)
    private String title;


    @Field(type = FieldType.Double)
    private BigDecimal price;

    @Field(type = FieldType.Date, format = DateFormat.basic_date_time)
    private Date date;
}
