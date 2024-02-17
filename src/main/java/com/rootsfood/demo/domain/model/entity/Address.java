package com.rootsfood.demo.domain.model.entity;

import lombok.*;

import javax.persistence.*;

@Table(name = "ADDRESS")
@Getter @Setter
@Entity
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Column(name = "STREET")
    private String street;

    @Column(name = "COMPLEMENT")
    private String complement;

    @Column(name = "NEIGHBORHOOD")
    private String neighborhood;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CITY_ID")
    private City city;
}
