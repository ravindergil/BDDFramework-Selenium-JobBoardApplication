package utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    static WebDriver driver;
    public static WebDriver getDriver(String DriverName) {

        if (DriverName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (DriverName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (DriverName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (DriverName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Mentioned Driver is not Supported");
        }
        return driver;
    }

}
