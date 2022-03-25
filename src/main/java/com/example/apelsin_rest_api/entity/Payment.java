package com.example.apelsin_rest_api.entity;

import com.example.apelsin_rest_api.entity.template.AbsEntity;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends AbsEntity {

    @CreationTimestamp
    @Column(nullable = false)
    private Timestamp time;

    @Column(nullable = false)
    private Double amount;

    @ManyToOne
    private Invoice invoice;
}
