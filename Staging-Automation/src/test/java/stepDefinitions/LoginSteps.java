package stepDefinitions;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.StepDefinitionAnnotation;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import utils.ConfigReader;
import org.testng.Assert;
import utils.DriverManagerUtil;
import utils.ScreenshotUtil;
public class LoginSteps {

    private WebDriver driver;
    private LoginPage loginPage;
    private ConfigReader configReader;

    public LoginSteps() {
        this.driver = DriverManagerUtil.getDriver();
        this.loginPage = new LoginPage(driver);
        this.configReader = new ConfigReader(); // Cargar las configuraciones del archivo properties
    }

    @AfterStep
    public void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            ScreenshotUtil.takeScreenshot(driver, scenario.getName());
        }
    }

    @Given("User is on Login page")
    public void usuario_en_login() {
        driver.get(configReader.getProperty("url_login")); // Usar URL desde config.properties
    }

    @When("Enter email and password")
    public void ingresar_credenciales() {
        loginPage.enterEmailname(configReader.getProperty("emailname"));

        loginPage.clickNext();

        loginPage.enterPassword(configReader.getProperty("password"));

        loginPage.clickLogin();

        loginPage.clickYes();

    }

    @Then("Verify that the Dashboard page should be displayed")
    public void verificar_dashboard() {
        Assert.assertTrue(loginPage.isLoginSuccessfulDashboard(),"Loggin success");

    }


}
