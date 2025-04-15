package com.example.contactmanager.service;


//package com.example.contactmanager.service;

import com.example.contactmanager.model.Contact;
import java.util.List;

public interface ContactService {
    List<Contact> getAllContacts();
    Contact getContactById(Long id);
    Contact saveContact(Contact contact);
    Contact updateContact(Long id, Contact contact);
    void deleteContact(Long id);
}
