package model.customer;

public class testCustomer {
    public static void main(String[] args) {
        try {
            Customer customer = new Customer("lindon","ye","13ucsd.edu");
            System.out.println(customer.toString());
        }
        catch (IllegalArgumentException ex){
            System.out.println("illegal");
        }
    }
}
