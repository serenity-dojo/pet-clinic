Feature: Manage Veterinarians Data

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

    Scenario: Vet can have a single speciality
      Given Helen Leary is an employed vet that specializes in radiology
      When Peter checks her speciality
      Then he should see that her speciality is radiology

    Scenario: Vet can have multiple specialities
      Given Linda is an employed vet that specializes in dentistry and surgery
      When Peter checks her speciality
      Then he should see that she has two specialities

    Scenario: Vet speciality can be unspecified
      Given James is an employed vet without any specific speciality
      When Peter checks his speciality
      Then he should see that James has no speciality specified

  Rule: Vet data can be updated
    In case of marriage or some other private matters, vet names should be editable
    so that the data can be updated.
    If a vet manages to acquire a new speciality it must be added to his profile data.

    Scenario: Vet first and last name can be updated
      Given Helen is an employed vet that specializes in radiology
      When Peter changes her first name
      And Peter changes her last name
      Then her name should be updated

    Scenario: Vet speciality can be added
      Given James is an employed vet without any speciality
      When Peter adds radiology as James speciality
      Then James speciality should be radiology