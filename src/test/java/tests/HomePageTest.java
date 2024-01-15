package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import pages.BasePage;
import pages.HomePage;
import util.ExtentTestManager;

public class HomePageTest extends BasePage {

	/**
	 * Test to verify title
	 */
	@Test(priority = 0)
	public void verifyTitle() {
		HomePage homePage = new HomePage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Checking title matches string");
		Assert.assertEquals(homePage.getTitle(), "Property Management Software | Entrata - Test",
				"Title does not match");
		ExtentTestManager.getTest().log(Status.PASS, "Title matches with title from DOM");
	}

	/**
	 * Test to verify logo
	 */
	@Test(priority = 1)
	public void verifyLogo() {
		HomePage homePage = new HomePage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Checking if logo is present");
		Assert.assertTrue(homePage.getLogo());
		ExtentTestManager.getTest().log(Status.PASS, "Logo is present");
	}

	/**
	 * Test to verify watch Demo Link
	 */
	@Test(priority = 2)
	public void verifyWatchDemoLink() {
		HomePage homePage = new HomePage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Checking if Watch Demo Link is clickable and verify title");
		homePage.clickWatchDemo();
		Assert.assertEquals(homePage.getTitle(), "Property Management Software | Entrata", "Title does not match");
		ExtentTestManager.getTest().log(Status.PASS, "Watch Demo Link is clickable");
	}

	/**
	 * Test to verify watch Demo Form
	 */
	@Test(priority = 3)
	public void verifyWatchDemoForm() {
		Boolean status = false;
		HomePage homePage = new HomePage(driver);
		ExtentTestManager.getTest().log(Status.INFO, "Verifying Watch Demo form");
		status = homePage.verifyForm("Shubham", "Kokare", "test@test.com", "Test Company", "1234567890", "12",
				"QA Automation");
		Assert.assertTrue(status == true, "Form is filled and Watch Demo button is clickable");
		ExtentTestManager.getTest().log(Status.PASS, "Watch Demo form is validated");
	}

	/**
	 * Test to verify Sign-In button
	 */
	@Test(priority = 4)
	public void verifySignInLink() {
		HomePage homePage = new HomePage(driver);
		homePage.backNavigation();
		ExtentTestManager.getTest().log(Status.INFO, "Checking if Sign-In Link is clickable and verify title");
		homePage.clickSignIn();
		Assert.assertEquals(homePage.getSignInNavigationMessage(), "Entrata powers residents and property managers",
				"Title does not match");
		ExtentTestManager.getTest().log(Status.PASS, "Sign-In is clickable & Message verification is completed");
	}

	/**
	 * Test to verify Offerings
	 * 
	 * @throws InterruptedException
	 */
	@Test(priority = 5)
	public void verifyOfferings() throws InterruptedException {
		Boolean isOfferingPresent = false;
		HomePage homePage = new HomePage(driver);
		homePage.backNavigation();
		ExtentTestManager.getTest().log(Status.INFO, "Verify Offerings");
		homePage.navigateToOffering();
		isOfferingPresent = homePage.verifyOfferings();
		Assert.assertTrue(isOfferingPresent == true, "Offering verified");
		ExtentTestManager.getTest().log(Status.PASS, "Offering verified");
	}
}
