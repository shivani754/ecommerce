package com.example.training_project2.Searchmicroservice.DTOs;

import java.util.List;

public class ProductDTO {
    private String productId;

    private String productName;

    private String productCategory;

    private String pageNumber;

    private List<VariantDTO> variants;

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

    public List<VariantDTO> getVariants() {
        return variants;
    }

    public void setVariants(List<VariantDTO> variants) {
        this.variants = variants;
    }
}