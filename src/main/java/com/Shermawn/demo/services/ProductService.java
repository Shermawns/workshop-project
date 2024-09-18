package com.Shermawn.demo.services;

import com.Shermawn.demo.models.ProductModel;
import com.Shermawn.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<ProductModel> findAll(){
        return productRepository.findAll();
    }

    public ProductModel findById(Long id){
        Optional<ProductModel> objId = productRepository.findById(id);
        return objId.get();
    }
}
