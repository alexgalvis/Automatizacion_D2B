Feature: Validar tarjeta re-expedida
  Se valida tarjeta posterior al proceso de reexpedicion
  en los diferentes archivos maestros en el as400

  Scenario Outline: Validar reexpedicion
    Given que la tarjeta "<numCard>" es pre-expedida
    And el estado en tarj "<numCard>" es activo y asociada al cliente "<nit>"
    Then la tarjeta "<numCard>" heredo las cuentas


    Examples:
    | numCard           |    nit       |
    | 5306917131401049  | 1989988761   |


