package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources", // o "src/test/resources/subfolder" si tus .feature están en un subdirectorio
        glue = "stepDefinitions", // Indica dónde están las definiciones de tus pasos
        plugin = {"pretty", "html:target/cucumber"}, // Configura los plugins, como formateadores de reporte
        monochrome = true // Mejora la legibilidad de la salida en la consola
)
public class CucumberRunnerTest extends AbstractTestNGCucumberTests {
}
