// BuyTest.java

package opencart.tests;

import hooks.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import opencart.pages.BuyPage;
import opencart.pages.LoginPage;

public class BuyTest {

    private BuyPage buyPage;

    @Before
    public void setUp() {
        buyPage = new BuyPage(Hooks.getDriver());
    }

    @Given("The user opens the page {string}")
    public void theUserOpensThePage(String url) {
        Hooks.getDriver().get(url);
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
        buyPage.selectProductOption(productOption);
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

    @After
    public void tearDown() {
        Hooks.quitDriver();
    }
}
