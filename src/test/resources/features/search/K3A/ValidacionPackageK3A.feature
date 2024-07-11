Feature: Validación de archivos JSON
  Como usuario
  Quiero validar archivos JSON
  Para asegurarme de que cumplen con los criterios especificados


  Scenario: Validar la estructura de varios archivos JSON
    Given tengo los siguientes archivos JSON:
      | kiosk.json |
      | endpoints.json |
    When analizo los archivos JSON
    Then la estructura de cada JSON debe ser válida