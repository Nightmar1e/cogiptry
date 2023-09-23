package admin_user.service.impl;

import admin_user.model.Contact;
import admin_user.repository.ContactRepository;
import org.springframework.stereotype.Service;
import admin_user.service.ContactService;

import java.util.List;
@Service
public class ContactServiceImpl implements ContactService{
    private ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        super();
        this.contactRepository = contactRepository;
    }

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id).get();
    }

    @Override
    public Contact updateContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public void deleteContactById(Long id) {
        contactRepository.deleteById(id);
    }

}

