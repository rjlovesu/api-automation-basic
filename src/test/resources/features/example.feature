Feature: Example feature

  Scenario: Create new Juice Shop user
    When I "create user" in "registration" page with the following data:
      | Email             | foo@bar.com                |
      | Password          | easyPassword               |
      | Security question | Name of your favorite pet? |
      | Security answer   | Mushu                      |
