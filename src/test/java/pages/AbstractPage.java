package pages;

import org.openqa.selenium.WebDriver;

/**
 * Created by PC on 15.01.2016.
 */
public abstract class AbstractPage {
    protected WebDriver driver;

    public abstract void openPage();

    public AbstractPage (WebDriver driver){
        this.driver = driver;
    }


}
