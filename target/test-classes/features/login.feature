@login
Feature: Inicio de sesión de médico

  Scenario Outline: Validar login con diferentes credenciales
    Given que el médico abre la página de login
    When ingresa el usuario "<usuario>" y la contraseña "<clave>"
    Then <resultado>

    Examples:
      | usuario | clave     | resultado                                |
      | doctor  | password  | accede al registro de paciente           |
      | otro    | 123456    | ve un mensaje de error de login          |