package testFonctionnel;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

	public class Hello {
		
	 public static WebDriver driver;  

	  public static void main( String[] args )  
	  {  

	   System.out.println("starting selenium web driver");  
	   driver = new FirefoxDriver();  
	   driver.get("http://localhost:5430/verif.jsp");

	   try{  
	    Thread.sleep(2000);  
	   }catch(Exception e){}  

	   driver.close();  
	   driver.quit();  
	  }  
}