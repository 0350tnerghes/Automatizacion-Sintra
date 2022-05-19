package com.hiberus.sintra.tamara.pages;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

import com.hiberus.sintra.tamara.utils.MyFluentWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.google.common.util.concurrent.Futures.withTimeout;

@Slf4j
public abstract class BasePage {

    public static final String PATH_CONFIGURACION = "C:\\Users\\iamarin\\AppData\\Local\\Google\\Chrome\\User Data\\Default\\";

    public static final String Home_Page = "https://citaprevia.demohiberus.com/";
    public static final String MakeAnAppointmentPage  = "https://citaprevia.demohiberus.com/appointment";
    public static final String AppointmentListPage = "https://citaprevia.demohiberus.com/appointment/list";
    protected Wait<WebDriver> wait;
    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new MyFluentWait<>(driver)
        .withTimeout(60, ChronoUnit.SECONDS)
        .pollingEvery(2, ChronoUnit.SECONDS)
        .ignoring(NoSuchElementException.class);
    }

    public Wait<WebDriver> getWait() {
        return wait;
    }

    public void setWait(Wait<WebDriver> wait) {
        this.wait = wait;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static WebDriver initDriver(String url) {
        // --------- CONFIGURACIÓN DEL DRIVER --------- \\
        String userProfile = PATH_CONFIGURACION;

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("user-data-dir=" + userProfile);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.MILLISECONDS);
        driver.manage().window().maximize();

        driver.get(url);

        return driver;
    }

    public static WebDriverWait initWait(WebDriver driver) {

        return new WebDriverWait(driver, 1, 500);
    }
   
}