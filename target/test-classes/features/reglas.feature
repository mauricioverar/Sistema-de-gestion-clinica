@reglas
Feature: Validación de reglas clínicas

  Scenario: Diagnóstico para pacientes pediátricos
    Given que el médico accede al formulario de ficha clínica
    When ingresa una edad menor a 12 años
    Then ve un mensaje que indica que el diagnóstico debe ser Pediátrico
    
  Scenario: Impedir guardado sin tratamiento
    Given que el médico accede al formulario de ficha clínica
    When deja el campo de tratamiento vacío
    Then ve un mensaje de error indicando que el tratamiento es obligatorio