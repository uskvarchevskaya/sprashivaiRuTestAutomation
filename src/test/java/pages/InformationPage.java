package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 15.01.2016.
 */
public class InformationPage extends AbstractPage{

    private final String BASE_URL = "http://sprashivai.ru/";
    private final String DESCRIPTION = "Reading";
    private final Logger logger = Logger.getLogger(InformationPage.class);

    @FindBy(xpath = "//button[@id='pr_quck_edit_btn']")
    private WebElement buttonEdit;

    @FindBy(xpath = "//a[@title='Removing tag']")
    private WebElement buttonDeleteDescription;

    @FindBy(xpath = "//input[@id='interests_txtarea_tag']")
    private WebElement inputDescription;

    @FindBy(xpath = "//div//form//div//button[@id='pr_quick_edit_button']")
    private WebElement buttonSave;

    @FindBy(xpath = "//li[@class='jquery-autocomplete-selected-item acSelect']")
    private WebElement buttonAcResult;

    @FindBy(xpath = "//div//a[@class='int_link']")
    private WebElement textDescription;


    public InformationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public List<String> addNewInformation() throws InterruptedException {

        Thread.sleep(2000);
        buttonEdit.click();
        logger.info("Open Edit page");
        buttonDeleteDescription.click();
        inputDescription.sendKeys(DESCRIPTION);
        logger.info("Added New description");
        buttonAcResult.click();
        Thread.sleep(2000);
        buttonSave.click();
        Thread.sleep(2000);
        logger.info("New description save");

        List<String> descriptions = new ArrayList<String>();
        descriptions.add(DESCRIPTION);
        descriptions.add(textDescription.getText());
        return descriptions;
    }

}
