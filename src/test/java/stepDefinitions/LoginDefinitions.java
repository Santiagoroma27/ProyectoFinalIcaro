package stepDefinitions;

import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Entonces;



import io.cucumber.java.es.Dado;
          import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;
        import org.openqa.selenium.chrome.ChromeDriver;

public class LoginDefinitions {

    private WebDriver driver;

//    @Dado("Que el usuario ingresa a la pagina de opencart")
//    public void queElUsuarioIngresaALaPaginaDeOpencart() {
//        // Inicializa el navegador web (debes tener ChromeDriver instalado y configurado)
//        System.setProperty("webdriver.chrome.driver", "C:\\Users\\santi\\Desktop\\ProyectoFinal Icaro\\PrimeraPruebaDeAutomationTest\\drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.get("https://opencart.abstracta.us/"); // Abre la página de Opencart
//    }


    @Cuando("el usuario ingresa credenciales validas")
    public void elUsuarioIngresaCredencialesValidas() {
        WebElement usernameField = driver.findElement(By.id("username")); // Encuentra el campo de nombre de usuario
        WebElement passwordField = driver.findElement(By.id("password")); // Encuentra el campo de contraseña
        WebElement loginButton = driver.findElement(By.id("loginButton")); // Encuentra el botón de inicio de sesión

        usernameField.sendKeys("tu_nombre_de_usuario"); // Ingresa tu nombre de usuario
        passwordField.sendKeys("tu_contraseña"); // Ingresa tu contraseña
        loginButton.click(); // Haz clic en el botón de inicio de sesión
    }

    @Entonces("se valida que el usuario se encuentra en su cuenta")
    public void seValidaQueElUsuarioSeEncuentraEnSuCuenta() {
        WebElement text = driver.findElement(By.cssSelector("#logo > h1 > a"));
    }

    public void afterScenario() {
        if (driver != null) {
            driver.quit();
        }
    }
}