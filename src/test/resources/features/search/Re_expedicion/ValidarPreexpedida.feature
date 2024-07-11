Feature: validar estado de tarjeta pre-expedida

  valiar que la tarjeta preexpedida no exista en CABFFTARJ,
  CABFFCTAS, CABFFCTAS y no tenga nit asociado en MATFFPREEX

  Scenario Outline: validar si tarjeta es preexpedida para generar novedad
    When la tarjeta "<numCard>" no tiene cliente asociado en MATFFPREEX
    And la tarjeta "<numCard>" no existe en CABFFTARJ
    And la tarjeta "<numCard>" no existe en MATFFMDMAE
    And la tarjeta "<numCard>" no tiene asociadas cuentas en CABFFCTAS

    Examples:
      | numCard           |
      | 5306917184404791  |
      | 5306917131401049  |
      | 5306917217427603  |


