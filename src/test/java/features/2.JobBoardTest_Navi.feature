@JobBoardTest

Feature: Feature to test Navigation for Job Board Application

  Background: Open application link
    Given User open the Browser and Navigate to URL

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



