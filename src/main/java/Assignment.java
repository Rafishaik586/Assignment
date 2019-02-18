import java.util.Arrays;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;

public class Assignment {

	boolean isSameName = false;
	
		   public static String[] credentials() {
			   
		       Object[] src = {"The Godfather", "Se7en","The Matrix","Ocean’s eleven","Not valid"};
		         //Object[] src = {"Not valid"};
		         String stringArray[] = Arrays.stream(src).toArray(String[]::new);
		         System.out.println(Arrays.toString(stringArray));
				return stringArray;
		    }
		   
		   
		   public  void movie_search(WebDriver driver,String movieName)
			 {   
			   try {
			//String[][] movieName = (String[][]) Assignment.credentials();
			driver.get("https://www.google.co.in/");
			  driver.manage().window().maximize();
			  driver.findElement(By.name("q")).clear();
			  driver.findElement(By.name("q")).sendKeys(movieName);
			  driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
				
			  driver.findElement(By.partialLinkText("Wikipedia")).click();
			  Thread.sleep(1000);
			  String wikiName = driver.findElement(By.xpath("//*[@class='infobox vevent']//tr//th[contains(text(),'Directed by')]//following-sibling::td")).getText().toString();
			  System.out.println(wikiName);
			     driver.navigate().back();
			     Thread.sleep(2000);
			     driver.navigate().refresh();
			     driver.findElement(By.partialLinkText("IMDb")).click();
			  Thread.sleep(1000);
			  String imdbName = driver.findElement(By.xpath("//div[@class='credit_summary_item']//h4[contains(text(),'Director')]//following-sibling::a")).getText().toString();
			  System.out.println(imdbName);
			  Thread.sleep(1000);
			if(wikiName.matches(imdbName))
			  {
			   isSameName=true;
			   Assert.assertEquals(true, isSameName);
			  }else {
				  isSameName=false;
				  System.out.println("Mismatch found in Wiki Name:: "+wikiName+"whereas ImDB Name is"+imdbName);
				  Assert.assertEquals(true, isSameName);
				  
			  }
		  
			   }catch(Exception e) {
				   System.out.println("Movie not found:: "+movieName);
				   Assert.assertFalse("Movie not found", isSameName);
			   }
			 }
}
