package admin_user.service;
import admin_user.model.Contact;
import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();

    Contact saveContact(Contact contact);

    Contact getContactById(Long id);

    Contact updateContact(Contact contact);

    void deleteContactById(Long id);

}
