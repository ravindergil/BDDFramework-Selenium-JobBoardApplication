@JobBoardTest_Admin

Feature: To test Job Board Application for Admin

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






