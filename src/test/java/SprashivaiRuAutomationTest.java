import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.FavoritesPage;
import steps.Steps;

import java.util.List;

/**
 * Created by PC on 15.01.2016.
 */
public class SprashivaiRuAutomationTest {

    private Steps steps;
    private final String USERNAME = "testProject";
    private final String PASSWORD = "testProject";

    @BeforeMethod(description = "Init browser")
    public void setUp(){
        steps = new Steps();
        steps.initBrowser();
    }

    @AfterMethod(description="Stop Browsser")
    public void stopBrowser(){
        steps.closeDriver();
    }

    @Test(description="Login to sprashivai.ru")
    public void oneCanLoginSprashivaiRu(){
        steps.loginSprashivaiRu(USERNAME, PASSWORD);
        Assert.assertTrue(steps.isLoggedIn(USERNAME));
    }

    @Test(description="Add new description")
    public void oneCanAddNewDescription() throws InterruptedException {
        steps.loginSprashivaiRu(USERNAME, PASSWORD);
        List<String> description = steps.newDescription();
        Assert.assertEquals(description.get(0),description.get(1));
    }

    @Test(description = "Search Friend")
    public void oneCanFindAFriend() throws InterruptedException{
        steps.loginSprashivaiRu(USERNAME,PASSWORD);
        List<String> friend = steps.search() ;
        Assert.assertEquals(friend.get(0),friend.get(1));
    }

    @Test(description = "Add to favorites")
    public void oneCanAddUserToFavorites() throws InterruptedException{
        steps.loginSprashivaiRu(USERNAME,PASSWORD);
        List<String> favorites = steps.addTo() ;
        Assert.assertEquals(favorites.get(0),favorites.get(1));
    }

    @Test(description = "Add new location")
    public void oneCanAddNewLocation() throws InterruptedException{
        steps.loginSprashivaiRu(USERNAME,PASSWORD);
        List<String> location = steps.addLocation() ;
        Assert.assertEquals(location.get(0),location.get(1));
    }
}
