package com.rootsfood.demo.domain.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "RESTAURANT")
@Getter @Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DELIVERY_FEE")
    private BigDecimal deliveryFee;

    @Column(name = "ACTIVE")
    private Boolean isActive;

    @Column(name = "OPENED")
    private Boolean isOpened;

    @CreationTimestamp
    @Column(name = "REGISTRATION_DATE")
    private LocalDateTime registrationDate;

    @UpdateTimestamp
    @Column(name = "UPDATE_DATE")
    private LocalDateTime updateDate;

    @ManyToOne
    @JoinColumn(name = "KITCHEN_FK")
    private Kitchen kitchen;
}
