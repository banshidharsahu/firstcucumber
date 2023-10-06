Feature: That is Cucumber for logimn check

  Scenario: Login to application
    Given brower got opened with details
    And User move to Layout dropdown
    When User enter userid and password
    And click on Login button
    Then User should navigate to Warning page
