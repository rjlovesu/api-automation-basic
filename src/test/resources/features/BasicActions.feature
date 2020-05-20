Feature: Basic Actions

  @WIP
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
    And I choose delivery address "Dummystreet 42"
    And I choose delivery option "Fast Delivery"
    And I choose payment card "1234567812345678"
    And I checkout the order
    Then I see "track order" in "order completion" page with following data:
      | Name      | Juice Shop Artwork |
      | Price     | 278.74             |
      | Delivered | false              |

  @WIP
  Scenario: Login with wrong credentials
    When I try to log in with the following data:
      | Email    | demo |
      | Password | 1234 |
    Then I see "response code" in "login" page with following data:
      | Response code | 401                        |
      | Error message | Invalid email or password. |

  @WIP @HOME_WORK @IMPLEMENT_THIS
  Scenario: Delete basket items
    When I log in with the following data:
      | Email    | demo |
      | Password | demo |
    And I "delete items" in "basket" page with the following data:
      | Name 0 | Eggfruit Juice (500ml)   |
      | Name 1 | Raspberry Juice (1000ml) |
    Then I see "empty basket" in "basket" page

  @WIP @HOME_WORK @IMPLEMENT_THIS
  Scenario: Change password
    When I log in with the following data:
      | Email    | demo |
      | Password | demo |
    And  I change password with the following data:
      | Current Password    | demo            |
      | New Password        | newDemoPassword |
      | Repeat New Password | newDemoPassword |
    Then I log in with the following data:
      | Email    | demo            |
      | Password | newDemoPassword |
