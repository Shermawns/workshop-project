package com.Shermawn.demo.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "TB_PAYMENT")
public class PaymentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Instant moment;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_id")
    private OrderModel orderModel;

    public PaymentModel(Long id, Instant moment, OrderModel orderModel) {
        this.id = id;
        this.moment = moment;
        this.orderModel = orderModel;
    }
}
