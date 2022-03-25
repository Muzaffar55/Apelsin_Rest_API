package com.example.apelsin_rest_api.entity;

import com.example.apelsin_rest_api.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product extends AbsEntity {

    private String name;

    @ManyToOne
    private Category category;

    private String description;

    private Integer price;

    private String photo;
}
