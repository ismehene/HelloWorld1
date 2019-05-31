package testUnit;

import static org.junit.Assert.*;
import model.Login;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.TestCase;

public class Testlog {
	private Login Login;
	
	/*public testlog(Login login) {
		
		Login = login;
	}
*/
    public Testlog() {
		
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() {
		//super.setUp();
		    Login = new Login("login","password");
		  }

	@Test
	public void testLogin()
	  {
	    assertNotNull("L'instance est cree", Login);
	  }
	 public void testGetLogin()
	  {
	    assertEquals("Est ce que nom est correct", "login", Login.getLogin());
	  }
	 public void testSetLogin()
	  {
		  Login.setLogin("password");
	    assertEquals("Est ce que nom est correct", "password", Login.getPassword());
	  }

}
