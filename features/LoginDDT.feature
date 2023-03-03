Feature: Login Application

  Scenario Outline: test Application login page
    Given user open url "https://rahulshettyacademy.com/client/"
    When user enter username "<email>" and password "<password>"
    And click on login button
    Then Verify login is successfully or not

    Examples: 
      | email        | password  |
      | SK@gmail.com | Sk#$12345 |
      | SK@gmail.com | Sk@123    |
