package org.myapp.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.myapp.config.HibernateUtil;
import org.myapp.entity.Customer;
import org.myapp.entity.Order;

import java.util.List;

public class CustomerDao {
    private final SessionFactory sessionFactory;

    public CustomerDao() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public void saveCustomer(Customer customer) {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            session.persist(customer);

            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error saving customer.", e);
        }
    }

    public Customer getCustomerById(Long id) {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Customer customer = session.get(Customer.class, id);

            session.getTransaction().commit();
            return customer;
        } catch (Exception e) {
            throw new RuntimeException("Error getting customer.", e);
        }
    }

    public void deleteCustomer(Long id) {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Customer customer = session.get(Customer.class, id);

            if(customer != null) {
                session.remove(customer);
            }

            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error deleting customer.", e);
        }
    }

    public void addOrderToCustomer(Long id, Order order) {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            Customer customer = session.get(Customer.class, id);
            customer.addOrder(order);
            session.persist(order);

            session.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException("Error adding order.", e);
        }
    }

    public List<Order> getOrdersByCustomerId(Long id) {
        try(Session session = sessionFactory.getCurrentSession()) {
            session.beginTransaction();

            List<Order> orders = session.createQuery("FROM Order o WHERE o.customer.id = :id", Order.class)
                    .setParameter("id", id)
                    .getResultList();
            session.getTransaction().commit();
            return orders;
        } catch (Exception e) {
            throw new RuntimeException("Error getting orders.", e);
        }
    }
}
