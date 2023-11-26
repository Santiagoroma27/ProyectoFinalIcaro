package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Hooks {

    private static WebDriver driver;
    private static Properties properties;

    public static WebDriver getDriver() throws IOException {
        if (driver == null) {
            setup();
        }
        return driver;
    }

    @Before
    public static void setup() throws IOException {


        properties = new Properties();
        properties.load(new FileInputStream(
                System.getProperty("user.dir") +
                "/src/test/resources/config.properties"));
        initializeDriver();
//        System.setProperty("webdriver.chrome.driver",
//                System.getProperty("user.dir") + "\\drivers\\chromedriver.exe");


    }

    public static String getConfigValue(String key) {
        return properties.getProperty(key);
    }

    private static void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }

    public static void quitDriver() {
        driver.quit();
    }

    public static Properties getProperties() {
        return properties;
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
           }
    }
}
