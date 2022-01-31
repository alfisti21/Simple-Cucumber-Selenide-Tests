Feature: FedEx Home Page basic tests

  Background:
    Given I access "https://www.fedex.com/en-gb/home.html" page


  Scenario: Check Location pop-up
    Then I verify that the location asking pop-up is present
    And  I dismiss the pop-up and cookies

  Scenario: Track an order in main page
    And  I dismiss the pop-up and cookies
    When I provide "123456789012" as tracking ID in "main page"
    Then I verify the result

  Scenario: Track an order in navigation pane
    And  I dismiss the pop-up and cookies
    And  I click Tracking on the navigation pane
    When I provide "123456789012" as tracking ID in "navigation pane"
    Then I verify the result

  Scenario: Calculate FedEx shipping rates
    And  I dismiss the pop-up and cookies
    And  I switch to the calculator module
    Then I provide 'from' and 'to' addresses
    And  I choose package
    Then I validate rates results

  Scenario: Verify access to shipping page
    And  I dismiss the pop-up and cookies
    And  I switch to the shipping page
    Then I confirm I end up in login page

  Scenario: Verify chat bot
    And  I dismiss the pop-up and cookies
    Then I open the chat bot and confirm there is an initial message
    And  I type a hint
    Then I check there is a relevant bot response

  Scenario: Verify Search functionality
    And  I dismiss the pop-up and cookies
    And  I navigate to search and look up for "Package"
    Then I verify the search results

  #Below scenario might not work. The Manage Your Shipment section is not always visible when auto-test runs
  Scenario: Verify 'Manage your shipment' section
    And  I dismiss the pop-up and cookies
    Then I verify 'Manage your shipment' is visible
    And  I check that I am redirected properly to those pages

  #Unfortunately, the 'More News' button in home page re-directs to a broken page
  Scenario: Verify news section
    And  I dismiss the pop-up and cookies
    Then I verify latest news section is present
    And  I check the 'More News' option and verify

  Scenario: Verify location/language change
    And  I dismiss the pop-up and cookies
    When I click the location-language link and change
    Then I verify I am redirected and language is changed