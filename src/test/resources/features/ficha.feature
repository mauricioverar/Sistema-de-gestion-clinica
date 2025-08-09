@ficha
Feature: Carga de ficha clínica

  Scenario: Ingreso de ficha clínica completa
    Given que el médico accede al formulario de ficha clínica
    When ingresa el nombre del paciente diagnóstico edad y tratamiento
    Then ve un mensaje de confirmación de ficha registrada con éxito

