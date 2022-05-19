package com.hiberus.sintra.tamara.pages;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.junit.Assert.fail;

public class MakeAnAppointmentPage extends BasePage {

    @FindBy (xpath = "//span[contains(text(), 'Cita previa')]//parent::button")
    private WebElement BOTON_CITA_PREVIA;

    @FindBy (xpath = "//span[contains(text(), 'ES')]//parent::button")
    private WebElement BOTON_CAMBIAR_IDIOMA;

    @FindBy (xpath = "mat-expansion-panel-header-0")
    private WebElement ID_MENU_LOCALIZACION;

    @FindBy (xpath = "//mat-radio-group[@name='location']//div[@class='mat-radio-label-content']//div")
    private WebElement TEXT_RADIO_BUTTONS_LOCALIZACION;

    @FindBy (xpath = "//mat-radio-group[@name='department']//div[@class='mat-radio-label-content']//div[1]")
    private WebElement TEXT_RADIO_BUTTONS_OFICINAS;

    @FindBy (xpath = "//mat-radio-group[@name='job']//div[@class='mat-radio-label-content']//div//div//div[1]")
    private WebElement TEXT_RADIO_BUTTONS_SERVICIOS;

    @FindBy (xpath = "//mat-panel-description")
    private WebElement XPATH_DESCRIPTION;

    @FindBy (xpath = "mat-expansion-panel-header-1")
    private WebElement ID_MENU_OFICINAS;

    @FindBy (xpath = "mat-expansion-panel-header-2")
    private WebElement ID_MENU_SERVICIOS;

    @FindBy (xpath = "mat-expansion-panel-header-3")
    private WebElement ID_MENU_FECHA;

    @FindBy (xpath = "//span[contains(text(), ':')]")
    private WebElement XPATH_HORAS;

    @FindBy (xpath = "//mwl-calendar-month-cell[contains(@class, 'cal-day-selected')]")
    private WebElement XPATH_DIA_SELECCIONADO;

    @FindBy (xpath = "//mwl-calendar-month-cell")
    private WebElement XPATH_CELDAS_CALENDARIO;

    @FindBy (xpath = "//div[@role='columnheader']")
    private WebElement XPATH_DIV_DIAS_SEMANA;

    @FindBy (xpath = "//input[@name='dniInput']")
    private WebElement XPATH_INPUT_DNI;

    public static final String STRING_DIAS_SEMANA = "Lun.Mar.Mié.Jue.Vie.";

    @FindBy (xpath = "//mat-expansion-panel-header")
    private WebElement XPATH_TODOS_LOS_MENUS;


    public MakeAnAppointmentPage(WebDriver driver) { //Constructor
        super(driver);
        PageFactory.initElements(driver, this);
    }

    //Metodo que valida que el menu esta desplegable
    public static boolean estaMenuDesplegado(WebDriver driver, String idMenu) {
        boolean estaDesplegada = false;
        try  {
            WebElement menuLocalizacion = driver.findElement(By.id(idMenu));
            estaDesplegada = Boolean.parseBoolean(menuLocalizacion.getAttribute("aria-expanded"));
        } catch (NoSuchElementException nsee) {
            fail("No se ha encontrado el elemento:\n" + nsee.getMessage());
        } catch (Exception e) {

        }
        return estaDesplegada;
    }

    //Metodo que valida que se puede seleccionar un servicio
    public boolean seleccionarServicio(WebDriver driver, WebDriverWait wait, boolean seleccionado){
        WebElement menuLocalizaciones = driver.findElement(By.id(String.valueOf(ID_MENU_LOCALIZACION)));
        WebElement menuOficinas = driver.findElement(By.id(ID_MENU_OFICINAS));

        List<WebElement> radioButtonsLocalizacion = null;
        try {
            radioButtonsLocalizacion = wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath(Home_Page), 0));
        } catch (Exception e) {
            fail("PRUEBA FALLIDA: No cargan las localizaciones / No hay localizaciones");
        }
        return seleccionado;
    }


}
