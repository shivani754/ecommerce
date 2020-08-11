package com.example.training_project2.Searchmicroservice.service;


import com.example.training_project2.Searchmicroservice.DTOs.ProductDTO;
import com.example.training_project2.Searchmicroservice.DTOs.SuccessFailureResponseDTO;
import com.example.training_project2.Searchmicroservice.model.Product;

import java.util.List;


public interface SearchService {

    SuccessFailureResponseDTO loadData(ProductDTO productDTO);
    List<ProductDTO> search_all();


    //  FOR DEBUG: REMOVE IT LATER
    SuccessFailureResponseDTO delete_all();
}
