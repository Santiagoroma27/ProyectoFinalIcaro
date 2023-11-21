package opencart;

import opencart.pages.HomePage;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static hooks.Hooks.getDriver;

public class HomeTest extends BuyTest {

    @Test
    public void validarHome() throws IOException {
        HomePage homePage = new HomePage(getDriver());

        getDriver().get("https://opencart.abstracta.us");

        Assert.assertEquals(homePage.getTitulo(), "Your Store");
        Assert.assertTrue(homePage.buscadorEsVisible());
        Assert.assertTrue(homePage.carrouselEsVisible());
    }

}
