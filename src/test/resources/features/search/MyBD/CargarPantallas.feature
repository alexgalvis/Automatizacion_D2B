Feature: Cargar pantallas en base de datos

  Scenario: se guardan pantallas
    When se cargan pantallas de la ruta "C:\\Users\\Alex Duban Galvis\\Documents\\CELULA KIOSCO\AUTOMATIZACIONES\\Pantallas\\" y flujo "7"
    Then se listan pantallas guardadas


  Scenario: listar pantallas por tipo de flujo
    When se listan las pantallas del flujo "7"