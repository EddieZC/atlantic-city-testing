package pe.com.atlantic.city.page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Base {

    @FindBy(css = "button.clmc-btn-primary:nth-child(3)")
    private WebElement btnDepositar;

    @FindBy(css = ".\\!tw-text-\\[25px\\]")
    private WebElement labelDepositar;

    public HomePage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("styles_opcionMenu_image__DMqWD")));
    }

    public void clickBtnDepositar() {
        wait.until(ExpectedConditions.elementToBeClickable(btnDepositar)).click();
    }

    public String getLabelDepositar() {
        return wait.until(ExpectedConditions.elementToBeClickable(labelDepositar)).getText();
    }
}
