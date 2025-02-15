package com.Shermawn.demo.controller;
import com.Shermawn.demo.models.OrderModel;
import com.Shermawn.demo.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderModel>> findAll(){
        List<OrderModel> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderModel> findById(@PathVariable Long id){
        OrderModel objId = orderService.findById(id);
        return ResponseEntity.ok().body(objId);
    }
}
