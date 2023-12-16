@JobBoardTest

Feature: Feature to test basic Job Board Application

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



