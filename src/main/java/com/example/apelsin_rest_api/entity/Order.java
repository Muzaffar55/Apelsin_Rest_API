package com.example.apelsin_rest_api.entity;

import com.example.apelsin_rest_api.entity.template.AbsNameEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Entity(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order extends AbsNameEntity {

    @Column(nullable = false)
    private Date date;

    @ManyToOne
    private Customer customer;
}
