package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

public class HomeWorkOneTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {

        String browser = System.getProperty("browser");

        if (browser.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browser.equals("opera")) {
            WebDriverManager.operadriver().setup();
            driver = new OperaDriver();
        }

        driver.get("https://demoqa.com/automation-practice-form");
        driver.manage().window().maximize();
    }

    @Test
    public void checkCurrentUrl() throws InterruptedException {
        Assertions.assertEquals("https://demoqa.com/automation-practice-form", driver.getCurrentUrl());
        Thread.sleep(2000);
    }

    @Test
    public void FormTest() throws InterruptedException {
        driver.findElement(By.id("firstName")).sendKeys("Mariya");
        driver.findElement(By.id("lastName")).sendKeys("Loseva");
        driver.findElement(By.id("userEmail")).sendKeys("manya-cat@rambler.ru");
//не хватает клика на гендер

        driver.findElement(By.id("userNumber")).sendKeys("9998889988");
        WebElement dataTest = driver.findElement(By.id("dateOfBirthInput"));
        dataTest.click();
        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        Select select1 = new Select(yearDropdown);
        select1.selectByVisibleText("1986");
        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        Select select2 = new Select(monthDropdown);
        select2.selectByIndex(6);
        driver.findElement(By.xpath("//*[text()='19']")).click();


        Thread.sleep(2000);
    }


    @AfterEach
    public void tearDown() {

        driver.quit();
    }
}

