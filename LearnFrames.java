package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrames {

	public static void main(String[] args) {
		/*Assignment
		1_ Open Chrome
		2_ Load https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm
		3_ Click TryIt (not: this is inside frame)
		4_ Click Cancel on the alert
		5_ Print the resulting text*/

		//WebDriverManager for browser driver
		WebDriverManager.chromedriver().setup();

		//Launch the browser
		ChromeDriver driver = new ChromeDriver();

		//Load the URL
		driver.get("https://www.w3schools.c"
				+ "om/js/tryit.asp?filename=tryjs_confirm");

		//maximize the screen
		driver.manage().window().maximize();

		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(90));

		//switch to frame with id
		driver.switchTo().frame("iframeResult");

		//click on try it
		driver.findElement(By.xpath("//button[text()='Try it']")).click();

		//switch to alert
		Alert alert = driver.switchTo().alert();
		
		//click on cancel
		alert.dismiss();
		
		String text = driver.findElement(By.id("demo")).getText();
		
		System.out.println(text);



	}

}
