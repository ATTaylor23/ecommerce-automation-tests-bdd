Feature: Sign up features


  Scenario: Verify user sign up
    Given I am on the duotify homepage
    When  I sign up using valid credentials
    Then I should be able to land on the homepage
    And I should be able to verify the user details in the database


  Scenario: Verify user sign up using DataTable
    Given I am on the duotify homepage
    When  I sign up using the following credentials
      | username     | first  | last  | email                  | password    |
      | donnie.darko | Donnie | Darko | donnie.darko@gmail.com | donnie12345 |
    Then I should be able to land on the homepage
    And I should be able to verify the user details in the database

@db
  Scenario Outline: Verify user sign up using Scenario Outline
    Given I am on the duotify homepage
    When  I sign up using the following credentials
      | username   | first   | last   | email   | password   |
      | <username> | <first> | <last> | <email> | <password> |
    Then I should be able to land on the homepage
    And I should be able to verify the user details in the database

    Examples:
      | username      | first      | last        | email                       | password     |
      | donnie.darko  | Donnie     | Darko       | donnie.darko@gmail.com      | donnie12345  |
      | cbroadbridge0 | Charlie    | Broadbridge | cbroadbridge0@ustream.tv    | JapPXv3x     |
      | cgrigolon1    | Clarice    | Grigolon    | cgrigolon1@goodreads.com    | DovtJ6S47    |
      | chegel2       | Clarissa   | Hegel       | chegel2@businessweek.com    | 9bGS37T      |
      | reggleson3    | Rosaleen   | Eggleson    | reggleson3@newyorker.com    | tU5kRP4s36   |
      | grogans4      | Gloriane   | Rogans      | grogans4@who.int            | e7XNdjy3     |
      | vmantha5      | Viole      | Mantha      | vmantha5@independent.co.uk  | 8E8UnEAqz    |
      | wadriano6     | Wat        | Adriano     | wadriano6@sakura.ne.jp      | fDjO5SP6     |
      | bbarchrameev7 | Beckie     | Barchrameev | bbarchrameev7@wikipedia.org | GlwDhrC2MTY  |
      | arand8        | Angelique  | Rand        | arand8@shutterfly.com       | XCKw6i       |
      | egerlack9     | Evangeline | Gerlack     | egerlack9@mediafire.com     | 7cfYXpBWYRrD |


  Scenario: Verify user sign up flow from DB to UI
    Given I create a new user in the Database with the following details
      | username | first | last   | email                    | password    |
      | dannyBoy | Danny | Damien | dannyBoyDamien@gmail.com | password123 |
    When  I login with the same credentials on the UI
    Then I should be able to land on the homepage
    And firstname, lastname and email should be correct
