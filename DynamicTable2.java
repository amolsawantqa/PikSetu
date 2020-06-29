package SignupDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable2 {

	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumWebDriver\\SeleniumSoftwares\\chromedriver_win32_83\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
	    driver.get("https://falkencreative.com/forum/records/view.php");
		driver.manage().window().maximize();		
		driver.findElement(By.linkText("Add a new record")).click();		
		WebElement fname=driver.findElement(By.xpath("//input[@name='firstname']"));		
		fname.sendKeys("Amol");		
		String searchfname=fname.getAttribute("value");			
		System.out.println(searchfname);		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Sawant");
		driver.findElement(By.xpath("//input[@type='submit']")).click();	 		
	    driver.findElement(By.xpath("//td[contains(text(),'"+searchfname+"')]//following::td[2]")).click();	 //edit click
	    
	    //Edit First Name
	    WebElement fname1=driver.findElement(By.xpath("//input[@name='firstname']"));
	    fname1.sendKeys("S");
	    String searchfname1=fname1.getAttribute("value");	    
	    driver.findElement(By.xpath("//input[@type='submit']")).click();	
	    
	    //Display ID
	    String id = driver.findElement(By.xpath("//td[contains(text(),'"+searchfname1+"')]//preceding::td[1]")).getText();  //get id
	    System.out.println("ID="+id);
	    
	    //Display Parent 
	    WebElement Parenttag = driver.findElement(By.xpath("//td[contains(text(),'"+searchfname1+"')]//parent::*"));  //get parent
	    System.out.println("Parent="+Parenttag.getTagName());
	    
	    //Display GrandParent
	    WebElement Grandparent = driver.findElement(By.xpath("//td[contains(text(),'"+searchfname1+"')]//ancestor::*"));  //get grand parent
	    System.out.println("Ancestor="+Grandparent.getTagName());
	    
	  //Display ParentofParent
	    WebElement GrandparentP = driver.findElement(By.xpath("//td[contains(text(),'"+searchfname1+"')]//parent::*//parent::*"));  //get grand parent
	    System.out.println("Ancestor="+Grandparent.getTagName());
	    
	    //Delete Record
	    driver.findElement(By.xpath("//td[contains(text(),'"+searchfname1+"')]//following::td[3]")).click();  //delete click
	    	    
	    try
	    {
	    	driver.findElement(By.xpath("//td[contains(text(),'"+searchfname1+"')]"));
	    }catch(Exception E)
	    {
	    	System.out.println("Record Deleted Successfully");
	    }
	    System.out.println("Program Successfully Executed");
	 }
}
