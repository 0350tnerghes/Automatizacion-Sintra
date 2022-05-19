package com.hiberus.sintra.tamara.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;


@Getter
public class PagesFactory {

    private final WebDriver driver;
    private static PagesFactory pagesFactories;
    private final AppointmentListPage appointmentListPage;
    private final MakeAnAppointmentPage makeAnAppointmentPage;

    public PagesFactory(WebDriver driver) {
        this.driver = driver;
        appointmentListPage = new AppointmentListPage(driver);
        makeAnAppointmentPage = new MakeAnAppointmentPage(driver);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static PagesFactory getPagesFactories() {
        return pagesFactories;
    }

    public static void setPagesFactories(PagesFactory pagesFactories) {
        PagesFactory.pagesFactories = pagesFactories;
    }
}
