@JobBoardTest

Feature: Feature to test Job Board Application

  Background: Open application link
    Given User open the Browser and Navigate to URL

  @First @Smoke
  Scenario: 1. Verify the website title - Read the title of the website and verify the text
    When Page Opens successfully get the Page title
    Then Compare Title with expected value
    And Close Browser
  @Second @Smoke
  Scenario: 2. Verify the website heading - Read the heading of the website and verify the text.
    When Page Opens get Landing Page Heading
    Then Compare Heading with expected value
    And Close Browser
  @Third
  Scenario: 3. Get the url of the header image - Print the url of the header image to the console
    When Page Opens get url of Header Image
    Then Print url to Console
    And Close Browser
  @Fourth @Smoke
  Scenario: 4. Verify the website’s second heading - Read the second heading of the website and verify the text
    When Page Opens get Landing Page Second Heading
    Then Compare Second Heading with expected value
    And Close Browser
  @Fifth @Smoke
  Scenario: 5. Navigate to another page : Navigate to the “Jobs” page on the site.
    When Page Opens find navigation bar and Click Jobs
    Then Read Page Title and Verify
    And Close Browser
  @Sixth
  Scenario: 6. Apply to a job : Search for a job and apply for it.
    When Page Opens find navigation bar and Click Jobs
    Then Click and open the jobs listed.
    Then Click apply button and print the emailId to the console
    And Close Browser
    @Seventh
    Scenario: 7. Create a new job listing : Create a new job listing.
      When Page Opens click Post a Job
      Then Fill in the necessary details and click the Preview button.
      Then Click Submit Listing
      Then Verify that the job posted by visiting the jobs page
      And Close Browser


  @Eighth @Admin
  Scenario: Login into the website’s backend - Visit the site’s backend and login
    Given Admin user open the Browser and Navigate to admin URL
    When Page Opens enter "root" and "pa$$w0rd" and click login
    Then Verify the user Logged in Successfully
    And Close Browser

  @Ninth @Admin
  Scenario: Create a job listing using the backend - Visit the site’s backend and create a job listing
    Given Admin user open the Browser and Navigate to admin URL
    When Page Opens enter "root" and "pa$$w0rd" and click login
    And Verify the user Logged in Successfully
    And Click Job Listings
    And Click add New
    And Fill in the necessary details
    And Click publish button
    And Verify the job created
    Then Close Browser