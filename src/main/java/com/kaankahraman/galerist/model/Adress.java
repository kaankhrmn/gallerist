package com.kaankahraman.galerist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.dialect.function.SqlColumn;

@Entity
@Table(name = "adress")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Adress extends  BaseEntity {

    @Column(name="city")
    private String city;

    @Column(name = "district")
    private String district;

    @Column(name = "neighborhod")
    private String neighborhod;

    @Column(name = "street")
    private String street;

}
