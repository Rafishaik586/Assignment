import static org.junit.Assert.*;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



public class UnitTest {
	
	static WebDriver driver;
	Assignment a = new Assignment();
	String[] cred =Assignment.credentials();

	@BeforeTest
	public void initConfig() {
		System.setProperty("webdriver.chrome.driver", ".\\src\\main\\resources\\chromedriver.exe");
		driver=  new ChromeDriver();
	}
	
	 @DataProvider(name = "movie_name")
	   public static Object[][] getMovieName() {	   
		return new Object[][] {{"The Godfather"},{"Se7en"},{"The Matrix"},{"Ocean’s eleven"},{"Not valid"}};
    }
	 
	@Test(dataProvider= "movie_name")
	public void test(String src) {
			a.movie_search(driver,src);
	}
	
	 @AfterTest
		public void closeDriverInstance() {
		 //driver.close();
		 driver.quit();
		}
	   

}