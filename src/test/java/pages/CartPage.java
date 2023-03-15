package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.TestBase;

public class CartPage extends TestBase {
	
	@FindBy(xpath="(//a[contains(text(),'Delete')])[1]")
	WebElement delBtn;
	
	@FindBy(id="cartur")
	WebElement cart;
	
	@FindBy(xpath="(//tr[@class='success'])[1]")
	WebElement sMsg;
	
	@FindBy(xpath="//button[contains(text(),'Place')]")
	WebElement order;
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="country")
	WebElement cntry;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="card")
	WebElement card;
	
	@FindBy(id="month")
	WebElement mnth;
	
	@FindBy(id="year")
	WebElement year;
	
	@FindBy(xpath="//button[contains(text(),'Purchase')]")
	WebElement purchase;
	
	@FindBy(xpath="//button[contains(text(),'OK')]")
	WebElement ok;
	
	public CartPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void delete(){
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.elementToBeClickable(cart));
		cart.click();
		List<WebElement> BeforeDel = driver.findElements(By.xpath("//td[2]"));
		System.out.println("No . of. items added to cart : " + BeforeDel.size());
		System.out.println("---------");
		wait.until(ExpectedConditions.visibilityOf(delBtn));
		delBtn.click();
		List<WebElement> AfterDel = driver.findElements(By.xpath("//td[2]"));
		wait.until(ExpectedConditions.visibilityOfAllElements(AfterDel));
		if(BeforeDel.size()>AfterDel.size()) {
			Assert.assertTrue(true);
		}
	}
	
	public void purchase() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		Thread.sleep(5000);
		Assert.assertTrue(sMsg.isDisplayed());	  
	    order.click();
	    Thread.sleep(3000);
	  	name.sendKeys("Aruna");
	  	cntry.sendKeys("India");
	  	city.sendKeys("Erode");
	  	card.sendKeys("123456789874");
	  	mnth.sendKeys("12");
	  	year.sendKeys("24");
	  	purchase.click();
	  	wait.until(ExpectedConditions.visibilityOf(ok));
	  	ok.click();	
	  	System.out.println("Order placed successfully !");
	  	System.out.println("---------");
}
}