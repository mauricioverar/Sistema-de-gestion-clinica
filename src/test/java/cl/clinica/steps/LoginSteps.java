package cl.clinica.steps;

import org.junit.jupiter.api.Assertions;

import cl.clinica.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
LoginPage loginPage;

  @Given("que el médico abre la página de login")
  public void  que_el_médico_abre_la_página_de_login() {
    loginPage = new LoginPage();
    loginPage.abrir();
  }

  @When("ingresa credenciales válidas")
  public void ingresa_credenciales_válidas() {
    loginPage = new LoginPage();
    loginPage.login("doctor", "password");
  }

  @Then("accede al registro de paciente")
  public void accede_al_registro_de_paciente() {
    loginPage = new LoginPage();
    Assertions.assertTrue(loginPage.obtenerError().isEmpty(), "No debería haber un mensaje de error");
  }

  @When("ingresa credenciales inválidas")
  public void ingresa_credenciales_inválidas() {
    loginPage = new LoginPage();
    loginPage.login("otro", "123456");
  }

  @Then("ve un mensaje de error de login")
  public void ve_un_mensaje_de_error_de_login() {
    loginPage = new LoginPage();
    Assertions.assertTrue(loginPage.obtenerError().contains("inválidas"), "Debe mostrar mensaje de credenciales inválidas");
  }
}

// mvn "-Dcucumber.filter.tags=@login" test