package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By emailname = By.name("loginfmt");
    private final By passwordField = By.name("passwd");

    private final By nextButton = By.xpath("//input[@value='Next']");
    private final By loginButton = By.xpath("//input[@value='Sign in']");
    private final By yesButton = By.xpath("//input[@value='No']");

    private final By titlename = By.id("SiteHeaderTitle");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterEmailname(String username) {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(emailname));
        emailElement.sendKeys(username);
    }

    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.sendKeys(password);
    }

    public void clickLogin() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        loginButtonElement.click();
    }

    public void clickNext() {
        WebElement nextButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(nextButton));
        nextButtonElement.click();
    }

    public void clickYes() {
        WebElement yesButtonElement = wait.until(ExpectedConditions.visibilityOfElementLocated(yesButton));
        yesButtonElement.click();
    }

    public boolean isLoginSuccessful() {
        WebElement emailElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        return driver.getTitle().contains("Staging Env");
    }

    public boolean isLoginSuccessfulDashboard() {
        WebElement titleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(titlename));
        return  titleElement.isDisplayed();
    }
}
