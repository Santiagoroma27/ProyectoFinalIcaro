package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import opencart.pages.LoginPage;
import opencart.pages.MyAccountPage;
import org.testng.Assert;

public class LoginDefinitions {

    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    public LoginDefinitions() {
        this.loginPage = new LoginPage(Hooks.getDriver());
        this.myAccountPage = new MyAccountPage(Hooks.getDriver());
    }

    @Cuando("el usuario ingresa credenciales válidas")
    public void elUsuarioIngresaCredencialesValidas() {
        loginPage.login(Hooks.getConfigValue("username"), Hooks.getConfigValue("password"));
    }

    @Entonces("se valida que el usuario se encuentra en su cuenta")
    public void seValidaQueElUsuarioSeEncuentraEnSuCuenta() {
        Assert.assertEquals(myAccountPage.getTitulo(), "My Account");
    }
}
