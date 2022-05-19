Feature: Appointment Form test suite

  Background:
    Given access to the web page https://citaprevia.demohiberus.com/

  @testcase01
  Scenario Outline: Appointment form is shown
    Then Appointment form is shown

    Examples:
      | URL                                 |
      | https://citaprevia.demohiberus.com/ |
