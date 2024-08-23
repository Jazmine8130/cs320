package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contact.Contact;

class ContactTest {

	@Test
	void testContact() {
		Contact contact = new Contact("320", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive"); 
		assertAll(
				
				() -> assertTrue(contact.getId().equals("320")),
				() -> assertTrue(contact.getFirstName().equals("Ariel")),
				() -> assertTrue(contact.getLastName().equals("Foor")),
				() -> assertTrue(contact.getPhone().equals("7751234567")),
				() -> assertTrue(contact.getAddress().equals("1550 E Newlands Drive"))
				);
		
	}
	
	@Test
	void testContactIdTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("32012345678", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
			});
	}
	
	@Test
	void testContactFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("320", "Ariel 12345", "Foor", "7751234567", "1550 E Newlands Drive");
			});
	}
	
	@Test
	void testContactLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("320", "Ariel", "Foor 123456", "7751234567", "1550 E Newlands Drive");
			});
	}
	
	@Test
	void testContactPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("320", "Ariel", "Foor", "775123456789", "1550 E Newlands Drive");
			});
	}
	
	@Test
	void testContactAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			new Contact("320", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive 1234567891");
			});
	}
	
	@Test
	void testContactIdNotNull() {
		Assertions.assertThrows( IllegalArgumentException.class, () -> {
			new Contact(null, "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
		});
	}
	
	@Test
	void testFirstNameNotNull() {
		Assertions.assertThrows( IllegalArgumentException.class, () -> {
			new Contact("320", null, "Foor", "7751234567", "1550 E Newlands Drive");
		});
	}
	
	@Test
	void testLastNameNotNull() {
		Assertions.assertThrows( IllegalArgumentException.class, () -> {
			new Contact("320", "Ariel", null, "7751234567", "1550 E Newlands Drive");
		});
	}
	
	@Test 
	void testPhoneNotNull() {
		Assertions.assertThrows( IllegalArgumentException.class, () -> {
			new Contact(null, "Ariel", "Foor", null, "1550 E Newlands Drive");
		});
	}
	
	@Test
	void testAddressNotNull() {
		Assertions.assertThrows( IllegalArgumentException.class, () -> {
			new Contact("320", "Ariel", "Foor", "7751234567", null);
		});
	}
	
	@Test
	void testSetFirstNameNull() {

		Contact contact = new Contact("320", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setFirstName(null);
			});
	} 
	
	@Test
	void testSetFirstName() {

		Contact contact = new Contact("320", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
		contact.setFirstName("August");
		assertTrue(contact.getFirstName().equals("August"));
			
	}
	
	@Test
	void testSetLastName() {

		Contact contact = new Contact("320", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
		contact.setLastName("September");
		assertTrue(contact.getLastName().equals("September"));
			
	}
	
	@Test
	void testSetLastNameNull() {

		Contact contact = new Contact("320", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setLastName(null);
			});
	} 
	
	@Test
	void testSetPhone() {

		Contact contact = new Contact("320", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
		contact.setPhone("7759876543");
		assertTrue(contact.getPhone().equals("7759876543"));
			
	}
	
	@Test
	void testSetPhoneNull() {

		Contact contact = new Contact("320", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setPhone(null);
			});
	} 
	
	@Test
	void testSetAddress() {

		Contact contact = new Contact("320", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
		contact.setAddress("350 Main Street");
		assertTrue(contact.getAddress().equals("350 Main Street"));
			
	}
	
	@Test
	void testSetAddressNull() {

		Contact contact = new Contact("320", "Ariel", "Foor", "7751234567", "1550 E Newlands Drive");
		Assertions.assertThrows(IllegalArgumentException.class, () ->{
			contact.setAddress(null);
			});
	}
	
}
