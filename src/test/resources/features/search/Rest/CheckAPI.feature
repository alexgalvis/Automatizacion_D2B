Feature: prueba automatizacion api test

  prueba de automatizacion test para validar funcionamiento de
  las APIs Kioscos

  Scenario Outline: consultar API MDM

    Given que tengo la "<cedula>", "<tipDoc>" y la "<operacion>"
    When realizo la solicitud POST a APIs MDM
    Then el resultado es 200 OK

    Examples:
      | cedula   |    tipDoc    |  operacion                                                                                         |
      |1989988761| TIPDOC_FS001 | /customer-reference-data-management/customer-personal-data/retrieve-basic-information              |
      |1989988761| TIPDOC_FS001 | /Customer-Relationship-Management/customer-commercial-data/customers/retrieve-commercial-management|
      |1999050795| TIPDOC_FS001 | /customer-reference-data-management/customer-contact/retrieve-contact-information                  |
