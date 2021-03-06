package helpers;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;

public class TapHelper extends ActionHelper {


    private TapHelper(AppiumDriver driver) {
        super(driver);
    }

    public static TapHelper tapHelper(AppiumDriver appiumDriver) {
        return new TapHelper(appiumDriver);
    }

    public void tap(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public void doubleTap(WebElement element) {
        waitForElementToBeClickable(element);
        new TouchAction(driver).tap(ElementOption.element(element)).release().perform()
                .tap(ElementOption.element(element)).release().perform();
    }
}
