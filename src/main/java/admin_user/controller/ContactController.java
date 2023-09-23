package admin_user.controller;

import admin_user.model.Contact;
import admin_user.service.ContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin-page")
public class ContactController {
    private ContactService contactService;

    public ContactController(ContactService contactService) {
        super();
        this.contactService = contactService;
    }

    @GetMapping("/contacts")
    public String listContacts(Model model) {
        model.addAttribute("contacts", contactService.getAllContacts());
        return "contacts";
    }

    @GetMapping("/contacts/new")
    public String createContactForm(Model model) {

        Contact contact = new Contact();
        model.addAttribute("contact", contact);
        return "add_contact";

    }

    @PostMapping("/contacts")
    public String saveContact(@ModelAttribute("contact") Contact contact) {
        contactService.saveContact(contact);
        return "redirect:/admin-page/contacts";
    }

    @GetMapping("/contacts/edit/{id}")
    public String editContactForm(@PathVariable Long id, Model model) {
        model.addAttribute("contact", contactService.getContactById(id));
        return "edit_contact";
    }

    @PostMapping("/contacts/{id}")
    public String updateContact(@PathVariable Long id,
                                @ModelAttribute("contact") Contact contact,
                                Model model) {

        Contact existingContact = contactService.getContactById(id);
        existingContact.setId(id);
        existingContact.setFirstName(contact.getFirstName());
        existingContact.setLastName(contact.getLastName());
        existingContact.setEmail(contact.getEmail());

        contactService.updateContact(existingContact);
        return "redirect:/admin-page/contacts";
    }


    @GetMapping("/contacts/{id}")
    public String deleteContact(@PathVariable Long id) {
        contactService.deleteContactById(id);
        return "redirect:/admin-page/contacts";
    }

}

