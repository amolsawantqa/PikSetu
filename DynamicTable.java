package SignupDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTable {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\SeleniumWebDriver\\SeleniumSoftwares\\chromedriver_win32_83\\chromedriver.exe");
    	WebDriver driver = new ChromeDriver();
	    driver.get("https://falkencreative.com/forum/records/view.php");
		driver.manage().window().maximize();		
		driver.findElement(By.linkText("Add a new record")).click();		
		WebElement name=driver.findElement(By.xpath("//input[@name='firstname']"));		
		name.sendKeys("Amol");		
		String searchname=name.getAttribute("value");			
		System.out.println(searchname);		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Sawant");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	    /*
		List<WebElement> row =driver.findElements(By.xpath("//td[contains(text(),'"+searchname+"')]"));		
		System.out.println(row.get(index));		
		*/					
        WebElement mytable = driver.findElement(By.xpath("/html/body/table/tbody"));        
        List<WebElement> rows = mytable.findElements(By.tagName("tr"));        
        int rowcount = rows.size();        
        l: for(int row=0;row<rowcount;row++)
        {
        	List<WebElement> columns = rows.get(row).findElements(By.tagName("td"));        	 
        	int columncount = columns.size();        	
        	for(int column=0;column<columncount;column++)
        	{
        		if(columns.get(column).getText().equals(searchname))
        		{
        			WebElement edit=rows.get(row).findElement(By.xpath("//td//a[contains(text(),'Edit')]"));
        			edit.click();
        			break l;
        		}
        	}
        }   
    }

}
