package APITest;



import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Demo_TestNG {
	//before running any class/test if you want to run then we can use before suite
@BeforeSuite
	public void BS()
	{
		System.out.println("this is going to execute befire any test");
	}
      @BeforeTest
      public void BT()
      {
    	  System.out.println("this is going to run after suite");
      }
      
      @Test
      public void testcase1()
      {
    	  System.out.println("this is my first testcase");
      }
      @AfterClass
  public void AC()
  {
	  System.out.println("this wi;; execute after class");
  }
}

