// BuyTest.java

package opencart;

import hooks.Hooks;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import opencart.pages.BuyPage;
import opencart.pages.LoginPage;
import org.apache.commons.exec.CommandLine;

import java.io.IOException;

public class BuyTest {

    private BuyPage buyPage;

    @Given("The user opens the page {string}")
    public void theUserOpensThePage(String url) throws IOException {
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
