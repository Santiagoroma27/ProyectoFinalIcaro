package opencart;

import hooks.Hooks;
import opencart.pages.BuyPage;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class BuyTest {

    private BuyPage buyPage;
    private WebDriver driver;

    public BuyTest() {
        Hooks hooks = new Hooks();
        this.driver = hooks.getDriver();
        this.buyPage = new BuyPage(driver);
    }

    @Given("The user opens the page {string}")
    public void theUserOpensThePage(String url) {
        driver.get(url);
    }

    @When("The user clicks on Cameras")
    public void theUserClicksOnCameras() {
        buyPage.goToCameras();
    }

    @When("The user clicks on Canon EOS 5D")
    public void theUserClicksOnCanonEOS5D() {
        buyPage.selectCanonEOS5D();
    }

    @When("The user selects an option {string} and adds the product to the cart")
    public void theUserSelectsAnOptionAndAddsTheProductToTheCart(String productOption) {
        buyPage.selectedOption(productOption);
        buyPage.addToCart();
    }

    @When("The user clicks on the cart")
    public void theUserClicksOnTheCart() {
        buyPage.goToCart();
    }

    @When("The user clicks on View Cart")
    public void theUserClicksOnViewCart() {
        buyPage.viewCart();
    }

}
