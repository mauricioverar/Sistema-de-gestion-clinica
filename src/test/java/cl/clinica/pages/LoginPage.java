package cl.clinica.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cl.clinica.hooks.DriverHolder;

public class LoginPage {

  private By username = By.id("username");
  private By password = By.id("password");
  private By btnLogin = By.xpath("//form[@id='login-form']//button[@type='submit']");
  private By messageError = By.xpath("//div[@id=\"login-message\"]//div[@class='alert alert-danger']");

  private WebDriver getDriver() {
    return DriverHolder.get();
  }

  public void abrir() {
    getDriver().get("https://clinica-modular.netlify.app/");
  }

  public void login(String usuario, String clave) {
    WebDriver driver = getDriver();
    driver.findElement(username).sendKeys(usuario);
    driver.findElement(password).sendKeys(clave);
    driver.findElement(btnLogin).click();
  }

  public String obtenerError() {
    List<WebElement> messageErrors = getDriver().findElements(messageError);
    return messageErrors.isEmpty()?"": messageErrors.get(0).getText().trim();
  }
}
