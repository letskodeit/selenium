package pageclasses;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

public class TestSuiteBase {
	protected WebDriver driver;
	protected SearchPageFactory search;

	@Parameters({ "platform","browser","version", "url" })
    @BeforeClass(alwaysRun=true)
    public void setup(String platform, String browser, String
      version, String url) throws MalformedURLException
	{
		driver = getDriverInstance(platform, browser, version, url);
		search = PageFactory.initElements(driver, SearchPageFactory.class);
    }
	
	public static WebDriver getDriverInstance(String platform, String browser, String version, String url)
			throws MalformedURLException {
		String nodeURL = "http://ip address:5555/wd/hub";
		WebDriver driver = null;
		DesiredCapabilities caps = new DesiredCapabilities();
		
		// Platforms
		if (platform.equalsIgnoreCase("Windows")) {
			caps.setPlatform(Platform.WINDOWS);
		}
		if (platform.equalsIgnoreCase("MAC")) {
			caps.setPlatform(Platform.MAC);
		}
		// Browsers
		if (browser.equalsIgnoreCase("chrome")) {
			caps = DesiredCapabilities.chrome();
		}
		if (browser.equalsIgnoreCase("firefox")) {
			caps = DesiredCapabilities.firefox();
		}
		// Version
		caps.setVersion(version);
		driver = new RemoteWebDriver(new URL(nodeURL), caps);
		// Maximize the browser's window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// Open the Application
		driver.get(url);
		return driver;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
}