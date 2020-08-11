package com.example.training_project2.Searchmicroservice.load;

import com.example.training_project2.Searchmicroservice.model.Product;
import com.example.training_project2.Searchmicroservice.model.Variant;
import com.example.training_project2.Searchmicroservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class Loaders {

//    @Autowired
//    ElasticsearchOperations operations;
//
//    @Autowired
//    ProductRepository productRepository;
//
//    @PostConstruct
//    @Transactional
//    public void loadAll(){
//
//        operations.putMapping(Product.class);
//        System.out.println("Loading Data");
////        productRepository.save(getData());
//        System.out.printf("Loading Completed");
//
//    }
//
//    private List<Product> getData() {
//        List<Product> products = new ArrayList<>();
//
//        Variant variant1 = new Variant();
//        variant1.setRam("3gb");
//        variant1.setColour("Black");
//
//        Variant variant2 = new Variant();
//        variant2.setRam("16gb");
//        variant2.setColour("Silver");
//
//        List<Variant> variantsArray1 =  new ArrayList<>();
//        variantsArray1.add(variant1);
//        variantsArray1.add(variant2);
//
//
////        products.add(new Product("2345","Iphone x","smart phones",variantsArray1));
////        products.add(new Product("456","Avengers T shirt","Shirts",null));
////        products.add(new Product("6756","Samsung galaxy","smart phones",variantsArray1));
//
//
//        return products;
//    }
}
