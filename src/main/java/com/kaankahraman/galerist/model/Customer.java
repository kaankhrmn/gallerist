package com.kaankahraman.galerist.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")

public class Customer extends BaseEntity {
    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "tckn")
    private String tckn;

    @Column(name = "birth_of_date")
    private Date birthOfDate;

    //bir müşterinin bir tane adrsi olabilir.
    @OneToOne
    private Adress adress;
    //bir müşterinin bir tane hesap numarası olabilir.
    @OneToOne
    private Account account;
}
