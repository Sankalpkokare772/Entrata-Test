package pages;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;
import util.ExtentManager;

public class BasePage {

	public static WebDriver driver;
	String url = "https://www.entrata.com/";

	@BeforeClass(alwaysRun=true)
	public void setup(ITestContext context) {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true"); // This suppresses the Severe Timed out receiving messages
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
		context.setAttribute("WebDriver", driver);
		setDriver(driver);
	}

	@AfterClass(alwaysRun=true)
	public void tearDown() throws IOException {
		driver.quit();
		openReport();
	}
	
	private static void openReport() throws IOException {
		String os = System.getProperty("os.name");
		if (os.contains("Windows")) {
			File htmlFile = new File(ExtentManager.getReportFileLocation());
			Desktop.getDesktop().browse(htmlFile.toURI());
		}
	}
	
	public static WebDriver getDriver() {
		return driver;
	}

	public static void setDriver(WebDriver driver) {
		BasePage.driver = driver;
	}
}
