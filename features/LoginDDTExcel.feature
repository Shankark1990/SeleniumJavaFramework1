Feature: Login Application

  Scenario Outline: test Application login page
    Given user open url "https://rahulshettyacademy.com/client/"
    When assing Email and Password with excel row "<row_index>"
    And click on login button
    Then Verify login is successfully or not

    Examples: 
      | row_index |
      |         1 |
      |         2 |
      |         3 |
