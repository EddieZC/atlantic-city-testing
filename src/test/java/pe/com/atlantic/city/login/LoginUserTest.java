package pe.com.atlantic.city.login;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import pe.com.atlantic.city.page.object.model.LoginPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class LoginUserTest {

    @Autowired
    @Qualifier("webDriverFirefox")
    private WebDriver webDriver;

    private LoginPage loginPage;

    @BeforeEach
    void setUp() {
        loginPage = new LoginPage(webDriver);
        loginPage.navigateToAtlanticCity();
    }

    @Test
    void loginOK() {
        // Captura pantalla en la página de inicio
        loginPage.captureScreenshot("1-Home");
        // Aceptar Cookie
        loginPage.clickBtnCookies();
        // Navegar a la página de registro
        loginPage.clickBtnModalLogin();

        // Verificar título de la página de registro
        loginPage.captureScreenshot("2-Login");

        loginPage.fillLoginForm("asd", "123456789");
        loginPage.clickBtnLogin();
        loginPage.captureScreenshot("3-IngesoLogin");


        //select * from Depositos d order by d.fecha_deposito desc limit 1
    }
}
