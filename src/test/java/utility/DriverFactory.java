package utility;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    static WebDriver driver;
    public static WebDriver getLocalDriver(String browserName) {
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browserName.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("Safari")) {
            driver = new SafariDriver();
        } else {
            System.out.println("Mentioned Driver is not Supported");
            throw new IllegalArgumentException("Mentioned environment is not correct");
        }
        return driver;
    }
    
    public static WebDriver getRemoteWebDriver(String browserName) {

        URL url = null;
        try {
            url = new URL(ReadProperties.getHostEnvURL());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        MutableCapabilities option;
        switch (browserName.toLowerCase()) {
            case "firefox":
                option = new FirefoxOptions();
                break;
            case "chrome":
                option = new ChromeOptions();
                break;
            case "edge":
                option = new EdgeOptions();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + browserName.toLowerCase());
        }
        option.setCapability("se:recordVideo", true);
        return new RemoteWebDriver(url, option);
    }

    public static WebDriver getDriver(String RunEnv, String browserName) {
        if(RunEnv.equalsIgnoreCase("LOCAL")){
            driver = getLocalDriver(browserName);
        } else if (RunEnv.equalsIgnoreCase("DOCKER")) {
            driver = getRemoteWebDriver(browserName);
        } else {
            System.out.println("Env Not available");
            throw new IllegalArgumentException("Mentioned environment is not correct");
        }
        return driver;
    }

}
