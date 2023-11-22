package stepDefinitions;


import hooks.Hooks;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import opencart.pages.BuyPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.time.Instant;

public class BuyDefinitions {

    @Y("el usuario agrega un producto al carrito")
    public void elUsuarioAgregaUnProductoAlCarrito() {
        public void theUserClicksOnCanonEOS5D{
            BuyPage buyPage = null;
            buyPage.selectCanonEOS5D();
            String productOption = null;
            buyPage.selectedOption(productOption);
            buyPage.addToCart();
        }
    }

    @Y("el usuario entra al carrito")
    public void elUsuarioEntraAlCarrito() throws IOException {
        BuyPage buyPage = new BuyPage(Hooks.getDriver());
        buyPage.viewCart();

    }

    @Entonces("se valida que exista un producto en el carrito")
    public Boolean seValidaQueExisteUnProductoEnElCarrito(){
        public Boolean selectedOption(String Object option;
        Object option1 = option;){
            return Boolean.TRUE;
        }
        }
    }