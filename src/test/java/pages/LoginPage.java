package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by PC on 15.01.2016.
 */
public class LoginPage extends AbstractPage{

    private final Logger logger = Logger.getLogger(LoginPage.class);
    private final String BASE_URL = "http://sprashivai.ru/";


    @FindBy(xpath = "//a[@id='signin_link']")
    private WebElement buttonLogIn;

    @FindBy(xpath = "//input[@id='signin_username']")
    private WebElement inputUsername;

    @FindBy(xpath = "//input[@id='signin_pass']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@id='signin_btn']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//span[@class='pr-username']")
    private WebElement linkLoggedInUser;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public void openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Loggin page opened");
    }

    public void login(String username, String password){

        buttonLogIn.click();
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        buttonSubmit.click();
        logger.info("Login formed");
    }

    public String getLoggedInUserName(){
        return linkLoggedInUser.getText();
    }

}
