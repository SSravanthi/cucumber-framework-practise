Feature: LoginFeature
  This is the login page feature of an application

  Scenario: Login with correct username and password
    Given I navigate to the login page
    And I enter the users email address as Email:admin
    And I verify the count of my salary digits for Rs 10000
    And I just need to see how step looks  for Cucumber-Java8
    And I enter following login details
      | username | password |
      | admin    | admin    |
    And I click login button
    Then I should see the user details page

  Scenario: Login with correct username and password to fail
    Given I navigate to the login page
    And I enter following login details
      | username | password |
      | admin    | adminpassword    |
    And I click login button
    Then I should see the user details page wrongly

  Scenario Outline: Login with correct username and password using scenario outline
    Given I navigate to the login page
    And I enter <username> and <password>
    And I click login button
    Then I should see the user details page

    Examples:
      | username | password |
      | admin    | admin    |
      | test123  | test123  |
      | testabc  | testabc  |