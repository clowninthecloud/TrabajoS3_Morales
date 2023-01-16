package com.example.WebpayRest;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.testng.Assert.fail;


public class NormalDebitMastercardDomestica {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  private JavascriptExecutor js;

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "D:\\TBK\\Automatizacion\\src\\test\\resources\\windows\\chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
   // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    js = (JavascriptExecutor) driver;
    driver.manage().window().maximize();
  }

  @Test
  public void testNormalDebitMastercardDomestica() throws Exception {
    driver.get("https://web1qa.test.transbank.cl:5443/ewebpay/jsf/welcome.jsf");
    driver.findElement(By.xpath("//button[@id='j_idt8:j_idt11']/span")).click();
    driver.findElement(By.xpath("//form[@id='ewebpayTestForm']/table/tbody/tr[3]")).click();
    driver.findElement(By.id("ewebpayTestForm:ewptdAmount")).clear();
    driver.findElement(By.id("ewebpayTestForm:ewptdAmount")).sendKeys("1111");
    Thread.sleep(2000);//para que no vaya tan rapido
    driver.findElement(By.xpath("//button[@id='ewebpayTestForm:j_idt32']/span")).click();
    Thread.sleep(4000);//para que no vaya tan rapido
    driver.findElement(By.xpath("//button[@id='tarjetas']/div[2]")).click();
    driver.findElement(By.id("card-number")).click();
    driver.findElement(By.id("card-number")).clear();
    driver.findElement(By.id("card-number")).sendKeys("5203 7200 0000 0007");
    Thread.sleep(2000);
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Número de tarjeta'])[1]/following::button[1]")).click();
    Thread.sleep(2000);
    driver.findElement(By.id("card-dni")).click();
    driver.findElement(By.id("card-dni")).clear();
    driver.findElement(By.xpath("//input[@id='card-dni']")).sendKeys("11.111.111-1");
    Thread.sleep(2000);
    driver.findElement(By.xpath("//button[contains(text(),'Pagar')]")).click();
   // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Aceptar']"))).click();
    Thread.sleep(4000);
    driver.findElement(By.name("rut")).clear();
    driver.findElement(By.name("rut")).sendKeys("10726100-1");
    driver.findElement(By.name("clave")).clear();
    driver.findElement(By.name("clave")).sendKeys("tbk.2020");
    driver.findElement(By.xpath("//input[@value='Aceptar']")).click();
    driver.findElement(By.xpath("//input[@value='Seguir (setResultAut)']")).click();
    driver.findElement(By.xpath("//input[@value='Seguir (retorno a Transbank)']")).click();
    Thread.sleep(4000);//para que no vaya tan rapido
    driver.findElement(By.xpath("//button[@id='j_idt47:j_idt52']/span")).click();
    Thread.sleep(4000);//para que no vaya tan rapido
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
