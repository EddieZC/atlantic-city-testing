package pe.com.atlantic.city.page.object.model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Base{

    //boton depositar


    public HomePage(WebDriver driver) {
        super(driver);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".RegisterPromotionalPanel_text_container__SlYyL > h1:nth-child(1)")));
    }
}
