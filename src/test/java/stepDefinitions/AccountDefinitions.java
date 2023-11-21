package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import opencart.pages.LoginPage;
import opencart.pages.MyAccountPage;

import org.testng.Assert;

import java.io.IOException;

public class AccountDefinitions {

    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    public AccountDefinitions() throws IOException {
        this.loginPage = new LoginPage(Hooks.getDriver());
        this.myAccountPage = new MyAccountPage(Hooks.getDriver());
    }

    @Cuando("el usuario ingresa credenciales válidos")
    public void elUsuarioIngresaCredencialesVálidos() {
        loginPage.login("email@example.com", "contraseña");
    }

    @Entonces("se valida la información en la página de cuenta")
    public void seValidaLaInformaciónEnLaPáginaDeCuenta() {
        // Agrega las validaciones necesarias para la información en la página de cuenta
        // Puedes usar métodos de MyAccountPage o WebDriver directamente según tu implementación
        // Ejemplo: Assert.assertTrue(myAccountPage.informacionEsCorrecta());
    }

    @Dado("Que el usuario ingresa a la página de opencart")
    public void queElUsuarioIngresaALaPaginaDeOpencart(){
        
    }
}
