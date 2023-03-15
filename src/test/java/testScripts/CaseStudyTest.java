package testScripts;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import base.TestBase;
import pages.CartPage;
import pages.HomePage;


public class CaseStudyTest extends TestBase{
	
	HomePage Home;
	HomePage Add;
	CartPage cart;
	
	@BeforeTest
	public void setup() {
		initialize();
	}
	
	@DataProvider(name="MultiData")
	public Object[][] getData() throws CsvValidationException, IOException{
		String path = System.getProperty("user.dir")+"//src//test//resources//caseStudyData//MultiData.csv";
		String[] cols;
		CSVReader reader = new CSVReader(new FileReader(path));
		ArrayList<Object> dataList = new ArrayList<Object>();
		while((cols = reader.readNext())!=null) {
			Object[] record = {cols[0]};
			dataList.add(record);
		}
		return dataList.toArray(new Object[dataList.size()][]);	  
	 }
	
	@Test(priority=1)
	public void log() throws InterruptedException {
		Home = new HomePage();
		Home.login();
	}
	
	@Test(priority=2,dataProvider="MultiData")
	public void addItem(String I) throws InterruptedException {
		Add = new HomePage();
		driver.findElement(By.linkText(I)).click();
		Add.addItem();
	}
	
	@Test(priority=3)
	public void purchase() throws InterruptedException {
		cart = new CartPage();
		cart.delete();
		cart.purchase();	
	}
}


