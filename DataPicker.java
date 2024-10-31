package Task26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DataPicker {
	public static void main(String[] args) throws Exception {
		// Set up WebDriver (make sure to set the path to your chromedriver)
		WebDriver driver = new ChromeDriver();

		try {
			// Maximize the browser window
			driver.manage().window().maximize();

			// Navigate to the jQuery UI Datepicker URL
			driver.get("https://jqueryui.com/datepicker/");

			// Wait for the iframe to be available and switch to it
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By.className("demo-frame")));

			// Find and click the date picker input field to open the calendar
			WebElement datePickerInput = driver.findElement(By.id("datepicker"));
			datePickerInput.click();

			// Wait for the calendar to load
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));

			// Click next button if necessary
			WebElement nextButton = driver.findElement(By.xpath("//a[@title='Next']"));
			WebElement day22 = null;

			nextButton.click();

			// Try to find the 22nd in the current month
			try {
				day22 = driver.findElement(By.xpath("//a[text()='22']"));
			} catch (Exception e) {
				// Wait again for the calendar to update
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("ui-datepicker-calendar")));
				day22 = driver.findElement(By.xpath("//a[text()='22']"));
			}

			// Click on the 22nd
			if (day22 != null) {
				day22.click();
			} else {
				System.out.println("Date 22 not found.");
			}

			 // Get the selected date from the input field and print it to the console
            String selectedDate = datePickerInput.getAttribute("value");
            System.out.println("Selected Date: " + selectedDate);
            
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			Thread.sleep(3000); 
			driver.quit(); // Close the browser
		}
	}
}
