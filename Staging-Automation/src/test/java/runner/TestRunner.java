package runner;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.DriverManagerUtil;

//import utils.ExtentReportListener;


@CucumberOptions(
        features = "src/test/resources/features",   // Ruta del archivo .feature
        glue = {"stepDefinitions"},  // Ruta de las clases que contienen las definiciones de los pasos
        tags = "@smoke and @regression",
        plugin = {
                "pretty",                             // Para salida legible en la consola
                "html:target/cucumber-reports/cucumber-reports.html", // Reporte HTML básico
                "json:target/cucumber-reports/cucumber-reports.json"  // Reporte JSON para herramientas externas
        },
        monochrome = true                         // Hace que la salida sea más legible en la consola

)
public class TestRunner extends AbstractTestNGCucumberTests {

    @Test
    public void runTests() {
        // Este método ejecutará los tests de Cucumber bajo TestNG
    }

    @AfterSuite
    public void afterSuite() {
        // Llamamos a closeDriver() para cerrar el WebDriver después de todas las pruebas
        DriverManagerUtil.closeDriver();
    }



}
