package com.example.training_project2.Searchmicroservice.builder;

import com.example.training_project2.Searchmicroservice.model.Product;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;
import static org.elasticsearch.index.query.QueryBuilders.termQuery;

@Component
public class SearchQueryBuilder {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;


    public List<Product> getByMasterSearch(String requestParam) {

        QueryBuilder query = boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(requestParam)
                                .lenient(true)
                                .field("productName")
                                .field("productCategory")
                                .field("productDescription")
                        // .boost(4)
                ).should(QueryBuilders.queryStringQuery("*" + requestParam + "*")
                        .lenient(true)
                        .field("productName")
                        .field("productCategory")
                        .boost(3)
                ).should(QueryBuilders.queryStringQuery(requestParam)
                        .field("productDescription")
                        .boost(2)
                ).should(QueryBuilders.queryStringQuery("*" + requestParam + "*")
                        .field("productDescription")
                        .boost(2))
                .should(QueryBuilders.nestedQuery(
                        "variants", boolQuery()
                                .should(termQuery("variants.ram", requestParam))
                                .should(termQuery("variants.colour", requestParam))))

                .should(QueryBuilders.fuzzyQuery("productCategory", requestParam)
                        .boost(2)
                )
                .should(QueryBuilders.fuzzyQuery("productDescription", requestParam)
                        .boost(1)
                );


        NativeSearchQuery build = new NativeSearchQueryBuilder().withQuery(query).build();

        List<Product> products = elasticsearchTemplate.queryForList(build, Product.class);

        return products;
    }


    public List<Product> getByCategory(String requestParam) {
        QueryBuilder query = boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(requestParam)
                                .lenient(true)
//                                .field("productName")
                                .field("productCategory")
//                                .field("productDescription")
                ).should(QueryBuilders.queryStringQuery("*" + requestParam + "*")
                                .lenient(true)
//                        .field("productName")
                                .field("productCategory")
                ).should(QueryBuilders.nestedQuery("variants", boolQuery()
                                .should(termQuery("variants.ram",    requestParam))
                                .should(termQuery("variants.colour", requestParam)))
                ).should(QueryBuilders.fuzzyQuery("productCategory", requestParam)

                );

        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        List<Product> products = elasticsearchTemplate.queryForList(build, Product.class);

        return products;

    }



    public List<Product>category(String requestParam) {                     //only category
        QueryBuilder query = boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(requestParam)
                                .lenient(true)
                                .field("productCategory")
                ).should(QueryBuilders.queryStringQuery("*" + requestParam + "*")
                                .lenient(true)
                                .field("productCategory").boost(2)
                );

        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        List<Product> products = elasticsearchTemplate.queryForList(build, Product.class);

        return products;

    }











    public List<Product> getAllByBasicSearch(String requestParam) {


        QueryBuilder query = boolQuery()
                .should(
                        QueryBuilders.queryStringQuery(requestParam)
                                .lenient(true)
                                .field("productName")
                                .field("productCategory")
                                .field("productDescription")
                ).should(QueryBuilders.queryStringQuery("*" + requestParam + "*")
                        .lenient(true)
                        .field("productName")
                        .field("productCategory")
                        .field("productDescription")
                ).should(QueryBuilders.nestedQuery(
                        "variants", boolQuery().should(termQuery("variants.ram", requestParam)).should(
                                termQuery("variants.colour", requestParam))));


        NativeSearchQuery build = new NativeSearchQueryBuilder()
                .withQuery(query)
                .build();

        List<Product> products = elasticsearchTemplate.queryForList(build, Product.class);

        return products;
    }

}