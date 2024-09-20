package com.Shermawn.demo.models;
import com.Shermawn.demo.models.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@NoArgsConstructor
@Entity
@Table(name = "TB_ORDER_ITEM")
public class OrderItemModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private OrderItemPK id = new OrderItemPK(); // --> Instanciar a chave composta que vai conectar products com order
    private int quantity;
    private double price;



    //Construtor com Order e Product, porém com id no começo pois é pra associar com a chave composta OrderItemPk
    public OrderItemModel(OrderModel orderModel, ProductModel productModel, int quantity, double price) {
        id.setOrderModel(orderModel);
        id.setProductModel(productModel);
        this.quantity = quantity;
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @JsonIgnore// -->Evita que o método seja considerado na serialização/deserialização JSON
    public OrderModel getOrderModel() {
        return id.getOrderModel();
    }

    public void setOrderModel(OrderModel orderModel) {
        id.setOrderModel(orderModel);
    }
    public ProductModel getProductModel() {
        return id.getProductModel();
    }

    public void setProductModel(ProductModel productModel) {
        id.setProductModel(productModel);
    }
}
