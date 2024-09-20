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

    //Entitys
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant moment;


    //Muitos pedidos pra um cliente, aplicando as relações com o UserModel
    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private UserModel client;


    // A anotação OneToMany indica que um pedido (OrderModel) pode ter vários itens (OrderItemModel).
    // O "mappedBy = 'id.orderModel'" indica que o mapeamento está sendo feito com base no campo orderModel dentro da chave composta 'id'.
    // A lista de itens é armazenada em um Set para garantir que não haja duplicatas.
    @OneToMany(mappedBy = "id.orderModel")
    private Set<OrderItemModel> orders = new HashSet<>();


    // Ao invés de aparecer números no banco de dados, aparece a String do orderStatus
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;


    public OrderModel(Long id, Instant moment, UserModel client, OrderStatus orderStatus) {
        this.id = id;
        this.moment = moment;
        this.client = client;
        setOrderStatus(orderStatus); // --> Aplicar no constructor o orderStatus do pedido
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
        return orders;
    }


    // O método valueOf converte o valor atual de 'orderStatus' (presumivelmente armazenado como um número ou string)
    // em um valor do enum OrderStatus. O String.valueOf(orderStatus) garante que o valor de 'orderStatus' seja convertido
    // em uma string antes de ser convertido para o enum correspondente.
    public OrderStatus getOrderStatus() {
        return OrderStatus.valueOf(String.valueOf(orderStatus));
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        if (orderStatus != null){
        this.orderStatus = OrderStatus.valueOf(orderStatus.getCode());
        }
    }
}
