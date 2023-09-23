package admin_user.model;


import jakarta.persistence.*;
import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {

    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String number;
    private Date date;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company associatedCompany;

//    private String companyType;

    @ManyToMany(mappedBy = "linkedProducts")
    private List<Contact> contacts;

    public Product() {
        // Default constructor
    }

    public Product(String name, String number, Date date, Company associatedCompany, String companyType, Contact contact) {
        this.name = name;
        this.number = number;
        this.date = date;
        this.associatedCompany = associatedCompany;
//        this.companyType = companyType;
        this.contacts = contacts;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Company getAssociatedCompany() {
        return associatedCompany;
    }

    public void setAssociatedCompany(Company associatedCompany) {
        this.associatedCompany = associatedCompany;
    }

//    public String getCompanyType() {
//        return companyType;
//    }
//    public void setCompanyType(String companyType) {
//        this.companyType = companyType;
//    }

    public List<Contact> getContact() {
        return contacts;
    }

    public void setContact(Contact contact) {
        this.contacts = contacts;
    }


}
