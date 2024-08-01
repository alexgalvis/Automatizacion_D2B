Feature: Cargar pantallas en base de datos
#************************************** GUARDAR DE RUTA  ****************************************
  Scenario: se guardan pantallas
    When se cargan pantallas de la ruta "C:\\Users\\Alex Duban Galvis\\Documents\\CELULA KIOSCO\AUTOMATIZACIONES\\Pantallas\\" y flujo "8"
    Then se listan pantallas guardadas

#************************************** BUSCAR POR TIPO FLUJO ****************************************
  Scenario: listar pantallas por tipo de flujo
    When se listan las pantallas del flujo "8"

#************************************** ELIMINAR PANTALLA ****************************************
  Scenario: eliminar pantalla
    When se elimina pantalla con ID: ""









#************************************** CREAR PANTALLA *******************************************
#  Scenario Outline: crear nueva pantalla
#    When se crea nueva pantalla con Tolerancia "0.9", idFlujo "7" y "<Text>"
#    Then se listan pantallas guardadas
#    Examples:
#      |       Text             |
#  #   |\nLinea1\nLinea2\nLinea3|
#      |\nBancolombia\nPefiltécnico\nHola\n¿Quéquiereshacerhoy?\nInformacióndelConfiguraciónde\nKioscored\nEstadodelosReiniciardispositivos\ndispositivos\nReiniciarKiosco\nSalir|

#************************************** MODIFICAR PANTALLA ****************************************
#  Scenario Outline: modificar pantallas
#    When se modifican pantallas "28", "<Text>", "0.74", "7"
#    Examples:
#      |       Text          |
#      |\nBancolombia\nModosupervisor\nIngresatusdatos\nUsuariodered\nContraseñadered\nSiguiente|