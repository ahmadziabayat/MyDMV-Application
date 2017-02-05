package com.ahmadzia.targetWebSiteTest;



import java.io.File;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import atu.testng.reports.ATUReports;
import atu.testng.reports.listeners.ATUReportsListener;
import atu.testng.reports.listeners.ConfigurationListener;
import atu.testng.reports.listeners.MethodListener;


/**
 * Author: Ahmad Zia Bayat
 * Date: 10/20/2016
 * Purpose: Learning about Selenium, Mavan, Jenkins, ATU, and Git
 */
public class AppTest {

private WebDriver driver;
String target = "http://www.target.com/";
List<WebElement> options;
ReadExcelFile excel = new ReadExcelFile();

@Listeners({ ATUReportsListener.class, ConfigurationListener.class,
	MethodListener.class })

public class ATUReporterSampleTests {
{
	System.setProperty("atu.reporter.config", "atu.properties");
}

	@BeforeTest
	public void setUp() throws Exception {
//		File file = new File("C:\\Users\\defaultuser0\\workspace\\targetWebSiteTest\\chromedriver.exe");
//		System.setProperty("webdriver.chrome.driver",file.getAbsolutePath());	
//	    driver = new ChromeDriver();
		
		File file = new File("C:\\Users\\defaultuser0\\Downloads\\geckodriver-v0.10.0-win64\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver",file.getAbsolutePath());
	    driver = new FirefoxDriver();
	   
	    ATUReports.setWebDriver(driver);
	    
	    driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@AfterTest
	public void tearDown() throws Exception {
	    driver.quit();
	}



	@Test(priority = 0)
	public void OpenWebPage_AddFirstItem() throws Exception 
		{
	    driver.get(target);
		}

	@Test(priority = 1)
	public void CheckCartQuantity() throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("js-cartQuantitySr")));
		String size = driver.findElement(By.className("js-cartQuantitySr")).getText();
		String itemSize = size.substring(0, 1);		
		int num = Integer.parseInt(itemSize);	
		if(num > 0){
			wait.until(ExpectedConditions.elementToBeClickable(By.className("js-cartQuantitySr")));
			driver.findElement(By.className("js-cartQuantitySr")).click();
			RemoveFromCart();
		}else{
			System.out.println("............");
		}
	}
	@Test(priority = 2)
	public void SearchFirstItemAndAddIt()
	{
	 driver.findElement(By.name("searchTerm")).clear();
	 driver.findElement(By.name("searchTerm")).sendKeys("Super Mario 3D Land (Nintendo 3DS)");
	 driver.findElement(By.id("searchReset")).submit();
	 
	 WebDriverWait wait = new WebDriverWait(driver, 10);
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='slp']/section[1]/div/div/ul/li[1]/div[1]/div/div[4]/button")));
	 
	 driver.findElement(By.xpath(".//*[@id='slp']/section[1]/div/div/ul/li[1]/div[1]/div/div[4]/button")).click();
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='block-ATC']/div[2]/div/div[2]/div[1]/div/div[2]/button[1]")));
	 
	 driver.findElement(By.xpath(".//*[@id='block-ATC']/div[2]/div/div[2]/div[1]/div/div[2]/button[1]")).click();
	 driver.findElement(By.xpath(".//*[@id='block-ATC']/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();
	}
	
	@Test(priority = 3)
	public  void  IncreaseQuantity(){
	// increase the quantity to 3 item in card2
	WebDriverWait wait = new WebDriverWait(driver, 10);
	wait.until(ExpectedConditions.elementToBeClickable(By.className("js-cart-qty-increase")));
	driver.findElement(By.className("js-cart-qty-increase")).click();	
	driver.findElement(By.className("js-cart-qty-increase")).click();	
	
	}
	@Test(priority = 4)
	public  void  DecreaseQuantity() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("js-cart-qty-decrease")));
		driver.findElement(By.className("js-cart-qty-decrease")).click();
		driver.findElement(By.className("js-cart-qty-decrease")).click();	
	
	}
	@Test(priority = 5)
	public void RemoveFromCart() throws InterruptedException
	{
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("remove-btn")));	
		driver.findElements(By.className("remove-btn")).get(0).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("remove-sflitem")));	
		driver.findElements(By.className("remove-sflitem")).get(0).click();
	}

	@Test(priority = 6)
	public void SearchSecondItem()
	{
 
	 driver.findElement(By.name("searchTerm")).clear();
	 driver.findElement(By.name("searchTerm")).sendKeys("Ultra Downy® April Fresh™ Liquid Fabric Conditioner 129 Fl oz.");
	 driver.findElement(By.id("searchReset")).submit();
 
	}
	
	@Test(priority = 7)
	public void AddSecondItem()
	{
//		driver.navigate().refresh();
		driver.findElement(By.xpath(".//*[@id='slp']/section[1]/div/div/ul/li[1]/div[1]/div/div[4]/button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("cart-ATC")));
		driver.findElement(By.className("cart-ATC")).click();

	}
	
	@Test(priority = 8)
	public void IncreaseDecreaseSecondItem()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.className("js-cart-qty-increase")));
		driver.findElement(By.className("js-cart-qty-increase")).click();	
		driver.findElement(By.className("js-cart-qty-increase")).click();	
		wait.until(ExpectedConditions.elementToBeClickable(By.className("js-cart-qty-decrease")));
		driver.findElement(By.className("js-cart-qty-decrease")).click();	
		driver.findElement(By.className("js-cart-qty-decrease")).click();
		wait.until(ExpectedConditions.elementToBeClickable(By.className("js-cart-qty-increase")));
		
	}
	
	@Test(priority = 9)
	public void SearchThirdItem()
	{
	
	 driver.findElement(By.name("searchTerm")).clear();
	 driver.findElement(By.name("searchTerm")).sendKeys("pencil sharpener");
	 driver.findElement(By.id("searchReset")).submit();
 
	}
	
	@Test(priority = 10)
	public void AddThirdItem()
	{
		driver.findElement(By.xpath(".//*[@id='slp']/section[1]/div/div/ul/li[1]/div[1]/div/div[4]/button")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='block-ATC']/div[2]/div/div[2]/div/div[1]/div[2]/button")));
		driver.findElement(By.xpath(".//*[@id='block-ATC']/div[2]/div/div[2]/div/div[1]/div[2]/button")).click();

	}
	
	@Test(priority = 11)
	public void ReadyToCheckOut()
	{	
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout-link")));
		driver.findElement(By.id("checkout-link")).click();
	}
	
	@Test(priority = 12)
	public void CheckOutAsGuest()
	{
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("guest-checkout-btn")));
		driver.findElement(By.id("guest-checkout-btn")).click();
	}
	
	@Test(priority = 13)
	public void ReadExcel()
	{
		driver.navigate().refresh();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
		
		
		excel.ExecelContent();
		Cell email = excel.email;
		Cell phone = excel.phone;
		Cell firstName = excel.firstName;
		Cell LastName = excel.lastName;
		Cell address = excel.Address;
		Cell city = excel.City;
		Cell zipcode = excel.ZipCode;
		
		
				
		if(isElementPresent(By.id("firstName")) && isElementPresent(By.id("lastName")))
			{
			driver.findElement(By.id("firstName")).sendKeys(firstName.toString());
			driver.findElement(By.id("lastName")).sendKeys(LastName.toString());
			
			driver.findElement(By.id("email")).sendKeys(email.toString());
			driver.findElement(By.name("phone")).sendKeys(phone.toString());
			driver.findElement(By.id("address1")).sendKeys(address.toString());
			
			driver.findElement(By.id("city")).sendKeys(city.toString());
			
			Select dropDownList = new Select(driver.findElement(By.id("state")));
			dropDownList.selectByValue("OH");
				
			driver.findElement(By.name("zip")).sendKeys(zipcode.toString());
			} else if (isElementPresent(By.id("fullName")))
			{
			driver.findElements(By.id("fullName")).get(0).sendKeys(firstName.toString()+" "+LastName.toString());
			
			driver.findElement(By.id("email")).sendKeys(email.toString());
			driver.findElement(By.name("phone")).sendKeys(phone.toString());
			driver.findElement(By.id("address1")).sendKeys(address.toString());
			
			driver.findElement(By.id("city")).sendKeys(city.toString());
			
			Select dropDownList = new Select(driver.findElement(By.id("state")));
			dropDownList.selectByValue("OH");
				
			driver.findElement(By.name("zip")).sendKeys(zipcode.toString());
			}
			
		
	}
	
	@Test(priority = 14)
	public void SaveContinous()
	{
		 WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(By.className("del-cont-payment")));
		 
		 driver.findElement(By.className("del-cont-payment")).click();
		 
		 try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		 
//		 Actions actions = new Actions(driver);
//		 actions.moveToElement(driver.findElement(By.id("avsaddressupdate_submit_btn"))).click().perform();;
		 driver.findElement(By.id("avsaddressupdate_submit_btn")).click();
	}
	
	@Test(priority = 15)
	public void InsertCreditCardNum()
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("cardNumber")));
		 
		 excel.ExecelContent();
		 Cell CreditCard = excel.CreditCard;
		 Cell Exp = excel.Exp;
		 Cell Cvv = excel.Cvv;
		 
		 driver.findElement(By.id("cardNumber")).sendKeys(CreditCard.toString());
		 
		 wait.until(ExpectedConditions.elementToBeClickable(By.id("expiry")));
		 if(isElementPresent(By.id("expiry")) && isElementPresent(By.id("cvv")))
			{
			 	driver.findElement(By.id("expiry")).sendKeys(Exp.toString());
			 	driver.findElement(By.id("cvv")).sendKeys(Cvv.toString());
			}
		 // Click on review my order button
		 driver.findElement(By.id("payment_save")).click();
		 
	}
	
		
	public void shouldWaitForPageToLoad(String id){
   
	    WebDriverWait wait = new WebDriverWait(driver, 10);
	    wait.until(ExpectedConditions.elementToBeClickable(By.id("id")));
	    
	}


	private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @SuppressWarnings("unused")
	private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

} 
}

