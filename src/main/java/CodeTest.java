import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CodeTest {

    static WebDriver driver = new ChromeDriver();
    static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));



    public static void main(String[] args) {

        driver.get("https://alchemy.hguy.co/jobs/");
        System.out.println("Open browser");
        driver.manage().window().maximize();

        WebElement PostJob = driver.findElement(By.linkText("Post a Job"));
        PostJob.click();

        driver.findElement(By.id("create_account_email")).sendKeys("abc@abc.com");
        driver.findElement(By.id("job_title")).sendKeys("Test Engineer");
        driver.findElement(By.id("job_location")).sendKeys("Munich");

        WebElement selectWE = driver.findElement(By.id("job_type"));
        Select sel = new Select(selectWE);
        sel.selectByVisibleText("Internship");

        driver.switchTo().frame("job_description_ifr");
        WebElement textBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.sendKeys("Looking for a work student in testing field");
        driver.switchTo().defaultContent();

        driver.findElement(By.id("application")).sendKeys("https://outlook.com");
        driver.findElement(By.id(("company_name"))).sendKeys("IBM Pvt. Ltd.");


        WebElement previewBtn = driver.findElement(By.xpath("//input[@class='button']"));
        previewBtn.getAttribute("value");
        previewBtn.click();


    }

}
