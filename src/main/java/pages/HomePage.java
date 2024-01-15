package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	By entrataLogo = By.xpath("//a[@title='Entrata Home Page']//*[name()='svg']");
	By watchDemoLink = By.xpath("//a[@class='button-default solid-dark-button'][normalize-space()='Watch Demo']");
	By signInLink = By.xpath("//a[@class='button-default outline-dark-button']");
	By signInMsg = By.xpath("//h1[normalize-space()='Entrata powers residents and property managers']");
	By fName = By.xpath("//input[@id='FirstName']");
	By lName = By.xpath("//input[@id='LastName']");
	By email = By.xpath("//input[@id='Email']");
	By companyName = By.xpath("//input[@id='Company']");
	By phoneNo = By.xpath("//input[@id='Phone']");
	By unitCount = By.xpath("//select[@id='Unit_Count__c']");
	By jobTitle = By.xpath("//input[@id='Title']");
	By submitBtn = By.xpath("//button[@type='submit']");
	By offering = By.xpath("//h2[normalize-space()='Do it all with Entrata']");
	By productManagement = By.xpath("//h3[normalize-space()='Property Management']");
	By Marketing = By.xpath("//h3[normalize-space()='Marketing & Leasing']");
	By Accounting = By.xpath("//h3[normalize-space()='Accounting']");
	By Utilities = By.xpath("//h3[normalize-space()='Utilities']");
	
	WebDriver driver;
	WebDriverWait wait;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, 5);
	}

	public String getTitle() {
		return driver.getTitle();
	}

	public boolean getLogo() {
		return driver.findElement(entrataLogo).isDisplayed();
	}

	public void clickWatchDemo() {
		driver.findElement(watchDemoLink).click();
	}

	public void clickSignIn() {
		driver.findElement(signInLink).click();
	}

	public String getSignInNavigationMessage() {
		return driver.findElement(signInMsg).getText();
	}
	
	public void backNavigation() {
		driver.navigate().back();
	}

	public boolean verifyForm(String firstname, String lastName, String emailID, String company, String phone,
			String units, String job) {
		driver.findElement(fName).sendKeys(firstname);
		driver.findElement(lName).sendKeys(lastName);
		driver.findElement(email).sendKeys(emailID);
		driver.findElement(companyName).sendKeys(company);
		driver.findElement(phoneNo).sendKeys(phone);
		driver.findElement(unitCount).sendKeys(units);
		driver.findElement(jobTitle).sendKeys(job);
		return driver.findElement(submitBtn).isEnabled();
	}

	public void navigateToOffering() throws InterruptedException {
		Thread.sleep(500); 
		WebElement element = driver.findElement(offering);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 		
	}

	public Boolean verifyOfferings() {
		Boolean isVerified = false;
		
		isVerified = driver.findElement(productManagement).isDisplayed();
		isVerified = driver.findElement(Marketing).isDisplayed();
		isVerified = driver.findElement(Accounting).isDisplayed();
		isVerified = driver.findElement(Utilities).isDisplayed();
		
		return isVerified;
	}
}