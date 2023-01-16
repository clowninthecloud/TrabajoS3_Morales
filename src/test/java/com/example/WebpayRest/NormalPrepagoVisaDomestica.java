package com.example.WebpayRest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class NormalPrepagoVisaDomestica {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testNormalPrepagoVisaDomestica() throws Exception {
    driver.get("https://web1qa.test.transbank.cl:5443/ewebpay/jsf/welcome.jsf");
    driver.findElement(By.xpath("//button[@id='j_idt8:j_idt11']/span")).click();
    driver.findElement(By.id("j_idt19_content")).click();
    driver.findElement(By.id("ewebpayTestForm:ewptdAmount")).clear();
    driver.findElement(By.id("ewebpayTestForm:ewptdAmount")).sendKeys("8888");
    driver.findElement(By.xpath("//button[@id='ewebpayTestForm:j_idt32']/span")).click();
    driver.findElement(By.xpath("//button[@id='tarjetas']/div[2]/div")).click();
    driver.findElement(By.id("card-number")).click();
    driver.findElement(By.id("card-number")).clear();
    driver.findElement(By.id("card-number")).sendKeys("4670 1579 7056 7383");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Número de tarjeta'])[1]/following::button[1]")).click();
    driver.findElement(By.id("card-exp")).click();
    driver.findElement(By.id("card-exp")).clear();
    driver.findElement(By.id("card-exp")).sendKeys("12/23");
    driver.findElement(By.id("card-cvv")).click();
    driver.findElement(By.id("card-cvv")).clear();
    driver.findElement(By.id("card-cvv")).sendKeys("123");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='CVV'])[1]/following::button[3]")).click();
    driver.findElement(By.name("rut")).clear();
    driver.findElement(By.name("rut")).sendKeys("10726100-1");
    driver.findElement(By.name("clave")).clear();
    driver.findElement(By.name("clave")).sendKeys("tbk.2020");
    driver.findElement(By.xpath("//input[@value='Aceptar']")).click();
    driver.findElement(By.xpath("//input[@value='Seguir (setResultAut)']")).click();
    driver.findElement(By.xpath("//input[@value='Seguir (retorno a Transbank)']")).click();
    driver.findElement(By.xpath("//button[@id='j_idt47:j_idt52']/span")).click();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
