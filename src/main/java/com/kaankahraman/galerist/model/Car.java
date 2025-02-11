package com.kaankahraman.galerist.model;

import com.kaankahraman.galerist.enums.CarStatusType;
import com.kaankahraman.galerist.enums.CurrencyType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "car")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Car extends BaseEntity {
    @Column(name = "plaka")
    private String plaka;

    @Column(name = "model")
    private String model;

    @Column(name = "brand")
    private String brand;

    @Column(name = "production_year")
    private Integer productionYear;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "currency_type")
    @Enumerated(EnumType.STRING)
    private CurrencyType currencyType;

    @Column(name = "damage_price")
    private BigDecimal damagePrice;

    @Column(name = "car_status_type")
    @Enumerated(EnumType.STRING)
    private CarStatusType carStatusType;

}
