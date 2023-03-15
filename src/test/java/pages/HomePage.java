package pages;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(id="login2")
	WebElement loginOpt;
	
	@FindBy(id="loginusername")
	WebElement name;
	
	@FindBy(id="loginpassword")
	WebElement pwd;
	
	@FindBy(xpath="(//button[@class='btn btn-primary'])[3]")
	WebElement logBtn;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement home;
	
	@FindBy(xpath="//a[contains(text(),'Add')]")
	WebElement addBtn;
	
	@FindBy(id="cartur")
	WebElement cart;
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	public void login() throws InterruptedException {
		loginOpt.click();
		Thread.sleep(3000);
		name.sendKeys("ArunaN");
		pwd.sendKeys("abc@123");
		logBtn.click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).isDisplayed());
	}
	
	public void addItem()  {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(addBtn));
		addBtn.click();
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
	    alert.accept();
	    System.out.println("---------");
  	  	System.out.println("Item added to cart successfully");
  	  	System.out.println("---------");
	    home.click();
	}
}
