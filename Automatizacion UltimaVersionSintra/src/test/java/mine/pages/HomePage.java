package mine.pages;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.*;
import java.util.List;
import java.util.NoSuchElementException;

import static org.jsoup.helper.Validate.fail;

@Slf4j
public class HomePage extends BasePage {

    public static final String pageUrl = "https://citaprevia.demohiberus.com/appointment";


    @FindBy(xpath = "//span[contains(text(), 'Cita previa')]//parent::button")
    private WebElement BOTON_CITA_PREVIA;

    @FindBy(xpath = "//span[contains(text(), 'ES')]//parent::button")
    public WebElement BOTON_CAMBIAR_IDIOMA;
    @FindBy(xpath = "//span[contains(text(), 'ES')]")
    public WebElement language;

    @FindBy(xpath = "//div[@class='cdk-overlay-container']//div[@id='cdk-overlay-0']//button[contains(text(), 'English (EN)')]")
    private WebElement languageDisplay;

    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-menu-trigger c-header__container_main__menu__list__button m-min mat-button mat-button-base ng-star-inserted']//descendant::span")
    private WebElement languageSelected;

    @FindBy(xpath = "//span[contains(text(), 'Te envío un recordatorio a tu correo')]//parent::button")
    private WebElement botonRecordatorioCita;

    @FindBy(xpath = "mat-expansion-panel-header-0")
    private WebElement idMenuLocalizacion;


    @FindBy(xpath = "//mat-radio-group[@name='location']//div[@class='mat-radio-label-content']//div")
    private WebElement TEXT_RADIO_BUTTONS_LOCALIZACION;

    @FindBy(xpath = "//mat-radio-group[@name='department']//div[@class='mat-radio-label-content']//div[1]")
    private WebElement TEXT_RADIO_BUTTONS_OFICINAS;

    @FindBy(xpath = "//mat-expansion-panel[@class='mat-expansion-panel c-add-appointment__form__item ng-tns-c213-9']//descendant::mat-panel-description")
    private WebElement departmentView;

    @FindBy(xpath = "//mat-radio-group[@name='job']//div[@class='mat-radio-label-content']//div//div//div[1]")
    private WebElement TEXT_RADIO_BUTTONS_SERVICIOS;

    @FindBy(xpath = "//mat-panel-description")
    private WebElement xpathDescripcion;

    @FindBy(xpath = "mat-expansion-panel-header-1")
    private WebElement idMenuOficina;

    @FindBy(xpath = "mat-expansion-panel-header-2")
    private WebElement idMenuServicios;

    @FindBy(xpath = "mat-expansion-panel-header-3")
    private WebElement idMenuFecha;

    @FindBy(xpath = "//span[contains(text(), ':')]")
    private WebElement XpathHoras;
    @FindBy(xpath = "//span[contains(text(),'9')]")
    private WebElement dayDate;
    @FindBy(xpath = "//span[contains(text(),'15:30')]")
    private WebElement hourDate;

    @FindBy(id = "mat-input-0")
    private WebElement writeName;

    @FindBy(id = "mat-input-6")
    private WebElement dniCamp;

    @FindBy(id = "mat-input-1")
    private WebElement emailCamp;

    @FindBy(id = "mat-input-3")
    private WebElement phoneCamp;

    @FindBy(id = "mat-input-4")
    private WebElement commentsCamp;

    @FindBy(xpath = "//div[@class='mat-checkbox-inner-container']")
    private WebElement checkBox;
    @FindBy(xpath = "//button[@type='button']")
    private WebElement requestButton;

    @FindBy(xpath = "//mat-expansion-panel-header")
    private WebElement xpathTodosLosMenus;

    @FindBy(xpath = "//div[contains(text(),'Santa Cruz de Tenerife')]//ancestor::mat-radio-button")
    private WebElement locationLabel;

    @FindBy(xpath = "//div[contains(text(),'Estadio Heliodoro Ródriguez López')]//ancestor::mat-radio-button")
    private WebElement departmentLabel;

    @FindBy(xpath = "//*[@id='mat-radio-20']/label/div[2]/span")
    private WebElement jobLabel;

    @FindBy(xpath = "//span[contains(text(), 'Santa Cruz de Tenerife')]//parent::button")
    private WebElement localizacionSelectada;

    @FindBy(xpath = "//div[@class='c-detail-appointment__card__content__section']//descendant::p")
    public List<WebElement> clientInformation;

    @FindBy(xpath = "//div[@class='mat-select-arrow-wrapper ng-tns-c71-20']")
    private WebElement documentType;

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }

    //Elementos de la pagina:

    public void clickDate(){
        dayDate.click();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        hourDate.click();
    }

    public void selectLanguage() {
        Actions actions = new Actions(getDriver());

        actions.moveToElement(language).perform();
        actions.moveToElement(languageDisplay).click().perform();
    }
    public String englishSelection(){
        return languageSelected.getText();
    }

    public void clickLocation() {
        locationLabel.click();
    }

    //Metodo que valida que el menu esta desplegable
    public static boolean estaMenuDesplegado() {
        WebDriver driver = null;
        String idMenu = "";
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
    public void clickDepartment() {
        departmentLabel.click();
    }
    public void clickJob() {
        jobLabel.click();
    }

    public void completeName(String completeName){
        writeName.sendKeys(completeName);
    }

    public void selectDocumentType() { documentType.click();}
    public void fillIdentityDocument(String identityDocument) {
        dniCamp.sendKeys(identityDocument);
    }

    public void completeEmail(String email){
        emailCamp.sendKeys(email);
    }

    public void completePhone(String phone){
        phoneCamp.sendKeys(phone);
    }

    public void completeComments(String comments) { commentsCamp.sendKeys(comments);}

    public void checkBox() {checkBox.click();}

    public void requestButton() {requestButton.click();
    }
    public List<WebElement> getClientInformation() {
        return clientInformation;
    }

    public String departmentDeployed(){
        return departmentView.getText();
    }

}


