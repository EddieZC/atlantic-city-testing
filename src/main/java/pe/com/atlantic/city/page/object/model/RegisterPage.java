package pe.com.atlantic.city.page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends Base {

    @FindBy(css = "div.tw-hidden:nth-child(2) > p:nth-child(1)")
    private WebElement labelPersonalData;

    @FindBy(css = "p.tw-font-bold")
    private WebElement labelAboutYou;

    @FindBy(id = "firstname")
    private WebElement firstnameInput;

    @FindBy(id = "paternalLastname")
    private WebElement paternalLastnameInput;

    @FindBy(id = "maternalLastname")
    private WebElement maternalLastnameInput;

    @FindBy(id = "mui-component-select-nationality")
    private WebElement nationalitySelect;

    @FindBy(id = "mui-component-select-national_id_type")
    private WebElement nationalIdTypeSelect;

    @FindBy(id = "national_id")
    private WebElement nationalIdInput;

    @FindBy(xpath = "//div[@aria-labelledby='select-label-Día']")
    private WebElement dateOfBirthSelect;

    @FindBy(xpath = "//div[@aria-labelledby='select-label-Mes']")
    private WebElement monthOfBirthSelect;

    @FindBy(xpath = "//div[@aria-labelledby='select-label-Año']")
    private WebElement yearOfBirthSelect;

    @FindBy(css = "input[type='tel']")
    private WebElement phoneInput;

    @FindBy(id = "email")
    private WebElement emailInput;

    @FindBy(css = ".clmc-btn-primary")
    private WebElement btnNext;

    public RegisterPage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".RegisterPromotionalPanel_text_container__SlYyL > h1:nth-child(1)")));
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//div[contains(@style, 'background-image: url(\"https://www.casinoatlanticcity.com/cms/img/banners/247/francos_desktop.jpg\")')]")
        ));
    }

    public String getPersonalData() {
        return labelPersonalData.getText();
    }

    public void enterFirstname(String firstname) {
        firstnameInput.clear();
        firstnameInput.sendKeys(firstname);
    }

    public void enterPaternalLastName(String paternalLastname) {
        paternalLastnameInput.clear();
        paternalLastnameInput.sendKeys(paternalLastname);
    }

    public void enterMaternalLastName(String maternalLastname) {
        maternalLastnameInput.clear();
        maternalLastnameInput.sendKeys(maternalLastname);
    }

    public void enterNationalId(String nationalId) {
        nationalIdInput.clear();
        nationalIdInput.sendKeys(nationalId);
    }

    public void enterNationality(String nationality) {
        nationalitySelect.click();
        driver.findElement(By.cssSelector("li[data-value='"+nationality+"']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("li.MuiButtonBase-root:nth-child(1)")));
    }

    public void enterDocumentType(String documentType) {
        nationalIdTypeSelect.click();
        driver.findElement(By.cssSelector("li[data-value='"+documentType+"']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("li.MuiButtonBase-root:nth-child(1)")));
    }

    public void enterDay(String day) {
        dateOfBirthSelect.click();
        driver.findElement(By.cssSelector("li[data-value='"+day+"']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("li.MuiButtonBase-root:nth-child(1)")));
    }

    public void enterMonth(String month) {
        monthOfBirthSelect.click();
        driver.findElement(By.cssSelector("li[data-value='"+month+"']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("li.MuiButtonBase-root:nth-child(1)")));
    }

    public void enterYear(String year) {
        yearOfBirthSelect.click();
        driver.findElement(By.cssSelector("li[data-value='"+year+"']")).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("li.MuiButtonBase-root:nth-child(1)")));
    }

    public void enterPhone(String phone) {
        phoneInput.clear();
        phoneInput.sendKeys(phone);
    }

    public void enterEmail(String email) {
        emailInput.clear();
        emailInput.sendKeys(email);
    }

    public void clickBtnNext() {
        wait.until(ExpectedConditions.elementToBeClickable(btnNext)).click();
    }

    public String getAboutYou() {
        return wait.until(ExpectedConditions.elementToBeClickable(labelAboutYou)).getText();
    }

    public void fillRegistrationForm(String firstname, String paternal, String maternal,
                                     String nationalId, String national, String documentType,
                                     String day, String month, String year, String phone, String email) {
        enterFirstname(firstname);
        enterPaternalLastName(paternal);
        enterMaternalLastName(maternal);
        enterNationality(national);
        enterDocumentType(documentType);
        enterNationalId(nationalId);
        enterDay(day);
        enterMonth(month);
        enterYear(year);
        enterPhone(phone);
        enterEmail(email);
    }
}
