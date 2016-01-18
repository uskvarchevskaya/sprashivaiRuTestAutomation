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
public class FavoritesPage extends AbstractPage{

    private final String BASE_URL = "http://sprashivai.ru/";
    private final String USERNAME_2 = "superman_GoGo";
    private final Logger logger = Logger.getLogger(FavoritesPage.class);

    @FindBy(xpath = "//input[@id='nav_search_inp']")
    private WebElement inputUsername;

    @FindBy(xpath = "//button[@id='nav_search_btn']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//a[@class='fav_lnk_superman_GoGo toolt-n']")
    private WebElement buttonAddToFavorites;

    @FindBy(xpath = "//i[@class='icon spr_icon_menu']")
    private WebElement buttonSettings;

    @FindBy(xpath = "//i[@class='icon mm_ic spr_icon_menu_star']")
    private WebElement buttonFavorites;

    @FindBy(xpath = "//a[@href='/superman_GoGo']")
    private WebElement button2User;

    @FindBy(xpath = "//i[@class='icon spr_icon_star']")
    private WebElement buttonDeleteFromFavorites;

    @FindBy(xpath = "//span[@class='pr-username']")
    private WebElement linkLoggedInUser;


    public FavoritesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public List<String> addToFavorites () throws InterruptedException {

        inputUsername.sendKeys(USERNAME_2);
        logger.info("Input username");
        Thread.sleep(2000);
        buttonSearch.click();
        Thread.sleep(2000);
        logger.info("User's profile");
        Thread.sleep(2000);
        buttonAddToFavorites.click();
        Thread.sleep(2000);
        logger.info("User is added to favorites");
        buttonSettings.click();
        logger.info("Button Settings");
        Thread.sleep(2000);
        buttonFavorites.click();
        button2User.click();

        List<String> friend = new ArrayList<String>();
        friend.add('@'+USERNAME_2);
        friend.add(linkLoggedInUser.getText());
        buttonDeleteFromFavorites.click();
        logger.info("User is deleted from favorites");
        return friend;

    }

}
