import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


//@JsonRootName("product")
public class Product {

    private String productName;
    private int yearOfProduction;
    private int price;
    private List<Customer> borrowers = new ArrayList<>();

    public Product() {
    }

    @JsonCreator
    public Product(@JsonProperty("prodName") String productName,
                   @JsonProperty("prodYear") int yearOfProduction,
                   @JsonProperty("prodPrice") int price,
                   @JsonProperty("prodBorrowers") List<Customer> borrowers) {
        this.productName = productName;
        this.yearOfProduction = yearOfProduction;
        this.price = price;
        this.borrowers = borrowers;
    }

    @JsonGetter
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @JsonGetter
    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    @JsonGetter
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @JsonGetter
    public List<Customer> getBorrowers() {
        return borrowers;
    }

    public void setBorrowers(List<Customer> borrowers) {
        this.borrowers = borrowers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return yearOfProduction == product.yearOfProduction &&
                price == product.price &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(borrowers, product.borrowers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, yearOfProduction, price, borrowers);
    }

    @Override
    public String toString() {
        return "Product{" +
                " productName='" + productName + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                ", price=" + price +
                ", borrowers=" + borrowers +
                '}';
    }
}

