package stepDefinitions;

import hooks.Hooks;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;
import opencart.pages.AccountPage;
import opencart.pages.HomePage;
import opencart.pages.RegisterPage;
import org.testng.Assert;

public class RegisterDefinitions {

    private HomePage homePage;
    private RegisterPage registerPage;
    private AccountPage accountPage;

    public RegisterDefinitions() {
        this.homePage = new HomePage(Hooks.getDriver());
        this.registerPage = new RegisterPage(Hooks.getDriver());
        this.accountPage = new AccountPage(Hooks.getDriver());
    }

    @Cuando("el usuario completa el formulario de registro con datos válidos")
    public void elUsuarioCompletaElFormularioDeRegistroConDatosVálidos() {
        // Puedo usar Faker o datos fijos según se necesite
        registerPage.completarFormulario(
                "Nombre",
                "Apellido",
                "email@example.com",
                "123456789",
                "contraseña");
    }

    @Entonces("se valida que el usuario se encuentra en su cuenta")
    public void seValidaQueElUsuarioSeEncuentraEnSuCuenta() {
        Assert.assertEquals(accountPage.getTitulo(), "Account");
        Assert.assertTrue(accountPage.descriptionIsDisplayed());
    }
}
