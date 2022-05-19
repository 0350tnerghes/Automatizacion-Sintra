package com.hiberus.sintra.tamara.pages;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AppointmentListPage extends BasePage{
    //public static final String PAGE_URL = "https://citaprevia.demohiberus.com/appointment/list";
    public AppointmentListPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}
