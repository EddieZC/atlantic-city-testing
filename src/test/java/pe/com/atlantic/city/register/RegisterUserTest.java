package pe.com.atlantic.city.register;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import pe.com.atlantic.city.page.object.model.LoginPage;
import pe.com.atlantic.city.page.object.model.RegisterPage;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RegisterUserTest {

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
    void registerOK() {
        // Captura pantalla en la página de inicio
        loginPage.captureScreenshot("1-Home");
        // Aceptar Cookie
        loginPage.clickBtnCookies();
        // Navegar a la página de registro
        RegisterPage registerPage = loginPage.clickBtnRegistrar();

        // Verificar título de la página de registro
        registerPage.captureScreenshot("2-Register");
        String pageTitle = registerPage.getPersonalData();
        assertEquals("Datos personales", pageTitle);
        System.out.println("Mensaje: " + pageTitle);

        //AR = Argentina  PE = Peru
        //PASAPORTE
        registerPage.fillRegistrationForm("Dayann", "Torres", "Parrillo", "ATF456789012",
                "AR", "PASAPORTE", "10", "1", "1995", "977579766", "day@gmail.com");

        registerPage.captureScreenshot("3-Formulario");
        registerPage.clickBtnNext();
        registerPage.getAboutYou();
        registerPage.captureScreenshot("4-Siguiente");
    }

}
