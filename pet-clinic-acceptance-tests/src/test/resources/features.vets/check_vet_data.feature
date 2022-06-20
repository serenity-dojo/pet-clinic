@challenge1
Feature: Check Veterinarians Data

  As a Pet Clinic Owner
  I want to be able to see all the vets I employ, along with their specialities
  So that I know if i need to hire anyone else

  As a Pet Clinic Owner
  I want to be able to add, update or delete my employees data
  So that my Vet list is always up to date

  Rule: Vet list should display full name for each employed vet

    Scenario: View the full list of vets
      Given Peter is a Pet Clinic owner
      When he views the vets in his clinic
      Then he should see the name of each vet in the clinic

  Rule: Vet speciality can be specified
  Employed vets do not need to have any specified speciality.
  There is a possibility for a vet to have more than one speciality.

    Scenario: View the specialities of each vet
      Given Peter is a Pet Clinic owner
      When he views the vets in his clinic
      Then he should see each of the following vet specialities
        | Name          | Specialities       |
        | James Carter  |                    |
        | Helen Leary   | radiology          |
        | Linda Douglas | dentistry, surgery |