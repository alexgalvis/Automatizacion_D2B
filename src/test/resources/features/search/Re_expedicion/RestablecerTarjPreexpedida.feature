Feature: Restablecer tarjeta re-expedida
  se restablece tarjeta en todos los archivos que modifica la
  novedad de asociacion por duplicado


  Scenario Outline: resetear tarjeta
    Given que la tarjeta "<numCard>" fue reexpedida se restablece

  Examples:
    | numCard           |
    | 5306917184404791  |
    | 5306917249480125  |
    | 5306917217427603  |
    | 5306917131401049  |
    | 5306917283171325  |




