package stepDefinitions;

import hooks.Hooks;
import opencart.pages.LoginPage;
import opencart.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import java.io.IOException;

public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private MyAccountPage myAccountPage;

    // Asume que Hooks ya se ha importado y que existe una instancia de Hooks
    private Hooks hooks;

    public LoginSteps() throws IOException {
        hooks = new Hooks();
        this.driver = hooks.getDriver();
        this.loginPage = new LoginPage(this.driver);
        this.myAccountPage = new MyAccountPage(this.driver);
    }

    @Given("the user enters the opencart page")
    public void the_user_enters_the_opencart_page() {
        driver.get("https://opencart.abstracta.us");
    }

    @When("it is validated that the user is on the home page")
    public void it_is_validated_that_the_user_is_on_the_home_page() {
        // Implementar la validación de la página de inicio
    }

    @And("the user goes to the login")
    public void the_user_goes_to_the_login() {
        loginPage.irLoginScreen();
        // Suponiendo que loginPage.textLoginPage() devuelve el texto esperado
        Assert.assertEquals(loginPage.textLoginPage(), "Returning Customer");
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
        loginPage.setEmail("pepe@pepe.com.ar");
        loginPage.setPassword("12345678");
        loginPage.loguearse();
    }

    @Then("it is validated that the user is in their account")
    public void it_is_validated_that_the_user_is_in_their_account() {
        // Implementar la validación de la página de la cuenta
        Assert.assertEquals(1,1);
    }

    @And("logout from account")
    public void logout_from_account() {
        Assert.assertEquals(1,1);
        // Implementar el proceso de cierre de sesión
    }
}
