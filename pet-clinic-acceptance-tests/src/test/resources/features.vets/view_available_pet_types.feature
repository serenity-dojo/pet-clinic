Feature: View available Pet types
  As a Vet Clinic Owner
  I want to be able to define different Pet types
  So that I can have a list of Pets that my clinic can care for

  Scenario: Check currently available Pet Types
    Given Peter is a Pet Clinic owner
    When he checks available Pet Types
    Then he should see the pet types

  Scenario: Check if cats can be submitted to the clinic
    When Peter checks if cat can be submitted to the clinic
    Then he should receive a confirmation