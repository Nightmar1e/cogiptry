package admin_user.model;


import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@Entity
@Table(name = "products_dtls")
public class Products {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_name")
    private String productName;

    private String description;
    private String price;
    private String quantity;

    public Products() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Products(String productName, String description, String price, String quantity) {
        super();
        this.productName = productName;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Products [id=" + id + ", productName=" + productName + ", description=" + description + ", price="
                + price + ", quantity=" + quantity + "]";
    }


}
