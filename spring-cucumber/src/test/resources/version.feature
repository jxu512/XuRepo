Feature: Get version feature

  Scenario Outline: client to get version
    Given client call version <type>
    When client receives status code of 200
    Then client receives version <type>
    Examples:
      | type |
      | server |
      | component |
      | unknown |

  Scenario: client to get version2
    When client call version2
    Then client receives version2
