package pe.com.atlantic.city.page.object.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import pe.com.atlantic.city.config.Screenshot;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Base {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public Base(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void waitImplicit(long seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));
    }

    public void captureScreenshot(String fileName) {
        Screenshot.captureScreenshot(driver, fileName);
    }

    public void navigateTo(String url) {
        driver.get(url);
        driver.manage().window().maximize();
    }
}

// 1. Primero, crea una clase base para todas las páginas