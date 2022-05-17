package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
//import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.text.DateFormat;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.regex.Pattern;

public class TestSuit {
    protected static WebDriver driver;

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        System.setProperty("WebDriver.chrome.driver", "src/test/java/driver/chromedriver ");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        openTheURl();
        // driver.get("https://demo.nopcommerce.com/");
        clickButton(By.className("ico-register"));
        //driver.findElement(By.className("ico-register")).click();
        typeText(By.xpath("//input[@name='FirstName']"), "Hello");
        //driver.findElement(By.xpath("//input[@name='FirstName']")).sendKeys("MyFirstname");
        typeText(By.xpath("//input[@name='LastName']"), "Hi");
        //driver.findElement(By.xpath("//input[@name='LastName']")).sendKeys("MyLastname");
        typeText(By.id("Email"), "jask183@mail.com");
//driver.findElement(By.id("Email")).sendKeys("first.last21@mail.com");
        driver.findElement(By.name("Password")).sendKeys("1234@6");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("1234@6");
//driver.findElement(By.name("register-button")).click();
        clickButton(By.name("register-button"));
        String expectedMessage = "Your registration completed";
        String actualMessage = driver.findElement(By.className("result")).getText();
        if (expectedMessage.equals(actualMessage)) {
            System.out.println("Your registration completed");

        }
        driver.quit();
    }

    public static void openTheURl() {
        driver.get("https://demo.nopcommerce.com/");
    }

    public static void clickButton(By by) {
        driver.findElement(by).click();
    }

    public static void typeText(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    public static String randomDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("ddmmyyyyHHmmss");
        return formatter.format(DateFormat.DEFAULT);
    }

    public static void driverWaitsUntil(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeClickable(by)).click();
    }

    public static void driverWaitUrl(int time, String url) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlToBe(url));
    }

    public static String getText(By by) {
        return driver.findElement(by).getText();
    }

    public static void presenceOfElement(By by, int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public static void driverUrlContains(int time, String URLContains) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.urlContains(URLContains));
    }

    public static void titleContains(int time, String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.titleContains(title));
    }

    public static void invisibilityOfElement(int time, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public static void alertPresent(int time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    public static void atributeToBe(int time, By by, String atribute, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBe(by, atribute, value));
    }

    public static void tillAttributeNotEmpty(int time, WebElement element, String attribute) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.attributeToBeNotEmpty(element, attribute));
    }

    public static void elementToBeSelected(int time, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.elementToBeSelected(element));
    }

    public static void textToBe(int time, By by, String value) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textToBe(by, value));
    }

    public static void textToBeMatch(int time, By by, Pattern pattern) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.textMatches(by, pattern));
    }

    public static void domAttributeToBe(int time, String value, WebElement element, String attribute) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
        wait.until(ExpectedConditions.domAttributeToBe(element, attribute, value));
    }
}
