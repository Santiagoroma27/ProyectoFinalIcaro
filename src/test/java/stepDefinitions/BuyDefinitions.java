package stepDefinitions;


import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import opencart.pages.BuyPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;

public class BuyDefinitions {

    @Y("el usuario agrega un producto al carrito")
    public void elUsuarioAgregaUnProductoAlCarrito() {
        public void theUserClicksOnCanonEOS5D() {
            BuyPage buyPage;
            buyPage.selectCanonEOS5D();
            String productOption;
            buyPage.selectedOption(productOption);
            buyPage.addToCart();
        }
    }

    @Y("el usuario entra al carrito")
    public void elUsuarioEntraAlCarrito() {
        WebElement viewCartButtonElem = wait.until(ExpectedConditions.elementToBeClickable(viewCartButton));
        viewCartButtonElem.click();
    }

    @Entonces("se valida que exista un producto en el carrito")
    public void seValidaQueExisteUnProductoEnElCarrito(){
        public Boolean selectedOption(String option){
            return Boolean.TRUE;
        }
        }
    }

}

