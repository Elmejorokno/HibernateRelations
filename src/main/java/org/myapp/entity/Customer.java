package org.myapp.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private CustomerDetails customerDetails;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Order> orders = new ArrayList<>();

    protected Customer() {}

    public Customer(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public Long getId() { return id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public CustomerDetails getCustomerDetails() { return customerDetails; }
    public void setCustomerDetails(CustomerDetails customerDetails) {
        this.customerDetails = customerDetails;
        customerDetails.setCustomer(this);
    }

    public List<Order> getOrders() { return orders; }
    //public void setOrders(List<Order> orders) { this.orders = orders; }
    public void addOrder(Order order) {
        if(order != null) {
            orders.add(order);
            order.setCustomer(this);
        }
    }
    public void removeOrder(Order order) {
        orders.remove(order);
        order.setCustomer(null);
    }

    @Override
    public String toString() {
        return "Customer: [id = " + id + ", name = " + firstName + ", lastName = " + lastName +
                ", address = " + address + "]";
    }
}
