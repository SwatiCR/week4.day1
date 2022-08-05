package week4.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) {
		//WebDriverManager for browser driver
		WebDriverManager.chromedriver().setup();

		//Launch the browser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("http://www.leafground.com/pages/Alert.html");

		//maximize the screen
		driver.manage().window().maximize();
		
		//click on prompt alert
		driver.findElement(By.xpath("//button[text()='Prompt Box']")).click();
		
		//move control to alert box
		Alert alert = driver.switchTo().alert();
		
		//click ok
		alert.accept();
		
		//get message
		String text = driver.findElement(By.id("result1")).getText();
		
		System.out.println(text);

	}

}
