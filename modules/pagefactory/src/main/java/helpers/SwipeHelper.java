package helpers;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class SwipeHelper extends ActionHelper {

    private SwipeHelper(AppiumDriver driver) {
        super(driver);
    }


    public static SwipeHelper swiper(AppiumDriver driver) {
        return new SwipeHelper(driver);
    }

    public void swipeLeft(WebElement webElement) {
        int count = 0;
        while (count < 12) {
            left();
            if (webElement.isDisplayed()) {
                return;
            }
            count++;
        }
    }

    public void swipeRight(WebElement webElement) {
        int count = 0;
        while (count < 12) {
            right();
            if (webElement.isDisplayed()) {
                return;
            }
            count++;
        }
    }

    private void left() {
//        driver.swipe(getWidth() / 10, getHeight() / 2, getWidth() * 9 / 10, getHeight() / 2, 1000);
        new TouchAction(driver).press(PointOption.point(getWidth() / 10, getHeight() / 2))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(getWidth() * 9 / 10, getHeight() / 2))
                .release().perform();

    }

    private void right() {
//        driver.swipe(getWidth() * 9 / 10, getHeight() / 2, getWidth() / 10, getHeight() / 2, 1000);
        new TouchAction(driver).press(PointOption.point(getWidth() * 9 / 10, getHeight() / 2))
                .waitAction(WaitOptions.waitOptions(Duration.ofMillis(1000)))
                .moveTo(PointOption.point(getWidth() / 10, getHeight() / 2))
                .release().perform();

    }


}
