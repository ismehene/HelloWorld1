package testUnit;
import model.Hello;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;

public class TestHello {

	 Hello helloWorldInstance;
	
	
	public TestHello() {
		
	}

	/*@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		 System.out.println("* HelloWorldTest: Before method setUp()");
	        helloWorldInstance = new Hello();
	}*/

	@Before
	public void setUp() {
		System.out.println("* HelloWorldTest: Before method setUp()");
        helloWorldInstance = new Hello();
	}

	/*@Test
	public void test() {
		fail("Not yet implemented");
	}*/
	@After
    public void tearDown() {
        System.out.println("* HelloWorldTest: After method tearDown()");
        helloWorldInstance = null;
    }
	public void testFormMessage() {
        //Asserts that two Strings are equal                
        String expResult = "Hello World";
        String result = helloWorldInstance.formMessage();
        System.out.println("* HelloWorldTest: test method 1 testFormMessage()");
         Assert.assertEquals(expResult, result);
    }   
    


}
