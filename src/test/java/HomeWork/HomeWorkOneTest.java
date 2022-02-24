package HomeWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
        String username = "Mariya";
        driver.findElement(By.id("firstName")).sendKeys(username);

        String lastName = "Loseva";
        driver.findElement(By.id("lastName")).sendKeys(lastName);

        String userEmail = "manya-cat@rambler.ru";
        driver.findElement(By.id("userEmail")).sendKeys(userEmail);

        WebElement testingRadioButton = driver.findElement(By.cssSelector("#genterWrapper div[class='custom-control custom-radio custom-control-inline']:nth-child(2)"));
        testingRadioButton.click();

        String userNumber = "9998889988";
        driver.findElement(By.id("userNumber")).sendKeys(userNumber);


        WebElement dataTest = driver.findElement(By.id("dateOfBirthInput"));
        dataTest.click();
        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        Select select1 = new Select(yearDropdown);
        select1.selectByVisibleText("1986");
        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        Select select2 = new Select(monthDropdown);
        select2.selectByIndex(6);
        driver.findElement(By.xpath("//*[text()='19']")).click();

        driver.findElement(By.id("submit")).sendKeys(Keys.ENTER);

        WebElement studentNam = driver.findElement(By.xpath("//*[contains(@class,'table')]//tr[1]//td[2]"));
        String studentName = studentNam.getText();
        Assertions.assertEquals(username + ' ' + lastName, studentName);

        WebElement studentEmail = driver.findElement(By.xpath("//*[contains(@class,'table')]//tr[2]//td[2]"));
        String studentMail = studentEmail.getText();
        Assertions.assertEquals(userEmail, studentMail);

        WebElement askGender = driver.findElement(By.xpath("//*[contains(@class,'table')]//tr[3]//td[2]"));
        String gender = askGender.getText();
        Assertions.assertTrue(gender.contains("Female"));

        WebElement phone = driver.findElement(By.xpath("//*[contains(@class,'table')]//tr[4]//td[2]"));
        String mobile = phone.getText();
        Assertions.assertEquals(userNumber, mobile);

        WebElement dataOfBirt = driver.findElement(By.xpath("//*[contains(@class,'table')]//tr[5]//td[2]"));
        String dataOfBirth = dataOfBirt.getText();
        Assertions.assertTrue(dataOfBirth.contains("19 July,1986"));

        Thread.sleep(2000);
    }

    @AfterEach
    public void tearDown() {

        driver.quit();
    }
}

