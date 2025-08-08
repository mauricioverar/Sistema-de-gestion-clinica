package cl.clinica.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cl.clinica.hooks.DriverHolder;

public class FichaPage {

  private By nombreInput = By.id("nombre");
  private By diagnosticoInput = By.id("diagnostico");
  private By edadInput = By.id("edad");
  private By tratamientoInput = By.id("tratamiento");
  private By guardarButton = By.xpath("//form[@id=\"record-form\"]//button[@type='submit']");
  private By mensajeExitoso = By.xpath("//div[@id=\"record-message\"]//div[@class='alert alert-success']");
  private By mensajeError = By.xpath("//div[@id=\"record-message\"]/div/ul/li[2]");

  private WebDriver getDriver() {
    return DriverHolder.get();
  }

  public void abrir() {
    getDriver().get("https://clinica-modular.netlify.app/ficha.html");
  }

  public void fichaPage(String nombre, String diagnostico, String edad, String tratamiento) {

    WebDriver driver = getDriver();

    driver.findElement(nombreInput).sendKeys(nombre);
    driver.findElement(diagnosticoInput).sendKeys(diagnostico);
    driver.findElement(edadInput).sendKeys(edad);
    driver.findElement(tratamientoInput).sendKeys(tratamiento);
  }

  public void enviarFormulario() {
    WebDriver driver = getDriver();
    driver.findElement(guardarButton).click();
  }

  public String obtenerMensajeExitoso() {
    List<WebElement> message = getDriver().findElements(mensajeExitoso);
    return message.isEmpty() ? "" : message.get(0).getText().trim();
  }
  
  public String obtenerError() {
    List<WebElement> messageErrors = getDriver().findElements(mensajeError);
    return messageErrors.isEmpty() ? "" : messageErrors.get(0).getText().trim();
  }
  
}
