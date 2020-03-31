Feature: Basic Actions feature

  Scenario: Create new Juice Shop user
    When I "create user" in "Registration" page with the following data:
      | Email             | foo@bar.com                |
      | Password          | easyPassword               |
      | Security question | Name of your favorite pet? |
      | Security answer   | Mushu                      |
    Then I log in with the following data:
      | Email    | foo@bar.com  |
      | Password | easyPassword |

  Scenario: Search for apple
    When I search for "banana"
    Then I see "search results" in "Results" page with following data:
      | Name         | Banana Juice (1000ml)     |
      | Description  | Monkeys love it the most. |
      | Price        | 1.99                      |