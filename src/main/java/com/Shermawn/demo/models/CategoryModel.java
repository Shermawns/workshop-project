package com.Shermawn.demo.models;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "TB_CATEGORY")
public class CategoryModel implements Serializable {

    private static final long serialversionUID = 1L;

    ///Entitys from JPA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    ///relation with many categories for many products
    @ManyToMany(mappedBy = "categories") // --> Mapeamento feito em products
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // --> Não criar um loop infinito
    private List<ProductModel> products = new ArrayList<>(); // --> Lista de produtos com categoria

    public CategoryModel(Long id, String name) {
        this.id = id;
        this.name = name;
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

    public List<ProductModel> getProducts() {
        return products;
    }
}
