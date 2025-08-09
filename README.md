```markdown
# 🏥 Clínica Modular - Automatización de Pruebas

Este proyecto automatiza pruebas funcionales para la aplicación web [Clínica Modular](https://clinica-modular.netlify.app/) utilizando **Selenium WebDriver**, **JUnit 5**, y **Cucumber** con enfoque **BDD**. Las pruebas validan el flujo de login y el registro de fichas clínicas, incluyendo reglas de negocio específicas.

## 🚀 Tecnologías Utilizadas

- Java 17+
- Selenium WebDriver
- WebDriverManager
- JUnit 5
- Cucumber (Gherkin)
- Maven

## 📁 Estructura del Proyecto

```
src/
├── main/
│   └── java/
│       └── cl.clinica/

├── test/
│   └── java/
│       └── cl.clinica/
│           ├── hooks/         # Manejo de WebDriver (DriverHolder, Hooks)
│           ├── pages/         # Page Objects (LoginPage, FichaPage)
│           ├── steps/         # Definición de pasos Gherkin (LoginSteps, FichaSteps)
│           └── RunCucumberTest.java
resources/
└── features/                  # Archivos .feature con escenarios BDD
```


## 🧪 Escenarios Gherkin

### 🟦 `@login` - Inicio de sesión de médico

```gherkin
Feature: Inicio de sesión de médico

Scenario Outline: Validar login con diferentes credenciales
  Given que el médico abre la página de login
  When ingresa el usuario "<usuario>" y la contraseña "<clave>"
  Then <resultado>

  Examples:
    | usuario | clave     | resultado                                |
    | doctor  | password  | accede al registro de paciente           |
    | otro    | 123456    | ve un mensaje de error de login          |


🟩 @ficha - Carga de ficha clínic

Feature: Carga de ficha clínica

  Scenario: Ingreso de ficha clínica completa
    Given que el médico accede al formulario de ficha clínica
    When ingresa el nombre del paciente diagnóstico edad y tratamiento
    Then ve un mensaje de confirmación de ficha registrada con éxito


🟥 @reglas - Validación de reglas clínica

Feature: Validación de reglas clínicas

  Scenario: Diagnóstico para pacientes pediátricos
    Given que el médico accede al formulario de ficha clínica
    When ingresa una edad menor a 12 años
    Then ve un mensaje que indica que el diagnóstico debe ser Pediátrico

  Scenario: Impedir guardado sin tratamiento
    Given que el médico accede al formulario de ficha clínica
    When deja el campo de tratamiento vacío
    Then ve un mensaje de error indicando que el tratamiento es obligatorio


## 🧪 Escenarios Cubiertos

### Login
- ✅ Acceso exitoso con credenciales válidas
- ❌ Mensaje de error con credenciales inválidas

### Ficha Clínica
- ✅ Registro exitoso de ficha
- ❌ Validación de diagnóstico pediátrico para menores de 12 años
- ❌ Validación de campo obligatorio para tratamiento

## 🧷 Hooks y Gestión de Driver

Se utiliza `ThreadLocal<WebDriver>` para garantizar aislamiento entre escenarios. Los hooks (`@Before`, `@After`) inicializan y cierran el navegador, capturando screenshots en caso de fallo.

## 🧾 Ejecución de Pruebas

```bash
mvn test
```

El reporte HTML se genera en:

```
target/cucumber-report.html
```

## 🧠 Buenas Prácticas

- Uso de Page Object Model (POM) para encapsular interacciones
- Modularidad con `DriverHolder` para gestión centralizada del WebDriver
- Separación clara entre lógica de prueba y definición de pasos

## 📌 Requisitos Previos

- Java 17+
- Maven instalado
- Conexión a internet (para WebDriverManager)

## 👨‍💻 Autor

Desarrollado por Mauricio — especialista en automatización, diseño modular y pruebas escalables.

```

