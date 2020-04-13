import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@JsonRootName("database")
public class Database {

    private Set<Customer> customers;
    private List<Product> products;

    @JsonCreator
    public Database() {
        customers = new HashSet<>();
        products = new ArrayList<>();
    }

    @JsonGetter
    public Set<Customer> getCustomers(){
        return customers;
    }

    public void setCustomers(Set<Customer> customers) {
        this.customers = customers;
    }

    @JsonGetter
    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> movies) {
        this.products = movies;
    }

    @Override
    public String toString() {
        return "Database{" +
                "customers=" + customers +
                ", products=" + products +
                '}';
    }

}