package com.Shermawn.demo.models.pk;
import com.Shermawn.demo.models.OrderModel;
import com.Shermawn.demo.models.ProductModel;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Embeddable
public class OrderItemPK implements Serializable {
    private static final long serialVersionUID = 1L;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderModel orderModel;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductModel productModel;


}
