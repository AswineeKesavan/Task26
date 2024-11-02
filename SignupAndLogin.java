package Task26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SignupAndLogin {
	public static void main(String[] args) {

		// Initialize the WebDriver
		WebDriver driver = new ChromeDriver();

		try {
			// Step 1: Launch the website
			driver.get("https://www.guvi.in/");
			// Maximize the browser window
			driver.manage().window().maximize();
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(8000);
			driver.findElement(By.xpath("//a[contains(text(),'Sign up')]")).click();
			Thread.sleep(2000);
			// Step 4: Fill the sign up form
			WebElement nameField = driver.findElement(By.xpath("//input[@id='name']"));
			WebElement emailField = driver.findElement(By.xpath("//input[@id='email']"));
			WebElement passwordField = driver.findElement(By.xpath("//input[@id='password']"));
			WebElement mobileNo = driver.findElement(By.xpath("//input[@id='mobileNumber']"));

			nameField.sendKeys("Aswinee");
			emailField.sendKeys("aswinee789@gmail.com");
			passwordField.sendKeys("Test12344");
			mobileNo.sendKeys("9345678908");

			// Step 5: Click the signup button
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(), 'Sign Up')]")).click();

			Thread.sleep(2000);
			Select objSelect = new Select(driver.findElement(By.id("profileDrpDwn")));
			objSelect.selectByVisibleText("Student");

			Thread.sleep(2000);
			Select degree = new Select(driver.findElement(By.id("degreeDrpDwn")));
			degree.selectByVisibleText("B.E. / B.Tech. Computer Science");

			Thread.sleep(2000);
			driver.findElement(By.id("year")).sendKeys("2017");

			// Wait for the page to load
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();

			Thread.sleep(5000);
			String txt = driver.findElement(By.xpath("//h1[contains(text(),'Almost Done! Check Your Inbox!')]"))
					.getText();
			// Verify registration
			if (txt.equals("Almost Done! Check Your Inbox!")) {
				System.out.println("Registration successful.");
			} else {
				System.out.println("Registration failed.");
			}

			Thread.sleep(5000);
			driver.get("https://www.guvi.in/");
			Thread.sleep(2000);
			driver.navigate().refresh();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id='login-btn']")).click();
			Thread.sleep(3000);

			driver.findElement(By.xpath("//input[@id='email']")).sendKeys("aswinee789@gmail.com");
			driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Test12344");

			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[@id='login-btn']")).click();

			Thread.sleep(5000);
			String txts = driver.findElement(By.xpath("(//div[@class='modal-body']//p[contains(text(),'Please Consider Activating Your Guvi Account.')])[1]")).getText();
			// Verify registration (adjust based on actual message)
			if (txts.equals("Please Consider Activating Your Guvi Account.")) {
				System.out.println("login successful.");
			} else {
				System.out.println("login failed.");
			}
			// Continue with login process as needed...

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// Step 8: Close the browser
			driver.quit();
		}
	}
}
