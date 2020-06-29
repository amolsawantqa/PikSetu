package SignupDemo;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertDemo {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumWebDriver\\SeleniumSoftwares\\chromedriver_win32_83\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
	    driver.get("File:///F:/SeleniumWebDriver/Task1/signup.html");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		Alert alert = driver.switchTo().alert();
		String alertmsg = alert.getText();		
		if(alertmsg.equals("please enter first"))
		{
			System.out.println(alertmsg);
			alert.accept();
		}
		else
		{
			System.out.println("msg is not matched");
			alert.dismiss();
		}		
	}
}
