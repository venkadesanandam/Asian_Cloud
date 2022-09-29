package com.Asian_Assessment;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Baseclass {
	protected static Properties prop;

	protected static ExtentHtmlReporter htmlReporter;
	protected static ExtentReports extent;
	protected static ExtentTest test;
	protected static ExtentTest childTest;
	protected static WebDriver driver;	
	
	public static void setBrowser(String browserName) throws Exception {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
//				ChromeOptions opt = new ChromeOptions();
//				opt.addArguments("--ignore-certificate-errors");
//				opt.addArguments("chrome.switches", "--disable-extensions");
//				opt.addArguments("--disable-notifications");
//				opt.addArguments("enable-automation");
//
//				DesiredCapabilities cap = new DesiredCapabilities();
//				cap.setCapability(ChromeOptions.CAPABILITY, opt);
//				opt.merge(cap);
				
				System.setProperty("webdriver.chrome.driver", "C:\\Users\\91994\\eclipse-workspace\\Asian_Assessment\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();

			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver", ".\\Driver\\geckodriver.exe");
				driver = new FirefoxDriver();

			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver", ".\\Driver\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();

			} else {
				throw new Exception("Browser Name is invalid");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// get the data from property file to 'prop' object.
	public static void readPropertyFile() {
		try {

			FileInputStream propFile = new FileInputStream(
					".\\src\\test\\java\\com\\Asian\\properties\\config.properties");
			prop = new Properties();
			prop.load(propFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Setup extend report v4
	public static void setExtentReport() {

		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "./Report/Asian_Report.html");
		htmlReporter.config().setDocumentTitle("Asian Automation Report");
		htmlReporter.config().setReportName("Functional Testing");
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name", "localhost");
		extent.setSystemInfo("Environemnt", "QA");
		extent.setSystemInfo("user", "Arun Pragathish");
	}

	public static void getUrl() {
		try {
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("url"));
			pageLoadWait();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static boolean elementIsDisplayed(WebElement element) {
		boolean displayed = false;
		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return displayed;
	}

	public static boolean elementIsEnabled(WebElement element) {
		try {
			boolean enabled = element.isEnabled();
			return enabled;
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void waitforElementVisiblity(WebElement element) {
		try {
			WebDriverWait wb = new WebDriverWait(driver, 60);
			wb.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void inputValuestoWebelement(WebElement element, String value) {
		try {
			waitforElementVisiblity(element);
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				element.sendKeys(value);
			}
		} catch (Exception e) {

			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public static void clickonWebelement(WebElement element) {
		try {
			waitforElementVisiblity(element);
			if (elementIsDisplayed(element)) {
				element.click();
			}
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public static void selectDropDownOption(WebElement element, String option, String value) {
		try {
			waitforElementVisiblity(element);
			Select s = new Select(element);
			if (option.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			} else if (option.equalsIgnoreCase("visibletext")) {
				s.selectByVisibleText(value);
			} else if (option.equalsIgnoreCase("index")) {
				s.selectByIndex(Integer.parseInt(value));
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public void takeScreenShot(String fileName) throws IOException {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(System.getProperty("user.dir") + "\\ScreenShot\\" + fileName + ".png");
			FileUtils.copyFile(src, des);
		} catch (WebDriverException e) {

			e.printStackTrace();
		}
	}

	public static void mouseHoverToElement(WebElement element) {
		try {
			waitforElementVisiblity(element);
			Actions ac = new Actions(driver);
			ac.moveToElement(element).build().perform();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void scrollUsingElement(WebElement element, String option) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0], scrollIntoView();", element);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
	}

	public void scrollUsingCoOrdinates(String width, String height) {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(" + width + "," + height + ")");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}


	public void dragAndDrop(WebElement sourceElement, WebElement placedElement) {
		try {
			Actions ac = new Actions(driver);
			ac.dragAndDrop(sourceElement, placedElement);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void simpleAlert(WebElement element) {
		try {
			waitforElementVisiblity(element);
			Alert simpleAlert = driver.switchTo().alert();
			simpleAlert.accept();
			driver.switchTo().defaultContent();
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void confirmAlert(WebElement element, String condition) {
		try {
			waitforElementVisiblity(element);
			Alert confirmAlert = driver.switchTo().alert();
			if (condition.equalsIgnoreCase("accept")) {
				confirmAlert.accept();
				driver.switchTo().defaultContent();
			} else if (condition.equalsIgnoreCase("dismiss")) {
				confirmAlert.dismiss();
				driver.switchTo().defaultContent();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void switchToFrameUsingId(String option, int index) {

		try {
			if (option.equals("id")) {
				driver.switchTo().frame(index);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void switchToFrameUsingName(String option, String Framename) {

		try {
			if (option.equals("name")) {
				driver.switchTo().frame(Framename);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void switchToFrameUsingElement(String option, WebElement element) {

		waitforElementVisiblity(element);
		try {
			if (option.equals("element")) {
				driver.switchTo().frame(element);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void switchToDefault() {

		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String CurrentURL() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public static void pageLoadWait() {
		driver.manage().timeouts().pageLoadTimeout(Integer.parseInt(prop.getProperty("pageLoadTime")),
				TimeUnit.SECONDS);
	}

	public static void explicitWait(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public static void windowsHandling(String wId) {
		Set<String> AllId = driver.getWindowHandles();
		for (String id : AllId) {
			{
				if (!(id == wId))
					driver.switchTo().window(id); // Switch to the desired window first and then execute commands using
			}
		}
	}
}
