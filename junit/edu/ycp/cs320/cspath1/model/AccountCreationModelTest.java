package edu.ycp.cs320.cspath1.model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.cspath1.email.EmailValidator;
import edu.ycp.cs320.cspath1.enums.ClassType;
import edu.ycp.cs320.cspath1.enums.MajorType;
import edu.ycp.cs320.cspath1.enums.UserType;

public class AccountCreationModelTest {
	private AccountCreationModel model;
	
	@Before
	public void setUp(){
		model = new AccountCreationModel();
	}
	
	@Test
	public void testSetEmail(){
		model.setEmail("cspath1@ycp.edu");
		String email1 = model.getEmail();
		model.setEmail("jbady@ycp.edu");
		String email2 = model.getEmail();
		model.setEmail("cwolf11@ycp.edu");
		String email3 = model.getEmail();
		model.setEmail("jhopkins1@ycp.edu");
		String email4 = model.getEmail();
		assertEquals(email1, "cspath1@ycp.edu");
		assertEquals(email2, "jbady@ycp.edu");
		assertEquals(email3, "cwolf11@ycp.edu");
		assertEquals(email4, "jhopkins1@ycp.edu");
	}
	
	@Test
	public void testSetUsername(){
		model.setUsername("cspath1");
		String username1 = model.getUsername();
		model.setUsername("jbady");
		String username2 = model.getUsername();
		model.setUsername("cwolf11");
		String username3 = model.getUsername();
		model.setUsername("jhopkins1");
		String username4 = model.getUsername();
		assertEquals(username1, "cspath1");
		assertEquals(username2, "jbady");
		assertEquals(username3, "cwolf11");
		assertEquals(username4, "jhopkins1");
	}
	
	@Test
	public void testSetPassword(){
		model.setPassword("password1");
		String password1 = model.getPassword();
		model.setPassword("password2");
		String password2 = model.getPassword();
		model.setPassword("password3");
		String password3 = model.getPassword();
		model.setPassword("password4");
		String password4 = model.getPassword();
		assertEquals(password1, "password1");
		assertEquals(password2, "password2");
		assertEquals(password3, "password3");
		assertEquals(password4, "password4");
		
	}
	
	@Test
	public void testSetClassType(){
		model.setClasstype(ClassType.FRESHMAN);
		ClassType freshman = model.getClasstype();
		model.setClasstype(ClassType.SOPHOMORE);
		ClassType sophomore = model.getClasstype();
		model.setClasstype(ClassType.JUNIOR);
		ClassType junior = model.getClasstype();
		model.setClasstype(ClassType.SENIOR);
		ClassType senior = model.getClasstype();
		assertEquals(freshman, ClassType.FRESHMAN);
		assertEquals(sophomore, ClassType.SOPHOMORE);
		assertEquals(junior, ClassType.JUNIOR);
		assertEquals(senior, ClassType.SENIOR);
	}
	
	@Test
	public void testSetMajorType(){
		model.setMajortype(MajorType.CE);
		MajorType CE = model.getMajortype();
		model.setMajortype(MajorType.CS);
		MajorType CS = model.getMajortype();
		model.setMajortype(MajorType.EE);
		MajorType EE = model.getMajortype();
		model.setMajortype(MajorType.ME);
		MajorType ME = model.getMajortype();
		assertEquals(ME, MajorType.ME);
		assertEquals(CS, MajorType.CS);
		assertEquals(CE, MajorType.CE);
		assertEquals(EE, MajorType.EE);
	}
	
	@Test
	public void testSetUserType(){
		model.setUsertype(UserType.ADMIN);
		UserType admin = model.getUsertype();
		model.setUsertype(UserType.FACULTY);
		UserType faculty = model.getUsertype();
		model.setUsertype(UserType.GUEST);
		UserType guest = model.getUsertype();
		model.setUsertype(UserType.STUDENT);
		UserType student = model.getUsertype();
		assertEquals(admin, UserType.ADMIN);
		assertEquals(faculty, UserType.FACULTY);
		assertEquals(guest, UserType.GUEST);
		assertEquals(student, UserType.STUDENT);
	}
	
	@Test
	public void testSetEmailValidator(){
		EmailValidator emailValidator = new EmailValidator();
		model.setEmailValidator(emailValidator);
		assertEquals(emailValidator, model.getEmailValidator());
	}
}
