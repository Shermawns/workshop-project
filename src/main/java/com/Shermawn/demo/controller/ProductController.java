package com.Shermawn.demo.controller;
import com.Shermawn.demo.models.ProductModel;
import com.Shermawn.demo.models.UserModel;
import com.Shermawn.demo.services.ProductService;
import com.Shermawn.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductModel>> findAll(){
        List<ProductModel> list = productService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> findById(@PathVariable Long id){
        ProductModel obj = productService.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
