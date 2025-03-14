package pe.com.atlantic_city_testing.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BrowsersConfig {

    @Bean
    @Qualifier("webDriverFirefox")
    public WebDriver webDriverFirefox() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");

        return new FirefoxDriver(options);
    }

}