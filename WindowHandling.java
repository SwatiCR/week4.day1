package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// We have to call WDM for the browser driver
		WebDriverManager.chromedriver().setup();

		//1	Launch the browser
		ChromeDriver driver = new ChromeDriver();

		//load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");

		//Maximize the browser
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

		//2.Enter the username
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");

		//3.Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");

		//4.click login
		driver.findElement(By.className("decorativeSubmit")).click();

		//5	Click crm/sfa link
		driver.findElement(By.linkText("CRM/SFA")).click();

		// 6	Click Leads link
		driver.findElement(By.linkText("Leads")).click();

		// 7	Click Merge link
		driver.findElement(By.linkText("Merge Leads")).click();
		
		//8		Click on From lead
		driver.findElement(By.xpath("//td[@class='titleCell']/following-sibling::td/a/img")).click();
		
		//9 	get window handles
		Set<String> windowHandles = driver.getWindowHandles();
		
		//convert to list
		List<String> lstWindowHandles = new ArrayList<String>(windowHandles);
		
		//switch to second window
		driver.switchTo().window(lstWindowHandles.get(1));
		System.out.println(lstWindowHandles.get(0));
		System.out.println(lstWindowHandles.get(1));
		
		//enter first name as babu
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Babu");
		
		//click on find leads
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(3000);
		
		//12	Click First Resulting lead
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		
		//Move the control back to first window
		driver.switchTo().window(lstWindowHandles.get(0));
		System.out.println(lstWindowHandles.get(0));
		
		String title = driver.getTitle();
		
		System.out.println(title);
	}

}
