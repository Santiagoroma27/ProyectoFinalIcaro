package stepDefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;



import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Y;
import opencart.pages.LoginPage;
import opencart.pages.MyAccountPage;
import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginDefinitions {

    private WebDriver driver;


    @Y("el usuario ingresa al login")
    public void elUsuarioIngresaAlLogin() {
        homePage.ingresarAlLogin();
        loginPage.llenarEmail("pepe@pepe.com.ar");
        loginPage.llenarPassword("12345678");
        loginPage.loguearse();
    }
    
    @Cuando("el usuario ingresa credenciales validas")
    public void elUsuarioIngresaCredencialesValidas() {
        LoginPage loginPage;
        loginPage.llenarEmail("pepe@pepe.com.ar");
        loginPage.llenarPassword("12345678");
        loginPage.loguearse();

    }

    @Entonces("se valida que el usuario se encuentra en su cuenta")
    public void seValidaQueElUsuarioSeEncuentraEnSuCuenta() {
        MyAccountPage myAccountPage;
        Assert.assertEquals(myAccountPage.obtenerTitulo(), "My Account");
    }

    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}