package steps;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by PC on 15.01.2016.
 */
public class Steps{

    private WebDriver driver;

    private final Logger logger = Logger.getLogger(Steps.class);


    public void initBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().pageLoadTimeout(35, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(35, TimeUnit.SECONDS);
        logger.info("Browser started");
    }

    public void closeDriver() {
        driver.quit();
    }

    public void loginSprashivaiRu(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.openPage();
        loginPage.login(username, password);
    }

    public boolean isLoggedIn(String username) {

        LoginPage loginPage = new LoginPage(driver);
        return (loginPage.getLoggedInUserName().trim().equals('@' + username));
    }

    public List<String> newDescription() throws InterruptedException {
        InformationPage informationPage = new InformationPage(driver);
        List<String> descriptions = informationPage.addNewInformation();
        return descriptions;
    }

    public List<String> search() throws InterruptedException{
        SearchFriendPage searchFriendPage = new SearchFriendPage(driver);
        List<String> friends = searchFriendPage.findFriend();
        return friends;
    }

    public List<String> addTo() throws InterruptedException{
        FavoritesPage favoritesPage = new FavoritesPage(driver);
        List<String> listOfFavorites = favoritesPage.addToFavorites();
        return listOfFavorites;
    }

    public List<String> addLocation() throws InterruptedException{
        LocationPage locationPage = new LocationPage(driver);
        List<String> locations = locationPage.addNewLocation();
        return locations;
    }


}
