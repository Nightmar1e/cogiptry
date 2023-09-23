package admin_user.repository;

import admin_user.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
    // You can define custom query methods here if needed
}