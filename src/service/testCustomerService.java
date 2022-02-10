package service;

public class testCustomerService {
    public static void main(String[] args) {
        CustomerService customerService = service.CustomerService.getSINGLETON();
        customerService.addCustomer("hoqian@ucsd.edu","hb","q");
        System.out.println(customerService.getCustomer("hoqian@ucsd.edu"));
        customerService.addCustomer("lye@ucsd.edu","l","ye");
        System.out.println(customerService.getAllCustomers());
    }
}
