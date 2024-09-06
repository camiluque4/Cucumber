Feature: sing in
  Everybody wants to sing in on SwagLabs

  Scenario Outline: login different users
    Given The user write the username <USER_NAME> and the password <PASSWORD>
    Then The user do logout



    Examples:
      |        USER_NAME         |    PASSWORD    |
      |  standard_user           |  secret_sauce  |
      |  problem_user            |  secret_sauce  |
      |  performance_glitch_user |  secret_sauce  |
