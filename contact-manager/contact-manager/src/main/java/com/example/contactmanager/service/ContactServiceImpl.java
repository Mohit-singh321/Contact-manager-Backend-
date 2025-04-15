package com.example.contactmanager.service;

//package com.example.contactmanager.service;

import com.example.contactmanager.model.Contact;
import com.example.contactmanager.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    @Override
    public Contact getContactById(Long id) {
        return contactRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contact not found"));
    }

    @Override
    public Contact saveContact(Contact contact) {
        return contactRepository.save(contact);
    }

    @Override
    public Contact updateContact(Long id, Contact updatedContact) {
        Contact existingContact = getContactById(id);
        existingContact.setName(updatedContact.getName());
        existingContact.setEmail(updatedContact.getEmail());
        existingContact.setPhone(updatedContact.getPhone());
        return contactRepository.save(existingContact);
    }

    @Override
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }
}

