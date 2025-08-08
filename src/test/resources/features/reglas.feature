@reglas
Feature: Validación de reglas clínicas
  Scenario: Diagnóstico automático para pacientes pediátricos
    Given que el médico accede al formulario de ficha clínica
    When ingresa una edad menor a 12 años
    Then el diagnóstico se establece automáticamente como "Pediátrico"
  Scenario: Impedir guardado sin tratamiento
    Given que el médico accede al formulario de ficha clínica
    When deja el campo de tratamiento vacío
    And intenta guardar la ficha
    Then ve un mensaje que indica que no se puede guardar sin tratamiento