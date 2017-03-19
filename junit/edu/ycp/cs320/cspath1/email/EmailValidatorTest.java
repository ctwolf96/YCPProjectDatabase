package edu.ycp.cs320.cspath1.email;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class EmailValidatorTest {
	private EmailValidator emailValidator;
	private String[] validEmails;
	private String[] invalidEmails;
	
	@Before
	public void setUp(){
		setEmailValidator(new EmailValidator());
		validEmails = new String[] {  "mkyong@yahoo.com",
			"mkyong-100@yahoo.com", "mkyong.100@yahoo.com",
			"mkyong111@mkyong.com", "mkyong-100@mkyong.net",
			"mkyong.100@mkyong.com.au", "mkyong@1.com",
			"mkyong@gmail.com.com", "mkyong+100@gmail.com",
			"mkyong-100@yahoo-test.com" };
		
		invalidEmails = new String[] { "mkyong", "mkyong@.com.my",
				"mkyong123@gmail.a", "mkyong123@.com", "mkyong123@.com.com",
				".mkyong@mkyong.com", "mkyong()*@gmail.com", "mkyong@%*.com",
				"mkyong..2002@gmail.com", "mkyong.@gmail.com",
				"mkyong@mkyong@gmail.com", "mkyong@gmail.com.1a"
		};
				
	}
	
	@Test
	public void ValidEmailTest(){
		for (String temp : validEmails){
			boolean valid = emailValidator.validate(temp);
			assertEquals(valid, true);
		}
	}
	
	@Test
	public void InvalidEmailTest(){
		for (String temp : invalidEmails){
			boolean valid = emailValidator.validate(temp);
			assertEquals(valid, false);
		}
	}
		
	public EmailValidator getEmailValidator() {
		return emailValidator;
	}

	public void setEmailValidator(EmailValidator emailValidator) {
		this.emailValidator = emailValidator;
	}

	public String[] getValidEmails() {
		return validEmails;
	}

	public void setValidEmails(String[] validEmails) {
		this.validEmails = validEmails;
	}

	public String[] getInvalidEmails() {
		return invalidEmails;
	}
	
	public void setInvalidEmails(String[] invalidEmails) {
		this.invalidEmails = invalidEmails;
	}
}
