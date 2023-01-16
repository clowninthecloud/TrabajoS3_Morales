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

public class NormalDebitoMastercardDomestica {
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
  public void testNormalDebitoMastercardDomestica() throws Exception {
    driver.get("https://web1qa.test.transbank.cl:5443/RestStoreWebPay/");
    driver.findElement(By.xpath("//a[contains(text(),'Tienda\n                    normal')]")).click();
    driver.findElement(By.name("apiversion")).click();
    new Select(driver.findElement(By.name("apiversion"))).selectByVisibleText("v1.2/");
    driver.findElement(By.xpath("//*/text()[normalize-space(.)='']/parent::*")).click();
    driver.findElement(By.id("amount")).clear();
    driver.findElement(By.id("amount")).sendKeys("3333");
    driver.findElement(By.xpath("//input[@value='Continuar']")).click();
    driver.findElement(By.xpath("//input[@value='Continuar »']")).click();
    Thread.sleep(2000);//para que no vaya tan rapido
    driver.findElement(By.xpath("//button[@id='tarjetas']/div[2]")).click();
    driver.findElement(By.id("card-number")).click();
    driver.findElement(By.id("card-number")).clear();
    driver.findElement(By.id("card-number")).sendKeys("5298 8398 0240 6810");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Número de tarjeta'])[1]/following::button[1]")).click();
    Thread.sleep(2000);//para que no vaya tan rapido
    driver.findElement(By.id("card-exp")).click();
    driver.findElement(By.id("card-exp")).clear();
    driver.findElement(By.id("card-exp")).sendKeys("1222");
    driver.findElement(By.id("card-cvv")).click();
    driver.findElement(By.id("card-cvv")).clear();
    driver.findElement(By.id("card-cvv")).sendKeys("123");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Otra cantidad'])[1]/following::button[1]")).click();
    Thread.sleep(5000);//para que no vaya tan rapido
    driver.findElement(By.name("rut")).clear();
    driver.findElement(By.name("rut")).sendKeys("10726100-1");
    driver.findElement(By.name("clave")).clear();
    driver.findElement(By.name("clave")).sendKeys("tbk.2020");
    driver.findElement(By.xpath("//input[@value='Aceptar']")).click();
    driver.findElement(By.xpath("//input[@value='Seguir (setResultAut)']")).click();
    driver.findElement(By.xpath("//input[@value='Seguir (retorno a Transbank)']")).click();
    Thread.sleep(4000);//para que no vaya tan rapido
    driver.findElement(By.name("apiversion")).click();
    new Select(driver.findElement(By.name("apiversion"))).selectByVisibleText("v1.2/");
    driver.findElement(By.xpath("//input[@value='Continuar »']")).click();
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
