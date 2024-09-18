package com.Shermawn.demo.services;

import com.Shermawn.demo.models.CategoryModel;
import com.Shermawn.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryModel> findAll(){
        return categoryRepository.findAll();
    }

    public CategoryModel findById(Long id){
        Optional<CategoryModel> objId = categoryRepository.findById(id);
        return objId.get();
    }
}
