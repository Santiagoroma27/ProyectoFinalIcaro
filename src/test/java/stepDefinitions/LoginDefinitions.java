package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import opencart.pages.LoginPage;
import opencart.pages.MyAccountPage;

        import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.io.IOException;

public class LoginDefinitions {

    private final WebDriver driver;


    public LoginDefinitions(WebDriver driver) {
        this.driver = driver;
    }


//    @Cuando("el usuario ingresa credenciales validas")
//    public void elUsuarioIngresaCredencialesValidas() throws IOException {
//        Hooks.getDriver().get();
//    }
//
//    @Entonces("se valida que el usuario se encuentra en su cuenta")
//    public void seValidaQueElUsuarioSeEncuentraEnSuCuenta() {
//        MyAccountPage myAccountPage = new MyAccountPage(driver);
//        Assert.assertEquals(myAccountPage.obtenerTitulo(), "My Account");
//    }

//    public void afterScenario() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}