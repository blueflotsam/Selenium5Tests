package basics;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class Login {
	public static void main(String[] args) throws InterruptedException {
	// system path for browser webdriver
	System.setProperty("webdriver.chrome.driver","C:\\SeleniumBrowserDrivers\\chromedriver.exe");
		
	//initiate webdriver
	WebDriver driver = new ChromeDriver();
		
	//open browser
	driver.get("http://zero.webappsecurity.com/");
	SoftAssert softassert= new SoftAssert();
	/*
	
	//By id
	driver.findElement(By.id("searchTerm")).sendKeys("transfer funds");
		
	//By name
	driver.findElement(By.name("searchTerm")).clear();
	driver.findElement(By.name("searchTerm")).sendKeys("Banana");
		
	//By classname
	driver.findElement(By.tagName("input")).sendKeys("By tagname");
		
	//by css	
	driver.findElement(By.cssSelector("#searchTerm")).clear();
	driver.findElement(By.cssSelector("#searchTerm")).sendKeys("#id");
	
	// css = .classname
	driver.findElement(By.cssSelector(".search-query")).clear();
	driver.findElement(By.cssSelector(".search-query")).sendKeys(".classname");
	
	//css =[attribute=value]
	driver.findElement(By.cssSelector("[placeholder='Search']")).clear();
	driver.findElement(By.cssSelector("[placeholder='Search']")).sendKeys("[attribute=value]");
	
	//css = tag
	driver.findElement(By.cssSelector("input")).clear();
	driver.findElement(By.cssSelector("input")).sendKeys("css tag");
	
	*/
	
	//successful sign in test
	driver.findElement(By.id("signin_button")).click();
	driver.findElement(By.name("user_login")).sendKeys("username");
	driver.findElement(By.name("user_password")).sendKeys("password");
	driver.findElement(By.name("submit")).click();
	String title="Privacy error";
	assertEquals(title, driver.getTitle());
	driver.close();

	
	//unsuccsful sign in test
	driver=new ChromeDriver();
	driver.get("http://zero.webappsecurity.com/");
	driver.findElement(By.id("signin_button")).click();
	driver.findElement(By.name("user_login")).sendKeys("invalid");
	driver.findElement(By.name("user_password")).sendKeys("attempt");
	driver.findElement(By.name("submit")).click();
	title="Zero - Log in";
	assertEquals(title, driver.getTitle());
	driver.close();
	
	//view money map
	driver=new ChromeDriver();
	driver.get("http://zero.webappsecurity.com/");
	driver.findElement(By.id("signin_button")).click();
	driver.findElement(By.name("user_login")).sendKeys("username");
	driver.findElement(By.name("user_password")).sendKeys("password");
	driver.findElement(By.name("submit")).click();
	driver.get("http://zero.webappsecurity.com/");
	driver.findElement(By.id("money_map_link")).click();
	title="Zero - My Money Map";
	assertEquals(title, driver.getTitle());
	driver.close();
	
	//view 2009 statements
	driver=new ChromeDriver();
	driver.get("http://zero.webappsecurity.com/");
	driver.findElement(By.id("signin_button")).click();
	driver.findElement(By.name("user_login")).sendKeys("username");
	driver.findElement(By.name("user_password")).sendKeys("password");
	driver.findElement(By.name("submit")).click();
	driver.get("http://zero.webappsecurity.com/");
	driver.findElement(By.id("money_map_link")).click();
	driver.findElement(By.id("online_statements_tab")).click();
	title="Zero - Online Statements";
	assertEquals(title, driver.getTitle());
	driver.close();
	
	//pay bills
	driver=new ChromeDriver();
	driver.get("http://zero.webappsecurity.com/");
	driver.findElement(By.id("signin_button")).click();
	driver.findElement(By.name("user_login")).sendKeys("username");
	driver.findElement(By.name("user_password")).sendKeys("password");
	driver.findElement(By.name("submit")).click();
	driver.get("http://zero.webappsecurity.com/bank/pay-bills.html");
	driver.findElement(By.className("span1")).sendKeys("100");
	driver.findElement(By.name("date")).sendKeys("2021-11-01");
	driver.findElement(By.id("pay_saved_payees")).click();
	title="Zero - Pay Bills";
	assertEquals(title, driver.getTitle());
	driver.close();
	
	
	
	
	//close browser
	softassert.assertAll();
		
	}
}
