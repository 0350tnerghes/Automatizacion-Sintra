Feature: Access HomePage

  Background:
    Given the user is on the home page

  Scenario: Verify if an user can change the language at HomePage
    When the user click English language display
    Then The user changed the language at HomePage successfully

  Scenario: Verify an user can not change the language at HomePage
    And the user click English language display
    Then The HomePage did not loaded

  @testcase02

  Scenario: Verify that users can selects <location> on the Home Page from Location area
    When The user selects a radio button from <location>
    Then Location area is Folded while Department area is Deployed. The user can see on the right side the name of the Location selected

  Scenario: Select <location> from Location area
    When The user selects a radio button from <location>
    Then Location area is not Folded while Department area is Deployed. The user can not see on the right side the name of the Location selected

  @testcase03
  Scenario: Verify that users can select <department> on the home page from the department area
    When The user selects a radio button from <location>
    When The user selects a radio button from <department>
    Then Department area is Folded while Job area is Deployed. The user can see on the right side the name of the Department selected

  @testcase04
  Scenario: Verify that users can select <job> on the home page from the job area
    When The user selects a radio button from <location>
    When The user selects a radio button from <department>
    When The user selects a radio button from <job>
    Then Job area is Folded while Date area is Deployed. The user can see on the right side the name of the Job selected


  @testcase05
  Scenario: Verify that users can select <Date> & <Time> from Date area
    When The user selects a radio button from <location>
    When The user selects a radio button from <department>
    When The user selects a radio button from <job>
    When The user selects an available date
    Then Date area is Folded and CLIENT INFORMATION is Deployed. The user can see on the right side the date and hour selected


  @testcase06
  Scenario Outline: Verify that users can complete Client Information form
    When The user selects a radio button from <location>
    When The user selects a radio button from <department>
    When The user selects a radio button from <job>
    When The user selects an available date
    When The user provides Name and Last Name "<name>"
    And The user provides the identity Document "<identityDocument>"
    And The user provides email "<email>"
    And The user provides phone "<phone>"
    And The user provides comments "<comments>"
    And The user check the checkbox
    And The user click the request button
    Then The url is redirected to appointment info url
    Examples:
     |name   | identityDocument|email                   |phone    |comments|
     |Tamara |24339278B        |tamara.tamaran@yahoo.com|642334779|LALALALA|
