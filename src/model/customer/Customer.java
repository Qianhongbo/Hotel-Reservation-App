package model.customer;

import java.util.regex.Pattern;

public class Customer {

    private String firstName;
    private String lastName;
    private String email;

    //if email is not valid, throw an error
    private void isValidEmail(String email){
        String emailFormat = "^(.+)@(.+).(.+)$";
        Pattern pattern = Pattern.compile(emailFormat);
       if (!pattern.matcher(email).matches()){
           throw new IllegalArgumentException();
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
        return "customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
