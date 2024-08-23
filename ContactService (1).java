package contact;

import java.util.ArrayList;

import contact.Contact;

public class ContactService{
	
	private ArrayList<Contact> contactList = new ArrayList<>();
	
	public void addNewContact(String id, String firstName, String lastName, String phone, String address) {
		for(Contact contact : contactList) {
			if (contact.getId().equals(id)) {
				throw new IllegalArgumentException("That contact id is in use");
			}
		}
		
		Contact contact1 = new Contact(id, firstName, lastName, phone, address);
		contactList.add(contact1);
		System.out.println("Contact added");
	}
	
	public void updateContact(String id, String firstName, String lastName, String phone, String address) {
		for(Contact contact : contactList) {
			if (contact.getId().equals(id)) {
				contact.setFirstName(firstName);
				contact.setLastName(lastName);
				contact.setPhone(phone);
				contact.setAddress(address);
				System.out.println("Contact updated: " + contact);
				return;
			}
		} 
		throw new IllegalArgumentException("This ID is not in use");
	}

	public void deleteContact(String id) {
		for(Contact contact : contactList) {
			if (contact.getId().equals(id)) {
				contactList.remove(contact);
				System.out.println("Contact deleted");
				return;
			}
		}
		throw new IllegalArgumentException("This ID is not in use");
	}
	
	public boolean getId(String id) {
		for(Contact contact : contactList) {
			if (contact.getId().equals(id)) {
				return true;
			}
		}
		throw new IllegalArgumentException("This ID is not in use");
	}
	
	public ArrayList<Contact> getContactList(){
		return contactList;
	}
}
