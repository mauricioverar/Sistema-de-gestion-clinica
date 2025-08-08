@ficha
Feature: Carga de ficha clínica
  Scenario: Ingreso de ficha clínica completa
    Given que el médico accede al formulario de ficha clínica
    When ingresa el nombre del paciente diagnóstico edad y tratamiento
    And envía el formulario
    Then ve un mensaje de confirmación de ficha registrada con éxito
  Scenario: Ficha clínica incompleta
    Given que el médico accede al formulario de ficha clínica
    When ingresa solo el nombre diagnóstico y edad
    Then ve un mensaje de error indicando que el tratamiento es obligatorio