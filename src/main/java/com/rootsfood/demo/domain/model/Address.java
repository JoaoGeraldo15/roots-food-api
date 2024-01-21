package com.rootsfood.demo.domain.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Embeddable
@Table(name = "ADDRESS")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Column(name = "ADDRESS_ZIP_CODE")
    private String zipCode;

    @Column(name = "ADDRESS_STREET")
    private String street;

    @Column(name = "ADDRESS_COMPLEMENT")
    private String complement;

    @Column(name = "ADDRESS_NEIGHBORHOOD")
    private String neighborhood;

    @ManyToOne
    @JoinColumn(name = "ADDRESS_CITY_ID")
    private City city;
}
