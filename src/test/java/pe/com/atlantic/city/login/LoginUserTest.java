package pe.com.atlantic.city.login;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import pe.com.atlantic.city.page.object.model.HomePage;
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
        // Navegar a la página de login
        loginPage.clickBtnModalLogin();
        loginPage.captureScreenshot("2-Login");

        //iniciar sesion
        loginPage.fillLoginForm("alias3", "Contra123");
        HomePage homePage = loginPage.clickBtnLogin();
        loginPage.captureScreenshot("3-IngesoLogin");

        //Click en depositar
        homePage.clickBtnDepositar();
        String labelActual = homePage.getLabelDepositar();
        loginPage.captureScreenshot("4-Depositar");

        //Validar mensaje para el test
        System.out.println("Mensaje: " + labelActual);
        Assertions.assertEquals("Depósito", labelActual);
        //select * from Depositos d order by d.fecha_deposito desc limit 1
    }
}
