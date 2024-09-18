package com.Shermawn.demo.controller;
import com.Shermawn.demo.models.CategoryModel;
import com.Shermawn.demo.models.UserModel;
import com.Shermawn.demo.services.CategoryService;
import com.Shermawn.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ResponseEntity<List<CategoryModel>> findAll(){
        List<CategoryModel> list = categoryService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryModel> findById(@PathVariable Long id){
        CategoryModel obj = categoryService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
