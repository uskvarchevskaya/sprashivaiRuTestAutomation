package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PC on 18.01.2016.
 */
public class LocationPage  extends AbstractPage{

    private final String BASE_URL = "http://sprashivai.ru/";
    private final String LOCATION = "Минск, Беларусь";
    private final Logger logger = Logger.getLogger(LocationPage.class);

    @FindBy(xpath = "//button[@id='pr_quck_edit_btn']")
    private WebElement buttonEdit;


    @FindBy(xpath = "//div[@id='combspr_div_pr_quick_edit_country_id']//b[@class='button comb_spr_button']")
    private WebElement buttonNamesOfContries;

    @FindBy(xpath = "//div[@id='combspr_div_pr_quick_edit_country_id']//a[@rel='2']")
    private WebElement buttonBelarus;

    @FindBy(xpath = "//div[@id='combspr_div_pr_quick_edit_city_id']//b[@class='button comb_spr_button']")
    private WebElement buttonNamesOfCities;

    @FindBy(xpath = "//div[@id='combspr_div_pr_quick_edit_city_id']//a[@rel='0']")
    private WebElement buttonMinsk;

    @FindBy(xpath = "//div//form//div//button[@id='pr_quick_edit_button']")
    private WebElement buttonSave;

    @FindBy(xpath = "//span[@class='pr-city']//a[text()='Минск, Беларусь']")
    private WebElement textLocation;


    public LocationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public List<String> addNewLocation() throws InterruptedException {

        Thread.sleep(2000);
        buttonEdit.click();
        logger.info("Open Edit page");
        buttonNamesOfContries.click();
        Thread.sleep(2000);
        buttonBelarus.click();
        Thread.sleep(2000);
        buttonNamesOfCities.click();
        Thread.sleep(2000);
        buttonMinsk.click();
        Thread.sleep(2000);
        logger.info("Added New Location");
        Thread.sleep(2000);
        buttonSave.click();
        Thread.sleep(2000);
        logger.info("New location save");

        List<String> descriptions = new ArrayList<String>();
        descriptions.add(LOCATION);
        descriptions.add(textLocation.getText());
        return descriptions;
    }

}
