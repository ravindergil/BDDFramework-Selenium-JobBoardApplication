package utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitTypes {

    WebDriver driver;
    WebDriverWait wait;

    public WaitTypes(WebDriver driver){
        this.driver=driver;
    }

    public void waitForElementLocated(By locator, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
      //  wait.until(ExpectedConditions.)

    }


    public void waitForElementsVisibility(By locator, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForVisibleWebElement(WebElement element, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementClickable(WebElement element, int time){
        wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

}
