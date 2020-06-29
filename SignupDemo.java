package SignupDemo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupDemo
 	{


		public static void main(String[] args) throws InterruptedException
		{
				
				System.setProperty("webdriver.chrome.driver", "F:\\SeleniumWebDriver\\SeleniumSoftwares\\chromedriver_win32_83\\chromedriver.exe");
		    	WebDriver driver = new ChromeDriver();
			    driver.get("File:///F:/SeleniumWebDriver/Task1/signup.html");
				driver.manage().window().maximize();				
				System.out.println(driver.getCurrentUrl());
				System.out.println(driver.getTitle());
				driver.findElement(By.id("firstname")).sendKeys("amolsaw");
				driver.findElement(By.id("lastname")).sendKeys("amolsaw");
				Select s =new Select(driver.findElement(By.id("country")));
				s.selectByIndex(1);
				List<WebElement>rdbtn=driver.findElements(By.id("gender"));
		        //System.out.println(rdbtn.size());
		        for(int i=0;i<rdbtn.size();i++)
		        {
		        	String rdval=rdbtn.get(i).getAttribute("value");
		        	System.out.println(rdval);
		        	if(rdval.equals("female"))
		        	{
		        		rdbtn.get(i).click();
		        	}
		        }
		       List<WebElement> checkbtn = driver.findElements(By.id("language"));
		       for(int i=0;i<checkbtn.size();i++)
		       {
		    	   checkbtn.get(i).click();		    	 
		    	   System.out.println(checkbtn.get(i).isSelected());		    	   
		       }
		       driver.findElement(By.id("mobilenumber")).sendKeys("9049417616");
		       driver.findElement(By.id("emailid")).sendKeys("amolsawant.qa@gmail.com"); ;
		       driver.findElement(By.id("address")).sendKeys("Pune"); ;
		       driver.findElement(By.name("submit")).click(); 
		       String actualtitle = driver.getTitle();
		       System.out.println("Actual Title"+actualtitle);  
		       if(actualtitle.equals("Welcome"))
		       {
		            System.out.println("sign up successfull");
		            Thread.sleep(4000);
		            //driver.findElement(By.linkText("Click Heredemo")).click();
		            driver.findElement(By.partialLinkText("Click")).click();		            
		            String loghead = driver.findElement(By.tagName("h1")).getText();
		            if(loghead.equals("Login Page"))
		            {
		            	System.out.println("landing login page successfully");
		            	driver.findElement(By.name("userid")).sendKeys("admin");
		            	driver.findElement(By.name("pswrd")).sendKeys("admin");
		            	driver.findElement(By.id("login")).click();
		            	String logsub=driver.findElement(By.tagName("p")).getText();
		            	if(logsub.equals("Welcome, Admin"))
		            	{
		            		System.out.println("login successfully");		            		
		            		WebElement logout=driver.findElement(By.linkText("Logout"));
		            		System.out.println(logout.isDisplayed());
		            		if(logout.isDisplayed())
		            		{
		            			System.out.println("Logout visible");
		            			logout.click();		            			
		            			String loghead2 = driver.findElement(By.tagName("h1")).getText();
		     		            if(loghead2.equals("Login Page"))
		     		            {
		     		            	System.out.println("Logout Succesfull and landing login page successfully");
		            			}
		     		            else
		     		            {
		     		            	System.out.println("Logout not Succesfull");
		     		            }
		            		}
		            		else
		            		{
		            			System.out.println("Logout not Visible");
		            		}           		
		            	}
		            	else
		            	{
		            		System.out.println(" login not successfully");
		            	}
		            }
		            else
		            {
		            	System.out.println("sign up not successfull");
		            }
		       }
		       else
		       {
		    	   System.out.println("signup not successfull");
		       }		    	   
				//driver.quit();
			}	
	}


