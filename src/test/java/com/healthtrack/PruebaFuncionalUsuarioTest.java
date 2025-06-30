package com.healthtrack;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PruebaFuncionalUsuarioTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); 
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");

        driver = new ChromeDriver(options);
        driver.get("https://www.selenium.dev/selenium/web/web-form.html");
    }

    @Test
    public void testFormulario() {
        WebElement textInput = driver.findElement(By.name("my-text"));
        textInput.sendKeys("Lucía");

        driver.findElement(By.cssSelector("button")).click();

        new WebDriverWait(driver, Duration.ofSeconds(5))
            .until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("h1"), "Form submitted"));

        WebElement heading = driver.findElement(By.tagName("h1"));
        assertEquals("Form submitted", heading.getText());
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
