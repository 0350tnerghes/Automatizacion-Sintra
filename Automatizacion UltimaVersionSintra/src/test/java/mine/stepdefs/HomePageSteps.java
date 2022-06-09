package mine.stepdefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import mine.pages.PagesFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import mine.pages.HomePage;
import org.junit.Assert;
import org.openqa.selenium.By;

@Slf4j

public class HomePageSteps {

    @Given("the user is on the home page")
    public void NavigateAtHomePage() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user provides the url");
        HomePage homePage = pf.getHomePage();
        homePage.navigateTo(HomePage.pageUrl);
    }

    //testcase01 - Language selected
    @When("the user click English language display")
    public void clickLanguageButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user click the mouse on the <language> button");
        HomePage homePage = pf.getHomePage();
        homePage.selectLanguage();

    }

    @Then("The user changed the language at HomePage successfully")
    public void theHomePageEnglish() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The home page load in English language");
        HomePage homePage = pf.getHomePage();
        String currentLanguage = PagesFactory.getInstance().getDriver().findElement(By.xpath("//span[contains(text(), 'EN')]")).getText();
        Assert.assertEquals("ERROR", currentLanguage, homePage.englishSelection());
    }

    @Then("The HomePage did not loaded")
    public void theHomePageDidNotLoaded() {
        log.info("The home page load in English language");
        String currentUrl = PagesFactory.getInstance().getDriver().getCurrentUrl();
        Assert.assertEquals("the URL is not Home Page", HomePage.pageUrl, currentUrl);
    }

    //testcase02 - Location selected
    @When("The user selects a radio button from <location>")
    public void SelectLocation() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user select <location>");
        HomePage homePage = pf.getHomePage();
        homePage.clickLocation();
    }

    @Then("Location area is Folded while Department area is Deployed. The user can see on the right side the name of the Location selected")
    public void locationIsDisplayed() {
        log.info("The user selects <location> from radio button");
        String currentLocation = PagesFactory.getInstance().getDriver().findElement(By.xpath("//mat-panel-description[contains(text(),'Santa Cruz de Tenerife')]")).getText();
        Assert.assertEquals("ERROR to select location", "Santa Cruz de Tenerife", currentLocation);
    }

    @Then("Location area is not Folded while Department area is Deployed. The user can not see on the right side the name of the Location selected")
    public void locationSelectedError() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user select <location> from radio button");
        HomePage homePage = pf.getHomePage();
        //Assert.assertTrue("Error", homePage.estaMenuDesplegado());
    }

    //testcase03 - Department selected
    @When("The user selects a radio button from <department>")
    public void SelectDepartment() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user select <location>");
        HomePage homePage = pf.getHomePage();
        homePage.clickDepartment();
    }


    @Then("Department area is Folded while Job area is Deployed. The user can see on the right side the name of the Department selected")
    public void DepartmentIsSelected() {
        log.info("The user selects <department>");
        String department = PagesFactory.getInstance().getDriver().findElement(By.xpath("//mat-panel-description[contains(text(),'Estadio Heliodoro Ródriguez López')]")).getText();
        Assert.assertEquals("Department not selected", "Estadio Heliodoro Ródriguez López", department);
    }

    //testcase04 - Job selected
    @When("The user selects a radio button from <job>")
    public void SelectJob() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user selects <job>");
        HomePage homePage = pf.getHomePage();
        homePage.clickJob();
    }

    @Then("Job area is Folded while Date area is Deployed. The user can see on the right side the name of the Job selected")
    public void JobIsSelected() {
        String job = PagesFactory.getInstance().getDriver().findElement(By.xpath("//div[contains(text(),'Consultas sobre futbol base')]")).getText();
        Assert.assertEquals("Job not selected", "emoji_people Consultas sobre futbol base", job);
        ;
    }

    //testcase05 - Date selected
    @When("The user selects an available date")
    public void selectsAvailableDate() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user selects <job>");
        HomePage homePage = pf.getHomePage();
        homePage.clickDate();
    }

    @Then("Date area is Folded and CLIENT INFORMATION is Deployed. The user can see on the right side the date and hour selected")
    public void dateIsSelected() {
        String date = PagesFactory.getInstance().getDriver().findElement(By.xpath("//mat-panel-description[contains(text(),'06/06/2022 15:30')]")).getText();
        Assert.assertEquals("Wrong date", "06/06/2022 15:30", date);
    }

    //testcase06 - Complete Client Information
    @When("The user provides Name and Last Name {string}")
    public void completeName(String name) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user write the name");
        HomePage homePage = pf.getHomePage();
        homePage.completeName(name);
    }

    @And("The user provides the identity Document {string}")
    public void andTheUserProvidesTheIdentityDocument(String identityDocument) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user write the ID");
        HomePage homePage = pf.getHomePage();
        homePage.fillIdentityDocument(identityDocument);
    }
    @And("The user provides email {string}")
    public void completeEmail(String email) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user write the email");
        HomePage homePage = pf.getHomePage();
        homePage.completeEmail(email);
    }
    @And("The user provides phone {string}")
    public void completePhone(String phone) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user write the phone");
        HomePage homePage = pf.getHomePage();
        homePage.completePhone(phone);
    }
    @And("The user provides comments {string}")
    public void completeComments(String comments) {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user write the phone");
        HomePage homePage = pf.getHomePage();
        homePage.completeComments(comments);
    }
    @And("The user check the checkbox")
    public void clickCheckBox() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user click the checkBox");
        HomePage homePage = pf.getHomePage();
        homePage.checkBox();
    }

    @And("TThe user click the request button")
    public void clickRequestButton() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user click the request button");
        HomePage homePage = pf.getHomePage();
        homePage.requestButton();
    }
    @Then("The url is redirected to appointment info url")
    public void urlRedirected() {
        PagesFactory pf = PagesFactory.getInstance();
        log.info("The user click the request button");
        HomePage homePage = pf.getHomePage();
        homePage.getPageLoadedTestElement();
    }



}


