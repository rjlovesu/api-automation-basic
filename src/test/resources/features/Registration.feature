Feature: Basic Actions feature

  @WIPx
  Scenario: Search for banana
    When I search for "banana"
    Then I see "search results" in "Search" page with following data:
      | Name         | Banana Juice (1000ml)     |
      | Description  | Monkeys love it the most. |
      | Price        | 1.99                      |
  @WIP
  Scenario: Create new Juice Shop user
    When I "create user" in "Registration" page with the following data:
      | Email             | foo@bar.com                |
      | Password          | easyPassword               |
      | Security question | Name of your favorite pet? |
      | Security answer   | Mushu                      |
    Then I log in with the following data:
      | Email    | foo@bar.com  |
      | Password | easyPassword |

    @WIP
  Scenario: Order an item
    When I log in with the following data:
      | Email    | demo |
      | Password | demo |
    And I add "Juice Shop Artwork" to the basket
    And I perform checkout
