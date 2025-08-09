package cl.clinica.steps;

import org.junit.jupiter.api.Assertions;

import cl.clinica.pages.FichaPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FichaSteps {
  FichaPage fichaPage;

  @Given("que el médico accede al formulario de ficha clínica")
  public void que_el_médico_accede_al_formulario_de_ficha_clínica() {
    fichaPage = new FichaPage();
    fichaPage.abrir();
  }

  @When("ingresa el nombre del paciente diagnóstico edad y tratamiento")
  public void ingresa_el_nombre_del_paciente_diagnóstico_edad_y_tratamiento() {
    fichaPage = new FichaPage();
    fichaPage.fichaPage("Pedro Pablo", "dolor de cabeza", "33", "aspirina");
  }

  @Then("ve un mensaje de confirmación de ficha registrada con éxito")
  public void ve_un_mensaje_de_confirmación_de_ficha_registrada_con_éxito() {
    fichaPage = new FichaPage();
    Assertions.assertTrue(
        fichaPage.obtenerMensajeExitoso().contains("éxito"), "Debe mostrar mensaje Ficha registrada con éxito");
  }

  // reglas

  @When("ingresa una edad menor a 12 años")
  public void ingresa_una_edad_menor_a_12_años() {
    fichaPage = new FichaPage();
    fichaPage.fichaPage("Pedro Pablo", "", "11", "aspirina");
  }

  @Then("ve un mensaje que indica que el diagnóstico debe ser Pediátrico")
  public void ve_un_mensaje_que_indica_que_el_diagnóstico_debe_ser_Pediátrico() {
    fichaPage = new FichaPage();
    Assertions.assertTrue(
        fichaPage.obtenerMensajeError().contains("Pediátrico"), "Debe mostrar mensaje Para menores de 12 años, el diagnóstico debe ser \"Pediátrico\".");
  }

  @When("deja el campo de tratamiento vacío")
  public void deja_el_campo_de_tratamiento_vacío() {
    fichaPage = new FichaPage();
    fichaPage.fichaPage("Pedro Pablo", "dolor de cabeza", "33", "");
  }

  @Then("ve un mensaje de error indicando que el tratamiento es obligatorio")
  public void ve_un_mensaje_de_error_indicando_que_el_tratamiento_es_obligatorio() {
    fichaPage = new FichaPage();
    Assertions.assertTrue(fichaPage.obtenerMensajeError().contains("obligatorio "),
        "Debe mostrar mensaje El tratamiento es obligatorio para guardar la ficha.");
  }
}
