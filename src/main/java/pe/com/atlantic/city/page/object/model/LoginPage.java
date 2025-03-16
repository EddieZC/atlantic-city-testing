package pe.com.atlantic.city.page.object.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Base{

    @FindBy(className = "styles_link__flZEQ")
    private WebElement btnRegistrar;

    @FindBy(className = "cookies_acceptBtn__hkgnB")
    private WebElement btnCookies;

    @FindBy(css = ".LoginAsideHeaderButtons_themed-login-buttons__Wi6TW > button:nth-child(1)")
    private WebElement btnModalLogin;

    @FindBy(id = "user")
    private WebElement userInput;

    @FindBy(id = "password")
    private WebElement passwordInput;

    @FindBy(css = "button.styles_baseButton__3ohKA:nth-child(4)")
    private WebElement btnLogin;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void navigateToAtlanticCity() {
        navigateTo("https://www.casinoatlanticcity.com/");
        wait.until(ExpectedConditions.elementToBeClickable(btnRegistrar));
    }

    public RegisterPage clickBtnRegistrar() {
        wait.until(ExpectedConditions.elementToBeClickable(btnRegistrar)).click();
        return new RegisterPage(driver);
    }

    public void clickBtnCookies() {
        wait.until(ExpectedConditions.elementToBeClickable(btnCookies)).click();
    }

    public void clickBtnModalLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(btnModalLogin)).click();
        wait.until(ExpectedConditions.visibilityOf(userInput));
    }

    public HomePage clickBtnLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(btnLogin)).click();
        return new HomePage(driver);
    }

    public void enterUser(String user) {
        userInput.clear();
        userInput.sendKeys(user);
    }

    public void enterPassword(String password) {
        passwordInput.clear();
        passwordInput.sendKeys(password);
    }

    public void fillLoginForm(String user, String password) {
        enterUser(user);
        enterPassword(password);
    }
}


