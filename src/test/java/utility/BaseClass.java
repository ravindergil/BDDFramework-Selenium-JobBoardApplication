package utility;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {
    public RemoteWebDriver driver;

    public BaseClass(RemoteWebDriver driver){
        this.driver=driver;
    }


}
