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
        String username = "Mariya";
        driver.findElement(By.id("firstName")).sendKeys("Mariya");
        Assertions.assertEquals("Mariya", username);

        String lastName = "Loseva";
        driver.findElement(By.id("lastName")).sendKeys("Loseva");
        Assertions.assertEquals("Loseva", lastName);

        String userEmail = "manya-cat@rambler.ru";
        driver.findElement(By.id("userEmail")).sendKeys("manya-cat@rambler.ru");
        Assertions.assertEquals("manya-cat@rambler.ru", userEmail);

        WebElement testingRadioButton = driver.findElement(By.cssSelector("#genterWrapper div[class='custom-control custom-radio custom-control-inline']:nth-child(2)"));
        testingRadioButton.click();  // проверку сделать не смогла, об этом сказала ещё в предыдущем письме

        driver.findElement(By.id("userNumber")).sendKeys("9998889988");
        String userNumber = "9998889988";
        driver.findElement(By.id("userNumber")).sendKeys("9998889988");
        Assertions.assertEquals("9998889988", userNumber);

        WebElement dataTest = driver.findElement(By.id("dateOfBirthInput"));
        dataTest.click();
        WebElement yearDropdown = driver.findElement(By.className("react-datepicker__year-select"));
        Select select1 = new Select(yearDropdown);
        select1.selectByVisibleText("1986");
        WebElement monthDropdown = driver.findElement(By.className("react-datepicker__month-select"));
        Select select2 = new Select(monthDropdown);
        select2.selectByIndex(6);
        driver.findElement(By.xpath("//*[text()='19']")).click();
//Проверку тут сделать тоже не смогла, пробовала как в лекции, но не получилось

//        List<WebElement> allOptions = select1.getOptions();
//        Assertions.assertEquals("1986", allOptions.get(yearDropdown));
//        List<WebElement> allOptions1 = select2.getOptions();
//        Assertions.assertEquals("July", allOptions1.get(6).getText());

        //    public void SubjectsTest() throws InterruptedException {
//        WebElement element = new JavascriptExecutor(driver.findElement(By));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//        element.sendKeys("Subject");
//        element.sendKeys(Keys.ENTER);
//1. Никак не могу создать локатор для этого поля. 2. Я не понмаю кусок этого кода, что он значит, и что может дать
// Чем больше делаю, тем больше понимаю, насколько бесполезно это без знания языка программирования.
// Я думаю, что не стоит мучать ни себя ни вас, мне непонятно от слова совсем! Всё, что было можно сделать по образу и
// подобию в лекции я сделала, но всё, что вы не показывали на лекции, сделать я не могу.
//
//
//        Thread.sleep(2000);
//    }
        Thread.sleep(2000);
    }


    @AfterEach
    public void tearDown() {

        driver.quit();
    }
}

