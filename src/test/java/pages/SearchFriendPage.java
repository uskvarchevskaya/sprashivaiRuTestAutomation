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
public class SearchFriendPage extends AbstractPage{

    private final String BASE_URL = "http://sprashivai.ru/";
    private final String USERNAME_2 = "superman_GoGo";
    private final Logger logger = Logger.getLogger(SearchFriendPage.class);

    @FindBy(xpath = "//input[@id='nav_search_inp']")
    private WebElement inputUsername;

    @FindBy(xpath = "//button[@id='nav_search_btn']")
    private WebElement buttonSearch;

    @FindBy(xpath = "//a[@href='/superman_GoGo']")
    private WebElement buttonUser;

    @FindBy(xpath = "//span[@class='pr-username']")
    private WebElement linkLoggedInUser;


    public SearchFriendPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
    }

    public List<String> findFriend () throws InterruptedException {

        inputUsername.sendKeys(USERNAME_2);
        logger.info("Input username");
        Thread.sleep(2000);
        buttonSearch.click();
        Thread.sleep(2000);
        buttonUser.click();
        Thread.sleep(2000);



        List<String> friend = new ArrayList<String>();
        friend.add('@'+USERNAME_2);
        friend.add(linkLoggedInUser.getText());
        return friend;
    }
}
