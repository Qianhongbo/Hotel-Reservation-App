package service;

public class testCustomerService {
    public static void main(String[] args) {
        CustomerService customerService = service.CustomerService.getSINGLETON();
        customerService.addCustomer("hbq@gmail.com","hb","q");
        System.out.println(customerService.getCustomer("hbq@gmail.com"));
        customerService.addCustomer("lye@ucsd.edu","l","ye");
        System.out.println(customerService.getAllCustomers());

    }
}
