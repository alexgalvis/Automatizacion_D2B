Feature: consulta tarjetas debito

  consultas AS400

  Scenario Outline: consultar información de tarjeta

    When el numero de tarjeta es "<numCard>" en CABFFTARJ
    And el numero de tarjeta es "<numCard>" en CABFFCTAS

    Examples:
      | numCard           |
      | 5306917184404791  |
      | 5306917249480125  |
      | 5306917217427603  |
      | 5306917131401049  |
      | 5306917283171325  |