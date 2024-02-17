package com.rootsfood.demo.domain.model.entity;

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

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DELIVERY_FEE", nullable = false)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "KITCHEN_ID")
    private Kitchen kitchen;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @ManyToMany
    @JoinTable(name = "RESTAURANT_PAYMENT_FORM", joinColumns = @JoinColumn(name = "RESTAURANT_ID"),
            inverseJoinColumns = @JoinColumn(name = "PAYMENT_FORM_ID"))
    private List<PaymentForm> paymentForm = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<Order> orders = new ArrayList<>();

    @OneToMany(mappedBy = "restaurant")
    private List<Product> productList = new ArrayList<>();

}
