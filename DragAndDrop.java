package Task26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DragAndDrop {
	public static void main(String[] args) {
		// Set up WebDriver (make sure to set the path to your ChromeDriver)
		WebDriver driver = new ChromeDriver();

		try {
			// Maximize the browser window
			driver.manage().window().maximize();

			// Navigate to the jQuery UI Droppable website
			driver.get("https://jqueryui.com/droppable/");

			// Wait for the iframe to be available and switch to it
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));

			// Find the source element (draggable)
			WebElement sourceElement = driver.findElement(By.id("draggable"));

			// Find the target element (droppable)
			WebElement targetElement = driver.findElement(By.id("droppable"));

			// Perform drag and drop operation
			Actions actions = new Actions(driver);
			actions.dragAndDrop(sourceElement, targetElement).perform();

			// Wait for the drop action to complete
			wait.until(ExpectedConditions.textToBePresentInElement(targetElement, "Dropped!"));

			// Verify that the text of the target element has changed to "Dropped!"
			String targetText = targetElement.getText();
			System.out.println("Target Text: " + targetText);
			if (targetText.equals("Dropped!")) {
				System.out.println("Drag and drop successful: Text changed to 'Dropped!'");
			} else {
				System.out.println("Drag and drop failed: Text did not change.");
			}

			// Verify that the background color has changed (example color)
			String targetColor = targetElement.getCssValue("background-color");
			System.out.println("Target Color: " + targetColor);
			if (targetColor.equals("rgba(255, 250, 144, 1)")) {
				System.out.println("Drag and drop successful: Target color changed to yellow.");
			} else {
				System.out.println("Drag and drop failed: Target color did not change.");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Close the browser after a delay (optional)
			try {
				Thread.sleep(3000); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			driver.quit(); // Close the browser
		}
	}
}
