@login
Feature: Inicio de sesión de médico

  Scenario: Validar login con credenciales válidas
    Given que el médico abre la página de login
    When ingresa credenciales válidas
    Then accede al registro de paciente
    
  Scenario: Validar mensaje de error con credenciales inválidas
    Given que el médico abre la página de login
    When ingresa credenciales inválidas
    Then ve un mensaje de error de login