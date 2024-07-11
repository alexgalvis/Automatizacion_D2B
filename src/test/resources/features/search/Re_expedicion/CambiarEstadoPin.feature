Feature: Cambio de lastUpdateDate

  Se cambia la fecha de ultimo cambio de estado en la clave primaria del cliente
  en el archivo MATLIBRAMD.MATFFESTCL.

  Scenario Outline: cambio de campo lastUpdateDate

    When el cliente <nit> tuvo cambio reciente en la clave
    Then se actualiza la fecha de cambio reciente a "<fechaActualizada>" al cliente "<nit>"

    Examples:
    |   nit        |   fechaActualizada    |
    | 1999050795   |   202302015           |
  #  | 1999050794   |   202302015           |
