/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;
/**
 *
 * @author ismehene
 */
public class Hello {
     private String hello; 
     private String world; 

    public Hello() {
        
	    hello = "Hello";  
	    world = "World"; 
	  
    }
    public String formMessage(){ 
	 String message;  
	    message = hello + " "+ world;  
	    return message; 
	  } 
     
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    	Hello helloWorld = new Hello();  
	System.out.println(helloWorld.formMessage()); 
    }
    
}
