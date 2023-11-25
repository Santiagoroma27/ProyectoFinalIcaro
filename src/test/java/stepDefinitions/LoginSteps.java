package stepDefinitions;

import opencart.pages.LoginPage;
import opencart.pages.MyAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;

import java.io.IOException;

import static hooks.Hooks.getDriver;

public class LoginSteps {

    private WebDriver driver;
    private HomeDefinitions homeDefinitions;
    private LoginPage loginPage;
    MyAccountPage myAccountPage;

    public LoginSteps() throws IOException {
        homeDefinitions = new HomeDefinitions();
        this.driver = getDriver();
        this.loginPage = new LoginPage(this.driver);
    }

    @Given("the user enters the opencart page")
    public void the_user_enters_the_opencart_page() throws IOException {
        this.homeDefinitions.queElUsuarioIngresaALaPaginaDeOpencart();
    }

    @When("it is validated that the user is on the home page")
    public void it_is_validated_that_the_user_is_on_the_home_page() {
        Assert.assertEquals(myAccountPage.getTitulo()," My Account");
        this.homeDefinitions.seValidaQueElUsuarioSeEncuentraEnLaHome();
    }

    @And("the user goes to the login")
    public void the_user_goes_to_the_login() {
        loginPage.irLoginScreen();
        Assert.assertEquals(loginPage.textLoginPage(), "Returning Customer");
    }

    @When("the user enters valid credentials")
    public void the_user_enters_valid_credentials() {
               loginPage.setEmail("pepe@pepe.com.ar");
                loginPage.setPassword("12345678");
    }

    @Then("it is validated that the user is in their account")
    public void it_is_validated_that_the_user_is_in_their_account() {
        String pageTitle = driver.getTitle();
        Assert.assertEquals(pageTitle, "Your Store");
        }
    @And("logout from account")
    public void logout_from_account() throws IOException {
        WebElement userIcon = getDriver().findElement(By.cssSelector("#top-links > ul > li.dropdown > a > i"));
        userIcon.click();
        WebElement logoutButton = getDriver().findElement(By.cssSelector("#top-links > ul > li.dropdown.open > ul > li:nth-child(5) > a"));
        logoutButton.click();
    }
}
