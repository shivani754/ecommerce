package com.example.training_project2.Searchmicroservice.controllers;

import com.example.training_project2.Searchmicroservice.DTOs.ProductDTO;
import com.example.training_project2.Searchmicroservice.DTOs.SuccessFailureResponseDTO;
import com.example.training_project2.Searchmicroservice.builder.SearchQueryBuilder;
import com.example.training_project2.Searchmicroservice.model.Product;
import com.example.training_project2.Searchmicroservice.repository.ProductRepository;
import com.example.training_project2.Searchmicroservice.service.SearchService;
import com.oracle.tools.packager.Log;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
public class SearchController {


    @Autowired
    private SearchService searchService;

    @Autowired
    private SearchQueryBuilder searchQueryBuilder;



    @GetMapping(value = "/search_all")
    public List<ProductDTO> searchAll() {
        return searchService.search_all();
    }


    @PostMapping("/uploadData")
    public SuccessFailureResponseDTO loadData(@RequestBody ProductDTO productDTO) {
         return searchService.loadData(productDTO);

    }


    @GetMapping("/search/{searchParam}")
    public List<Product> searchByQuerry( @PathVariable("searchParam") String searchParam) {
        Log.info("Getting into search builder");
        return searchQueryBuilder.getByMasterSearch(searchParam);
    }


    @GetMapping("/categorysearch/{searchParam}")              //based on ram,color,productCategory
    public List<Product> searchByQuery(@PathVariable("searchParam") String searchParam){
        return  searchQueryBuilder.getByCategory(searchParam);
    }


    @GetMapping("onlycategory/{searchParam}")               //only category
    public List<Product> searchByQuerrry(@PathVariable("searchParam") String searchParam){
        return searchQueryBuilder.category(searchParam);
    }

    //Todo: if any way to restrict null values showing?
    //Todo: ask how to apply filters?


    // For Debugging :
    @DeleteMapping("/deleteAllData")
    public SuccessFailureResponseDTO deleteAllData() {
            return searchService.delete_all();

    }

    //    // For Debugging
//    @DeleteMapping("/delete")
//    public Boolean deleteAllData(@RequestParam(value = "productId") String productId) {
//        try {
//            ProductRepository.delete(productId);
//            return true;
//        } catch (Exception e) {
//            return false;
//        }
//
//    }


}
