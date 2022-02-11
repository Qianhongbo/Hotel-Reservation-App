package model.customer;

import java.util.Objects;
import java.util.regex.Pattern;

public class Customer {

    private final String firstName;
    private final String lastName;
    private final String email;

    //if email is not valid, throw an error
    private void isValidEmail(String email) throws IllegalArgumentException {
        String emailFormat = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailFormat);
       if (!pattern.matcher(email).matches()){
           throw new IllegalArgumentException("Invalid Email! Please try again." + "\n");
       }
    }

    public Customer(String firstName, String lastName, String email){
        isValidEmail(email);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + ", email: " + email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName)
                && Objects.equals(email, customer.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, email);
    }

}
