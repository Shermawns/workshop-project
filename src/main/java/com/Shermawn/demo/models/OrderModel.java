package com.Shermawn.demo.models;
import com.Shermawn.demo.enums.OrderStatus;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "TB_ORDER")
public class OrderModel implements Serializable {
    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private UserModel client;

    @OneToMany(mappedBy = "id.orderModel")
    private Set<OrderItemModel> items = new HashSet<>();

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    public OrderModel(Long id, Instant moment, UserModel client, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        setOrderStatus(orderStatus);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getMoment() {
        return moment;
    }

    public void setMoment(Instant moment) {
        this.moment = moment;
    }

    public UserModel getClient() {
        return client;
    }

    public void setClient(UserModel client) {
        this.client = client;
    }

    public Set<OrderItemModel> getItems() {
        return items;
    }

    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(String.valueOf(orderStatus));
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null){
        this.orderStatus = OrderStatus.valueOf(orderStatus.getCode());
        }
    }
}
