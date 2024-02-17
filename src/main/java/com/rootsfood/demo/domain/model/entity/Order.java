package com.rootsfood.demo.domain.model.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDER")
@Getter @Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "SUBTOTAL")
    private BigDecimal subTotal;

    @Column(name = "DELIVERY_FEE")
    private BigDecimal deliveryFee;

    @Column(name = "TOTAL_AMOUNT")
    private BigDecimal totalAmount;

    @CreationTimestamp
    @Column(name = "CREATION_DATE")
    private LocalDateTime creationDate;

    @Column(name = "CONFIRMATION_DATE")
    private LocalDateTime confirmationDate;

    @Column(name = "CANCELLATION_DATE")
    private LocalDateTime cancellationDate;

    @Column(name = "DELIVERY_DATE")
    private LocalDateTime deliveryDate;

    @Column(name = "STATUS")
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RESTAURANT_ID")
    private Restaurant restaurant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User client;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PAYMENT_FORM_ID", nullable = false)
    private PaymentForm paymentForm;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItemList = new ArrayList();
}
