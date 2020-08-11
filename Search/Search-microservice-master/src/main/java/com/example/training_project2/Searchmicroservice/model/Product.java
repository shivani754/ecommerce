package com.example.training_project2.Searchmicroservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@JsonInclude(value = JsonInclude.Include.NON_NULL)
@Document(indexName = "product", type = "product", shards = 1)
public class Product {
    @Id
    private String productId;

    private String productName;

    private String productCategory;

    private String pageNumber;

   @Field(type = FieldType.Nested)
    private List<Variant> variants;

    private String productDescription;

    private String imageURLs;


    public String getPageNumber() { return pageNumber; }

    public void setPageNumber(String pageNumber) { this.pageNumber = pageNumber; }

    public String getImageURLs() {
        return imageURLs;
    }

    public void setImageURLs(String imageURLs) {
        this.imageURLs = imageURLs;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public List<Variant> getVariants() {
        return variants;
    }

    public void setVariants(List<Variant> variants) {
        this.variants = variants;
    }
}