package org.myapp;

import org.myapp.dao.CustomerDao;
import org.myapp.entity.Customer;
import org.myapp.entity.CustomerDetails;
import org.myapp.entity.Order;

import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main( String[] args ) {
        CustomerDao customerDao = new CustomerDao();

        /*Customer customer = new Customer("Tyler", "The Creator", "LA");
        customer.setCustomerDetails(new CustomerDetails(
                "https://golfwang.com/", "49846541", "hes weird"));

        customerDao.saveCustomer(customer);*/

        //customerDao.deleteCustomer(5L);

        /*Customer customer = customerDao.getCustomerById(16L);
        System.out.println(customer);
        System.out.println(customer.getCustomerDetails());*/

        /*customerDao.addOrderToCustomer(6L, new Order(LocalDateTime.now(), "Apple pay"));
        customerDao.addOrderToCustomer(6L, new Order(LocalDateTime.now(), "Apple pay"));
        customerDao.addOrderToCustomer(6L, new Order(LocalDateTime.now(), "Apple pay"));

        Customer customer = customerDao.getCustomerById(6L);
        List<Order> orders = customerDao.getOrdersByCustomerId(6L);

        for (Order order : orders) {
            System.out.println(order);
        }

        System.out.println(customer.getCustomerDetails());*/

    }
}
