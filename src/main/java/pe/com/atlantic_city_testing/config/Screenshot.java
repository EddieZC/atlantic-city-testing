package pe.com.atlantic_city_testing.config;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshot {

        // Método para capturar y guardar la pantalla
        public static void captureScreenshot(WebDriver driver, String testName) {

            // Obtener la fecha y hora actual para agregarla al nombre del archivo
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
            String fileName = "evidencia_" + testName + "_" + timestamp + ".png";

            // Obtener el directorio raíz del proyecto
            String projectDir = System.getProperty("user.dir"); // Directorio raíz del proyecto
            // Puedes cambiar 'screenshots' por cualquier nombre que prefieras para la carpeta
            String screenshotDir = projectDir + File.separator + "screenshots";

            // Asegurarse de que la carpeta 'screenshots' exista
            File screenshotFolder = new File(screenshotDir);
            if (!screenshotFolder.exists()) {
                screenshotFolder.mkdirs(); // Si no existe, la crea
            }

            // Captura de pantalla
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            // Guardar la captura de pantalla
            File destinationFile = new File(screenshotDir + File.separator + fileName);

            try {
                // Copiar la captura a la carpeta 'screenshots'
                FileUtils.copyFile(screenshot, destinationFile);
                System.out.println("Captura de pantalla guardada en: " + destinationFile.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Error al guardar la captura de pantalla: " + e.getMessage());
            }
        }

}
