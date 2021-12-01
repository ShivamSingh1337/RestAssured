package APITest;

import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Demo_TestNG2 {

	@BeforeClass
	public void BC()
	{	
		System.out.println("this is my second class");
	}
	@BeforeMethod
	public void BM()
	{
		System.out.println("this is before method");
	}
	@Test
	public void testcase3()
	{
		Assert.assertEquals("SHIVAM","SHIVAM");
		System.out.println("this is my second test");
	}
	@AfterTest
	public void AT()
	{
		System.out.println("this will execute after test");
	
	}
	@AfterSuite
	public void AS()
	{
		System.out.println("this will execute after suite");
	}
}
