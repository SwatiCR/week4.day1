package week4.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DragAndDrop {

	public static void main(String[] args) {
		//WebDriverManager for browser driver
		WebDriverManager.chromedriver().setup();

		//Launch the browser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("https://jqueryui.com/droppable/");

		//maximize the screen
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
		
		//switch to frame
		driver.switchTo().frame(0);
		
		//find the element
		WebElement drag = driver.findElement(By.id("draggable"));
		//find the element where to be dropped
		WebElement drop = driver.findElement(By.id("droppable"));
		
		Actions builder = new Actions(driver);		
		
		//drag from source to destination
		builder.dragAndDrop(drag, drop).perform();
		System.out.println(drag.getLocation());		
		
		System.out.println(drop.getText());

	}

}
