package admin_user.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "contacts")
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String email;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company affiliatedCompany;

    @ManyToMany
    @JoinTable(
            name = "contact_product",
            joinColumns = @JoinColumn(name = "contact_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> linkedProducts;
    public Contact() {
        // Default constructor
    }

    public Contact(String firstName, String lastName, String email, Company affiliatedCompany) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.affiliatedCompany = affiliatedCompany;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Company getAffiliatedCompany() {
        return affiliatedCompany;
    }

    public void setAffiliatedCompany(Company affiliatedCompany) {
        this.affiliatedCompany = affiliatedCompany;
    }

    public List<Product> getLinkedProducts() {
        return linkedProducts;
    }

    public void setLinkedProducts(List<Product> linkedProducts) {
        this.linkedProducts = linkedProducts;
    }
}
