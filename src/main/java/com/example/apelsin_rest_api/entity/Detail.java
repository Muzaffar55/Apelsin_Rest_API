package com.example.apelsin_rest_api.entity;

import com.example.apelsin_rest_api.entity.template.AbsEntity;
import com.example.apelsin_rest_api.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Detail extends AbsNameEntity {

    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    @Column(nullable = false)
    private Integer quantity;
}
