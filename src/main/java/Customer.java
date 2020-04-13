import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.GregorianCalendar;
import java.util.Objects;

@JsonRootName("customer")
public class Customer {

    private String firstName;
    private String lastName;
    private String pesel;
    private GregorianCalendar dateOfBirth;

    public Customer() {
    }

    //    @JsonCreator
//    public Customer(@JsonProperty("name") String firstName,
//                    @JsonProperty("surname") String lastName,
//                    @JsonProperty("pesel") String pesel,
//                    @JsonProperty("born") GregorianCalendar dateOfBirth) {
    @JsonCreator
    public Customer(String firstName,
                    String lastName,
                    String pesel,
                    GregorianCalendar dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
        this.dateOfBirth = dateOfBirth;
    }

    @JsonGetter
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @JsonGetter
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @JsonGetter
    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    @JsonGetter
    public GregorianCalendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(GregorianCalendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String toString() {
        String date = "not set";
        if (dateOfBirth!=null) {
            date = dateOfBirth.get(GregorianCalendar.DAY_OF_MONTH) + "." +
                    (dateOfBirth.get(GregorianCalendar.MONTH) + 1) + "." + dateOfBirth.get(GregorianCalendar.YEAR);
        }
        return "Customer{" +
                " firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", dateOfBirth=" + date +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return firstName.equals(customer.firstName) &&
                lastName.equals(customer.lastName) &&
                dateOfBirth.equals(customer.dateOfBirth);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, dateOfBirth);
    }
}
