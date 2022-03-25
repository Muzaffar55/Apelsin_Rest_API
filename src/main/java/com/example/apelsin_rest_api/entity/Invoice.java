package com.example.apelsin_rest_api.entity;

import com.example.apelsin_rest_api.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.sql.Date;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Invoice extends AbsEntity {

    @OneToOne
    private Order order;

    @Column(nullable = false)
    private Double amount;

    @Column(nullable = false)
    private Date issued;

    @Column(nullable = false)
    private Date due;
}
