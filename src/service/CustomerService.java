package service;

import model.customer.Customer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CustomerService {

    private static CustomerService SINGLETON = new CustomerService();

    public static CustomerService getSINGLETON() {
        return SINGLETON;
    }

    private Map<String, Customer> customers = new HashMap<>();
    private CustomerService(){};

    public void addCustomer(String email, String firstName, String lastName){
        customers.put(email, new Customer(firstName, lastName, email));
    }

    public Customer getCustomer(String customerEmail){
        return customers.get(customerEmail);
    }

    public Collection<Customer> getAllCustomers() {
        return customers.values();
    }
}
