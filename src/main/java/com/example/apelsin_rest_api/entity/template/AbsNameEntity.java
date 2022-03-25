package com.example.apelsin_rest_api.entity.template;

import com.example.apelsin_rest_api.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.util.List;

@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
@Data
public abstract class AbsNameEntity {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private boolean active = true;

}
