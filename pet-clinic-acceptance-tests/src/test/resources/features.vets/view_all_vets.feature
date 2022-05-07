Feature: View all vets

  As a Pet Clinic owner
  I need to be able to see all of the vets I employ, along with their specialities
  So that I know if I need to hire anyone else

  Scenario: View the full list of vets
    Given Peter is a Pet Clinic owner
    When he views the vets in his clinic
    Then he should see the name of each vet in the clinic