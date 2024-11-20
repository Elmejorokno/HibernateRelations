package org.myapp.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer_details")
public class CustomerDetails {

    @Id
    @Column(name = "id")
    private Long id;

    @OneToOne
    @MapsId
    @JoinColumn(name = "id", nullable = false, unique = true)
    private Customer customer;

    @Column(name = "website")
    private String website;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "comments")
    private String comments;

    protected CustomerDetails() {}

    public CustomerDetails(String website, String phone, String comments) {
        this.website = website;
        this.phone = phone;
        this.comments = comments;
    }

    public Long getId() { return id; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) {
        if(customer != null) {
            this.customer = customer;
        }
    }

    public String getWebsite() { return website; }
    public void setWebsite(String website) { this.website = website; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getComments() { return comments; }
    public void setComments(String comments) { this.comments = comments; }

    @Override
    public String toString() {
        return "CustomerDetails: [id = " + id + ", website = " + website + ", phone = " + phone + ", comments = " + comments + "]";
    }
}