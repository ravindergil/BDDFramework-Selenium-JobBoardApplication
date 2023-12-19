package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.bidi.script.Message;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import utility.DriverFactory;
import utility.ReadProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import utility.WaitTypes;

import java.net.MalformedURLException;
import java.net.SocketException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class JobBoardTest {

    String BrowserName = ReadProperties.getBrowser();
    String RunEnv = ReadProperties.getRunEnv();
    public WebDriver driver = DriverFactory.getDriver(RunEnv, BrowserName);
    WaitTypes wait;

    String title;
    String expectedTitle;
    String HeadingText;
    String HeaderImageURL;
    String SecondHeaderText;
    public Scenario scenario;


    @Before
    public void beforeHook(Scenario scenario) {
        this.scenario = scenario;
        System.out.println("===Before Hook Running===");
        System.out.println("Execution starts for scenario: " + scenario.getName());
        System.out.println("Session ID: " + scenario.getId());

    }

    @After
    public void afterHook(Scenario scenario) {
        this.scenario = scenario;
        System.out.println("===After Hook Running===");
        System.out.println("Execution ended for scenario: " + scenario.getName() + " and is " + scenario.getStatus());
        //System.out.println("Test cases is: " + scenario.getStatus());

    }

    /* Scenario 1 Methods */
    @Given("^User open the Browser and Navigate to URL$")
    public void user_open_the_browser_and_navigate_to_url() {
        driver.get(ReadProperties.getURL());
        System.out.println("Open browser");
        driver.manage().window().maximize();
        wait = new WaitTypes(driver);
    }
    @When("^Page Opens successfully get the Page title$")
    public void page_opens_successfully() {
        title=driver.getTitle();
        System.out.println("The Title is : " + title);
    }

    @Then("^Compare Title with expected value$")
    public void get_title_of_the_page() {
        expectedTitle="Alchemy Jobs – Job Board Application";
        if (expectedTitle.equals(title)){
            System.out.println("Title Matches test case Pass" );
        }else{
            System.out.println("No Match: TestCase Fails");
        }
    }

    @And("^Close Browser$")
    public void close_browser() {
        driver.close();
        System.out.println("Browser Closed");
    }

    /* Scenario 2 Methods */

    @When("Page Opens get Landing Page Heading")
    public void page_opens_get_landing_page_heading() {
        WebElement Heading = driver.findElement(By.xpath("//h1[@class='entry-title']"));
        HeadingText = Heading.getText();
        System.out.println(HeadingText);
    }

    @Then("Compare Heading with expected value")
    public void compare_heading_with_expected_value() {
        String expectedText = "Welcome to Alchemy Jobs";
        assertEquals(HeadingText, expectedText);
        System.out.println("Both texts Matched");
    }

    /* Scenario 3 Methods */

    @When("Page Opens get url of Header Image")
    public void page_opens_get_url_of_header_image() {
        WebElement HeaderImage = driver.findElement(By.xpath("//div[@class='post-thumb-img-content post-thumb']/img"));
        HeaderImageURL = HeaderImage.getAttribute("src");

    }

    @Then("Print url to Console")
    public void print_url_to_console() {
        System.out.println(HeaderImageURL);
    }

    /* Scenario 4 Methods */

    @When("Page Opens get Landing Page Second Heading")
    public void page_opens_get_landing_page_second_heading() {
        WebElement SecondHeader = driver.findElement(By.xpath("//h2[contains(text(),'Quia quis non')]"));
        SecondHeaderText = SecondHeader.getText();
    }

    @Then("Compare Second Heading with expected value")
    public void compare_second_heading_with_expected_value() {
        String expectedText = "Quia quis non";
        assertEquals(SecondHeaderText, expectedText);
        System.out.println("Both texts Matched");
    }

    /* Scenario 5 Methods */

    @When("Page Opens find navigation bar and Click Jobs")
    public void page_opens_find_navigation_bar() {
        WebElement JobsBtn = driver.findElement(By.xpath("//li[@id='menu-item-24']/a"));
        JobsBtn.click();
    }

    @Then("Read Page Title and Verify")
    public void read_page_title_and_verify() {
        String Title = driver.getTitle();
        System.out.println(Title);
        if (Title.equals("Jobs – Alchemy Jobs")){
            assertTrue(true);
        } else {
            assertTrue(false);
        }
    }

    /* Scenario 6 Methods */

    @Then("Click and open the jobs listed.")
    public void click_and_open_the_jobs_listed() {
        WebElement job = driver.findElement(By.xpath("//input[@id='search_keywords']"));
        job.sendKeys("Banking");
        driver.findElement(By.id("search_keywords")).click();
        By locator = By.xpath("//ul[@class='job_listings']/li[1]/a/img");
       // wait = new WaitTypes(driver);
        wait.waitForElementsVisibility(locator, 10);
        driver.findElement(locator).click();
    }

    @Then("Click apply button and print the emailId to the console")
    public void click_apply_button_and_print_the_email_id_to_the_console() {
        System.out.println("Applying for the Now");

        WebElement JobFilled = driver.findElement(By.xpath("//div[@class='single_job_listing']/ul/li[3]"));
        String JobFilledText = JobFilled.getText();

        if (JobFilledText.equals("This position has been filled")){
            System.out.println("Job is not available");
        } else {
            WebElement ApplyBtn = driver.findElement(By.className("application_button button"));
            ApplyBtn.click();
            WebElement emailID = driver.findElement(By.className("job_application_email"));
            String EmailText = emailID.getAttribute("href");
            System.out.println(EmailText);
        }

    }

    /* Scenario 7 Methods */

    @When("Page Opens click Post a Job")
    public void page_opens_click_post_a_job() {
        //wait = new WaitTypes(driver);
        wait.waitForElementsVisibility(By.linkText("Post a Job"), 5);
        WebElement PostJob = driver.findElement(By.linkText("Post a Job"));
        PostJob.click();
    }

    @Then("Fill in the necessary details and click the Preview button.")
    public void fill_in_the_necessary_details_and_click_the_preview_button() {
        driver.findElement(By.id("create_account_email")).sendKeys("def@defg.com");
        driver.findElement(By.id("job_title")).sendKeys("Test Engineer");
        driver.findElement(By.id("job_location")).sendKeys("Mumbai");
        WebElement selectWE = driver.findElement(By.id("job_type"));
        Select sel = new Select(selectWE);
        sel.selectByVisibleText("Internship");

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.switchTo().frame("job_description_ifr");
        WebElement textBox = driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.sendKeys("Looking for a work student in testing field");
        driver.switchTo().defaultContent();

        driver.findElement(By.id("application")).sendKeys("https://outlook.com");
        driver.findElement(By.id(("company_name"))).sendKeys("IBM Pvt. Ltd.");

        WebElement previewBtn = driver.findElement(By.xpath("//input[@class='button']"));
        previewBtn.getAttribute("value");
        previewBtn.click();

        System.out.println("Preview button clicked");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    @Then("Click Submit Listing")
    public void click_submit_listing() {
        WebElement SubmitListing = driver.findElement(By.id("job_preview_submit_button"));
        wait.waitForVisibleWebElement(SubmitListing, 5);
        SubmitListing.click();


    }

    @Then("Verify that the job posted by visiting the jobs page")
    public void verify_that_the_job_posted_by_visiting_the_jobs_page() {
        String SubmissionText = "Job listed successfully. To view your listing";
        WebElement message = driver.findElement(By.xpath("//div[@class='entry-content clear']"));
        System.out.println(message.getText());
        if (message.isDisplayed()){
            assertTrue(true);
        } else {
            System.out.println("Job is not posted");
        }
    }

    /* Scenario 8 Methods */

    @Given("Admin user open the Browser and Navigate to admin URL")
    public void admin_user_open_the_browser_and_navigate_to_admin_url() {
        driver.get(ReadProperties.getAdminURL());
        driver.manage().window().maximize();

    }
    @When("Page Opens enter {string} and {string} and click login")
    public void page_opens_enter_and_and_click_login(String Username, String Password) {
        driver.findElement(By.id("user_login")).sendKeys(Username);
        driver.findElement(By.id("user_pass")).sendKeys(Password);
        driver.findElement(By.id("wp-submit")).click();
    }


    @Then("Verify the user Logged in Successfully")
    public void verify_the_user_logged_in_successfully() {
        WebElement logIn = driver.findElement(By.xpath("//ul[@id='wp-admin-bar-top-secondary']/li/a"));
        String logInText = logIn.getText();
        System.out.println(logInText);
        if (logInText.equals("Howdy, root")){
            System.out.println("user logged in successfully");
        } else {
            System.out.println("Login is not successful");
        }

    }

    /* Scenario 9 Methods */
    @Then("Click Job Listings")
    public void click_job_listings() {
        WebElement JobListingBtn = driver.findElement(By.xpath("//div[@id='adminmenuwrap']/ul/li[7]/a"));
        JobListingBtn.click();
    }

    @Then("Click add New")
    public void click_add_new() {
        WebElement AddNewBtn = driver.findElement(By.className("page-title-action"));
        AddNewBtn.click();
    }

    @Then("Fill in the necessary details")
    public void fill_in_the_necessary_details() {
        WebElement position = driver.findElement(By.xpath("//textarea[@id='post-title-0']"));
        position.clear();
        position.sendKeys("Data Analyst");
  /*
        WebElement classic = driver.findElement(By.xpath("//div[@class='block-editor-block-list__layout']/div/div[1]"));
        classic.click();

        WebElement editor = driver.findElement(By.xpath("/div[@class='block-editor-block-list__layout']/div/div[2]"));
        editor.click();
        editor.sendKeys("Data Analyst required in for Mumbai location");
*/
        WebElement jobLocation = driver.findElement(By.id("_job_location"));
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView();", jobLocation);

        jobLocation.sendKeys("Mumbai");
        driver.findElement(By.id("_company_name")).sendKeys("Axa Gmbh");

    }


    @Then("Click publish button")
    public void click_publish_button() {
        driver.findElement(By.xpath("//div[@class='edit-post-header__settings']/button[2]")).click();
        System.out.println("Publish button clicked");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//button[(text()='Publish')]")).click();
        System.out.println("Published Successfully");

    }


    @Then("Verify the job created")
    public void verify_the_job_created() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        driver.findElement(By.xpath("//a[@class='components-button is-secondary']")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        WebElement PositionName = driver.findElement(By.xpath("//div[@class='ast-single-post-order']/h1"));
        System.out.println(PositionName.getText());
        WebElement CompanyName = driver.findElement(By.xpath("//div[@class='company']"));
        System.out.println(CompanyName.getText());

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        if (PositionName.getText().equals("Data Analyst") && CompanyName.getText().equals("Axa Gmbh")) {
            System.out.println("Job is verified Successfully");
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        } else {
            System.out.println("Job is not posted");
        }

    }
}
