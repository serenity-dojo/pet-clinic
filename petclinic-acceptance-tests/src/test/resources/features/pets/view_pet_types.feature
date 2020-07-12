Feature: View all the types of accepted pets
  As a pet owner
  I need to be able to see what types of pet are catered for
  So that I can know if I can bring in my sick pet

  Scenario: Every type of pet that is catered for should be listed
    Given Carrie is a pet owner
    When she views the different types of pets that can be treated
    Then she should see at least the following:
      | cat     |
      | dog     |
      | lizard  |
      | snake   |
      | bird    |
      | hamster |
