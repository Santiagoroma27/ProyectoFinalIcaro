package stepDefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;




import io.cucumber.java.es.Y;
import opencart.pages.HomePage;
import opencart.pages.LoginPage;
import opencart.pages.MyAccountPage;

        import org.openqa.selenium.WebDriver;
import org.testng.Assert;
public class LoginDefinitions {

    private WebDriver driver;


    public LoginDefinitions(WebDriver driver) {
        this.driver = driver;
    }


    @Cuando("el usuario ingresa credenciales validas")
    public void elUsuarioIngresaCredencialesValidas() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("pepe@pepe.com.ar","12345678");
    }

    @Entonces("se valida que el usuario se encuentra en su cuenta")
    public void seValidaQueElUsuarioSeEncuentraEnSuCuenta() {
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        Assert.assertEquals(myAccountPage.obtenerTitulo(), "My Account");
    }

    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}