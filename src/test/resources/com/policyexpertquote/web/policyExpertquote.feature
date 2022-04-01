@Regression
@endtoend

Feature: Find what policy I can get
  As a user
  I want to get a new policy quote
  So that I can get all policy covered


  @startpage
  Scenario: Verify the UI layout of policy expert quotation tool
    Given User is on policy expert quote tool page
    When User is on home page
    Then I should be able to view Go to compare page


  @Aboutyou
  Scenario: Check as a user what home policy I could get
    Given User is on policy expert quote tool page
    When User is on home page
    And user selects title as "Mrs"

  @smoke
  Scenario Outline: Cucumber Data Table
    Given User is on policy expert quote tool page
    When User is on home page
    And user enters
      | salutation | <Salutation> |
      | firstname  | <Firstname>  |
      | lastname   | <Lastname>   |
      | dob        | <yyyy-MM-dd>   |
      | martialstatus        | <martialstatus>   |
      | occupation        | <occupation>   |
      | otheroccupation        | <otheroccupation>   |
      | mobileno        | <mobileno>   |
      | email        | <email>   |

    Examples:
      | Salutation | Firstname | Lastname | yyyy-MM-dd | martialstatus | occupation | otheroccupation | mobileno | email |
      | Mrs        | Priyank   | Shah     | 1990-02-05 | Married       | Software Engineer | No       | 01111122111 | a@a.com |
      | Mr         | Mansi     | Shah     | 1960-04-05 | Single        | Software Engineer | No       | 01111122211 | a@c.com |