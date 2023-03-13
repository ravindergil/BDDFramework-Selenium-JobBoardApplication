@JobBoardTest_Admin

Feature: To test Job Board Application for Admin

  Background: : Open application link and user log in
    Given Admin user open the Browser and Navigate to admin URL
    When Page Opens enter "root" and "pa$$w0rd" and click login

  @Eighth
  Scenario: Login into the website’s backend - Visit the site’s backend and login
    Then Verify the user Logged in Successfully
    And Close Browser

  @Ninth
  Scenario: Create a job listing using the backend - Visit the site’s backend and create a job listing
    Then Verify the user Logged in Successfully
    Then Click Job Listings
    Then Click add New
    Then Fill in the necessary details
    Then Click publish button
    Then Verify the job created
    And Close Browser




