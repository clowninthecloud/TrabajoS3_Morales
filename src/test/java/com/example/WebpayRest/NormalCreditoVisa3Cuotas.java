package com.example.WebpayRest;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import static org.testng.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.io.File;
import org.apache.commons.io.FileUtils;

public class NormalCreditoVisa3Cuotas {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private final StringBuffer verificationErrors = new StringBuffer();
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
  public void testNormalCreditoVisa3Cuotas() throws Exception {
    driver.get("https://web1qa.test.transbank.cl:5443/ewebpay/jsf/welcome.jsf");
    driver.findElement(By.xpath("//button[@id='j_idt8:j_idt11']/span")).click();
    driver.findElement(By.xpath("//button[@id='ewebpayTestForm:j_idt32']/span")).click();
    Thread.sleep(4000);//para que no vaya tan rapido
    driver.findElement(By.xpath("//button[@id='tarjetas']/div[2]")).click();
    driver.findElement(By.id("card-number")).click();
    driver.findElement(By.id("card-number")).clear();
    driver.findElement(By.id("card-number")).sendKeys("4455 9638 0766 4298");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Número de tarjeta'])[1]/following::button[1]")).click();
    Thread.sleep(2000);//para que no vaya tan rapido
    driver.findElement(By.id("card-exp")).click();
    driver.findElement(By.id("card-exp")).clear();
    driver.findElement(By.id("card-exp")).sendKeys("1223");
    driver.findElement(By.id("card-cvv")).click();
    driver.findElement(By.id("card-cvv")).clear();
    driver.findElement(By.id("card-cvv")).sendKeys("123");
    driver.findElement(By.id("botonlistacuotas0")).click();
    Thread.sleep(4000);//para que no vaya tan rapido
    driver.findElement(By.xpath("//button[@value='3']")).click();
    Thread.sleep(2000);//para que no vaya tan rapido
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='(Sin interés)'])[1]/following::button[1]")).click();
    Thread.sleep(4000);//para que no vaya tan rapido
    driver.findElement(By.name("rut")).clear();
    driver.findElement(By.name("rut")).sendKeys("10726100-1");
    driver.findElement(By.name("clave")).clear();
    driver.findElement(By.name("clave")).sendKeys("tbk.2020");
    driver.findElement(By.xpath("//input[@value='Aceptar']")).click();
    driver.findElement(By.xpath("//input[@value='Seguir (setResultAut)']")).click();
    driver.findElement(By.xpath("//input[@value='Seguir (retorno a Transbank)']")).click();
    Thread.sleep(2000);//para que no vaya tan rapido
    WebDriverWait wait = new WebDriverWait(driver,30); //Este si me funciono bien
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='j_idt47:j_idt52']/span"))).click();
    Thread.sleep(4000);

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
