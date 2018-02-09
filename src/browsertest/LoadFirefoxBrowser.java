package browsertest;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoadFirefoxBrowser
{
public static WebDriver driver;
public static WebDriverWait wait;
public static WebElement we1,we2,we3,we4,we5;
public static String str;

	public static void loadBrowser()
	{
		System.setProperty("webdriver.chrome.driver","D:\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.irctc.co.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 wait=new WebDriverWait(driver,20);
	}
	
	
	/*public static void loadUrl()
	{
		
	}*/
	
	public static void executeTask() throws Exception
	{
		we1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[1]/div/div[8]/div/div/ul/li[2]/a")));
		we1.click();
		List<WebElement>list=driver.findElements(By.xpath("html/body/div[1]/div/div[8]/div/div/ul/li[2]/ul/li"));
		System.out.println(list.size());
		for(int i=0;i<list.size();i++)
		{
			System.out.println(list.get(i).getText());
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("html/body/div[1]/div/div[8]/div/div/ul/li[2]/ul/li[1]/a")).click();
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		String parent=driver.getWindowHandle();
		driver.findElement(By.xpath(".//*[@id='bluemenu']/ul/li[2]/ul/li[1]/ul/li[1]/a")).click();
		System.out.println(driver.getCurrentUrl());
		Set set=driver.getWindowHandles();
		Iterator itr=set.iterator();
		while(itr.hasNext())
		{
			Object o=itr.next();
			String str=(String)o;
			if(parent.equalsIgnoreCase("str"))
			{
				
			}
			else
			{
				driver.switchTo().window(str);
			}
		}
		
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().window(parent);
		Thread.sleep(2000);
		System.out.println(driver.getCurrentUrl());
		
	}
	
	public static void main(String[] args) throws Exception 
	{
		LoadFirefoxBrowser.loadBrowser();
		//LoadFirefoxBrowser.loadUrl();
		LoadFirefoxBrowser.executeTask();
	}

}
