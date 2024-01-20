package com.rootsfood.demo.domain.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "KITCHEN_ID")
    private Kitchen kitchen;

    @ManyToMany
    @JoinTable(name = "RESTAURANT_PAYMENT_FORM", joinColumns = @JoinColumn(name = "RESTAURANT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PAYMENT_FORM_ID"))
    private List<PaymentForm> paymentForm = new ArrayList<>();
}
