package com.cucumberproject.steps;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;


import com.cucumberproject.config.Configuration;
import com.cucumberproject.exceptions.InvalidBrowserNameError;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TestBase {
	private static final Logger LOG = Logger.getLogger(TestBase.class);
	public static RemoteWebDriver driver;
	public Configuration config;
	
	
	public static RemoteWebDriver getDriver() {
		return driver;
		
	}
	
	//@Parameters("browser-name")
	@Before
	public void setUp() throws MalformedURLException {

		config = new Configuration();
		if (config.getExecutionMode().equalsIgnoreCase("local")) {
			LOG.info("Executing suite on local");
			if(config.getBrowserName().equalsIgnoreCase("Chrome")) {
				driver = new ChromeDriver();
			}else if(config.getBrowserName().equalsIgnoreCase("Firefox")) {
				driver = new FirefoxDriver();
			}else if(config.getBrowserName().equalsIgnoreCase("ie")) {
				driver = new InternetExplorerDriver();
			}else {
				throw new InvalidBrowserNameError(config.getBrowserName());
			}
		} else {
			LOG.info("Executing suite on grid");
			FirefoxOptions firefoxOptions = new FirefoxOptions();
			firefoxOptions.setCapability("se:name", "My simple test");
			firefoxOptions.setCapability("se:sampleMetadata", "Sample metadata value");

			driver = new RemoteWebDriver(new URL("http://192.168.1.39:4444/"), firefoxOptions);
		}
	}
	
	@After
	public void takeScreenShotOnTestFailure(Scenario scenario) throws IOException {
		
		try {
			if(scenario.isFailed()) {
				Date date = new Date();
				String screnShotFname = date.toString().replace(" ", "-").replace(":", "-");

				System.out.println(date);

				AShot ashot = new AShot();
				BufferedImage img = ashot.shootingStrategy(ShootingStrategies.viewportPasting(3000))
						.takeScreenshot(TestBase.getDriver()).getImage();
				String baseDir = System.getProperty("user.dir");
				ImageIO.write(img, "png",
						new File(baseDir + "\\src\\main\\resources\\FaildTestCaseScreenShot\\" + screnShotFname +".png"));
			
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		driver.quit();
		
	}

		
	}
	