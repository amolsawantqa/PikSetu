package SignupDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AmazonDemo1 {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumWebDriver\\SeleniumSoftwares\\chromedriver_win32_83\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
	    driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("lg q7");
		
		Thread.sleep(5000);
		
		/*List<WebElement> findElements = driver.findElements((By.xpath("//div[@id='issDiv0']")));			
		System.out.println("Size is"+findElements.size());		
		for(WebElement a:findElements)
		{
		    System.out.println(a.getText());
		    a.click();
		}
		*/
		
		driver.findElement((By.xpath("//div[@id='issDiv0']"))).click();
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//span[contains(text(),'LG Q7')]")).click();
		
		
	}

}
