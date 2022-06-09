package mine.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewPage extends BasePage{
    private static WebDriver driver;
    public static String page_urlNewPage = driver.getCurrentUrl();
    String getPage_urlNewPage;

    NewPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public WebElement getPageLoadedTestElement() {
        return null;
    }


    @FindBy(xpath = "//div[@class='Si desea modificar la cita pulse aqui'")
    private WebElement linkModificacionCita;

    @FindBy(xpath = "//div[@class='Si desea cancelar la cita pulse aquí'")
    private WebElement linkCancelacionCita;

    @FindBy(xpath = "//mat-card-content/div[1]/p")
    private WebElement comprobarLocalizacion;

    @FindBy(xpath = "//mat-card-content/div[2]/p[1]")
    private WebElement comprobarOficina;

    @FindBy(xpath = "//mat-card-content/div[3]/p[1]")
    private WebElement comprobarServicio;

    @FindBy(xpath = "//mat-card-content/div[5]/p")
    private WebElement comprobarFechayHora;



}
