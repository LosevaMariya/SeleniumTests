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

public class FormTestsDraft {

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
    public void inputFirstNameTest() throws InterruptedException {
        driver.findElement(By.id("firstName")).sendKeys("Mariya");
        Thread.sleep(2000);
    }

    @Test
    public void inputLastNameTest() throws InterruptedException {
        driver.findElement(By.id("lastName")).sendKeys("Loseva");
        Thread.sleep(2000);
    }

    @Test
    public void inputEmailTest() throws InterruptedException {
        driver.findElement(By.id("userEmail")).sendKeys("manya-cat@rambler.ru");
        Thread.sleep(2000);
    }

    @Test
    public void radioButtonTest() throws InterruptedException {
        WebElement testingRadioButton = driver.findElement(By.cssSelector("input[name='gender'][value='Female']"));
        testingRadioButton.click();

//        System.out.print("Gender: " + testingRadioButton);
//        driver.findElement(By.id("gender-radio-2")).click();

        Thread.sleep(2000);
    }

    @Test
    public void inputMobileTest() throws InterruptedException {
        driver.findElement(By.id("userNumber")).sendKeys("9998889988");
        Thread.sleep(2000);
    }

    @Test
    public void dadeOfBirthTest() throws InterruptedException {
        WebElement dataTest = driver.findElement(By.id("dateOfBirthInput"));
        dataTest.click();
        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        Select select1 = new Select(yearDropdown);
        select1.selectByVisibleText("1986");
        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        Select select2 = new Select(monthDropdown);
        select2.selectByIndex(6);
        driver.findElement(By.xpath("//*[text()='19']")).click();

//        List<WebElement> allOptions = select1.getOptions();
//        Assertions.assertEquals("1986", allOptions.get(yearDropdown));
//        List<WebElement> allOptions1 = select2.getOptions();
//        Assertions.assertEquals("July", allOptions1.get(6).getText());

//        System.out.print(allOptions.get(0).getText());
        Thread.sleep(2000);
    }

    @AfterEach
    public void tearDown() {

        driver.quit();
    }
}
