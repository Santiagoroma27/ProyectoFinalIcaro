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

    private WebDriver driver;
    private static Properties properties;

    static {
        properties = new Properties();
        try {
            properties.load(new FileInputStream(
                    System.getProperty("user.dir") +
                            "/src/test/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public WebDriver getDriver() {
        if (driver == null) {
            setup();
        }
        return driver;
    }

    @Before
    public void setup() {
        initializeDriver();
    }

    private void initializeDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static String getConfigValue(String key) {
        return properties.getProperty(key);
    }
}
