package opencart;

import hooks.Hooks;
import opencart.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomeTest {

    private WebDriver driver;
    private HomePage homePage;

    public HomeTest() {
        Hooks hooks = new Hooks();
        this.driver = hooks.getDriver();
        this.homePage = new HomePage(driver);
    }

    @Test
    public void validarHome() {
        driver.get("https://opencart.abstracta.us");

        Assert.assertEquals(homePage.getTitulo(), "Your Store");
        Assert.assertTrue(homePage.buscadorEsVisible());
        Assert.assertTrue(homePage.carrouselEsVisible());
    }
}
