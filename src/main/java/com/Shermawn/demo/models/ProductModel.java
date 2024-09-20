package com.Shermawn.demo.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@NoArgsConstructor
@Entity
@Table(name = "TB_PRODUCT")
public class ProductModel implements Serializable {
    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    private String imgUrl;

    //Cria a coluna productCategory, em seguida cria uma coluna productId e categoryId.
    // No final, armazena tudo em uma lista de categories
    @ManyToMany
    @JoinTable(
            name = "TB_PRODUCT_CATEGORY",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<CategoryModel> categories = new ArrayList<>();

    @OneToMany(mappedBy = "id.productModel") // --> Declarar a coleção de itens na classe product
    private Set<OrderItemModel> items = new HashSet<>();

    public ProductModel(Long id, String name, String description, double price, String imgUrl) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.imgUrl = imgUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public List<CategoryModel> getCategories() {
        return categories;
    }

    @JsonIgnore
    public Set<OrderModel> getItems() {
        Set<OrderModel> set = new HashSet<>();
        for (OrderItemModel x : items){
            set.add(x.getOrderModel());
        }
        return set;
    }
}
