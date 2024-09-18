package com.Shermawn.demo.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TB_CATEGORY")
public class CategoryModel implements Serializable {
    private static final long serialversionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public CategoryModel(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    @OneToMany(mappedBy = "categories")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<ProductModel> products = new ArrayList<>();
}
