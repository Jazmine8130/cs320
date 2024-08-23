package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.ContactService;

class ContactServiceTest {

	@Test
	void testContactServiceAdd() {

		ContactService service = new ContactService();
		service.addNewContact("3201", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
		assertTrue(service.getId("3201"));
	}
	
	
	@Test
	void testContactServiceUpdate() {

		ContactService service = new ContactService();
		service.addNewContact("1234", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
		service.updateContact("1234", "August", "September", "7759876543", "350 Main Street");
		assertAll (
		()->assertEquals("August", service.getContactList().get(0).getFirstName()),
		()->assertEquals("September", service.getContactList().get(0).getLastName()),
		()->assertEquals("7759876543", service.getContactList().get(0).getPhone()),
		()->assertEquals("350 Main Street", service.getContactList().get(0).getAddress())
		);
	}
	
	@Test
	void testContactServiceDelete() {
		
		ContactService service = new ContactService();
		service.addNewContact("320", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
		service.deleteContact("320");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			service.getId("320");
			});
	} 
	
	@Test
	void testContactServiceIdInUse() {
		
		ContactService service = new ContactService();
		service.addNewContact("320", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
		Assertions.assertThrows( IllegalArgumentException.class, () -> {
			service.addNewContact("320", "August", "September", "7759876543", "350 Main Street");
		});
	}
	
	
	@Test
	void testContactServiceUpdateNotInList() {
		ContactService service = new ContactService();
		Assertions.assertThrows( IllegalArgumentException.class, () -> {
			service.updateContact("0002", "August", "September", "7759876543", "350 Main Street");
		});
	}
	
	@Test
	void testContactServiceDeleteNotInList() {
		ContactService service = new ContactService();
		Assertions.assertThrows( IllegalArgumentException.class, () -> {
			service.deleteContact("3202");
		});
	}
}
