@login
Feature: Login médico
  Scenario: Login exitoso
    Given que el médico abre la página de login
    When ingresa credenciales válidas
    Then accede al registro de paciente
  Scenario: Login fallido
    Given que el médico abre la página de login
    When ingresa credenciales inválidas
    Then ve un mensaje de error de login