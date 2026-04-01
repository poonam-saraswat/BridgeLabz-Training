// POJO CLASS OR Model layer

import java.util.Objects;

public class Contact implements Comparable<Contact> {

    // Contact attributes
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String state;
    private String zip;
    private String phoneNumber;
    private String email;


    // constructor for intialization
    public Contact(String firstName, String lastName, String address, String city, String state, String zip, String phoneNumber, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // setters for attributes
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setZip(String zip){
        this.zip = zip;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email){
        this.email = email;
    }


    // getters for attributes
    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getAddress(){
        return address;
    }

    public String getCity(){
        return city;
    }

    public String getState(){
        return state;
    }

    public String getZip(){
        return zip;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public String getEmail(){
        return email;
    }


    // overriding methods
    // Usecase - 7
    @Override
    public boolean equals(Object obj){
        if(this == obj){
            return true;
        }

        if(obj ==  null || getClass() != obj.getClass()) return false;

        Contact c = (Contact) obj;

        return firstName.equalsIgnoreCase(c.firstName) && lastName.equalsIgnoreCase(c.lastName);
    }

    @Override
    public int hashCode(){
        return Objects.hash(firstName.toLowerCase(), lastName.toLowerCase());
    }

    // Usecase - 11
    @Override
    public int compareTo(Contact other) {
        int firstNameCompare =
                this.firstName.compareToIgnoreCase(other.firstName);

        if (firstNameCompare != 0) {
            return firstNameCompare;
        }
        return this.lastName.compareToIgnoreCase(other.lastName);
    }

    @Override
    public String toString() {
        return firstName + " " + lastName +
               " | " + phoneNumber +
               " | " + email +
               " | " + address + ", " + city + ", " + state + ", " + zip;
    }

}
