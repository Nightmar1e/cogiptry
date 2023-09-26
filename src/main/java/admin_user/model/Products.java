package admin_user.model;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

@Entity
@Table(name = "products_dtls")
public class Products {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name")
    private String productName;

    private String email;
    private String price;
    private String quantity;

    public Products() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Products(String productName, String description, String price, String quantity) {
        super();
        this.productName = productName;
        this.email = description;
        this.price = price;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String description) {
        this.email = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Products [id=" + id + ", productName=" + productName + ", description=" + email + ", price="
                + price + ", quantity=" + quantity + "]";
    }


}
