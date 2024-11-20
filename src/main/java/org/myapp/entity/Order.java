package org.myapp.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    protected Order() {}

    public Order(LocalDateTime orderDate, String paymentMethod) {
        this.orderDate = orderDate;
        this.paymentMethod = paymentMethod;
    }

    public Long getId() { return id; }

    public LocalDateTime getOrderDate() { return orderDate; }
    public void setOrderDate(LocalDateTime orderDate) { this.orderDate = orderDate; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    @Override
    public String toString() {
        return "Order [id = " + id + ", date = " + orderDate + ", paymentMethod = " + paymentMethod + ", customer = " + customer.getId() + "]";
    }
}
