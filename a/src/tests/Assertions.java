package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertions {
//test	//testing
  @Test
  public void f() {
	  
	   //Soft assertion
	  
	  SoftAssert sf=new SoftAssert();
	  
	  
	  System.out.println("before sf1");
	  sf.assertEquals(12,13,"sf1");
	  System.out.println("after sf1");
	  
	  sf.assertEquals("a","b","sf2");
	  
	  //Hard assert
	  System.out.println("before hard assert");
	 // Assert.assertEquals(12,13,"fail");
	  System.out.println("after hard assert");
	  System.out.println("=================");
	  
	 
	  sf.assertAll();
	  
  }
  
}
