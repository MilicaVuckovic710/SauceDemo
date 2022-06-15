import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertEquals;

public class SauceDemoTest {
    private static final WebDriverManager wdm = new ChromeDriverManager();
    private static WebDriver driver;
    private static WebDriverWait wdwait;


    @BeforeTest
    public void beforeTest() {
        wdm.setup();
        driver = new ChromeDriver();
        wdwait = new WebDriverWait(driver, Duration.ofSeconds(10));
        //driver.navigate().to("https://www.saucedemo.com/");
    }

    @BeforeMethod
    public void setUp() {
        driver.manage().window().maximize();
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test //(enabled = false)
    public void invalidLogIn() {
        WebElement userNameInput = driver.findElement(new By.ById("user-name"));
        wdwait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.click();
        userNameInput.sendKeys("user");
        WebElement passwordInput = driver.findElement(new By.ById("password"));
        wdwait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        passwordInput.click();
        passwordInput.sendKeys("user");
        WebElement loginButton = driver.findElement(new By.ById("login-button"));
        wdwait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(new By.ByCssSelector("#login_button_container > div > form > div.error-message-container.error > h3"))));
        WebElement msgErrorContainer = driver.findElement(new By.ByCssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        msgErrorContainer.getText();
        System.out.println(msgErrorContainer.getText());
        assertEquals(msgErrorContainer.getText(), "Epic sadface: Username and password do not match any user in this service");
        msgErrorContainer.findElement(new By.ByCssSelector("#login_button_container > div > form > div.error-message-container.error > h3 > button > svg > path")).click();
    }

    @Test //(enabled = false)
    public void logIn()   {
        WebElement userNameInput = driver.findElement(new By.ById("user-name"));
        userNameInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.click();
        String userName = driver.findElement(new By.ById("login_credentials")).getText();
        System.out.println(userName);
        String[] userNames = userName.split("\n");
        for (String s : userNames) {
            if (s.equals("standard_user")){
             userName = s;
                break;

           }
        }
        userNameInput.sendKeys(userName);
        WebElement passwordInput = driver.findElement(new By.ById("password"));
        passwordInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        String password = driver.findElement(new By.ByClassName("login_password")).getText();
        System.out.println(password);
        String[] passwords = password.split("\n");
        for (String s : passwords) {
            if (s.equals("secret_sauce")){
                password = s;
                break;

            }
        }
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(new By.ById("login-button"));
        wdwait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        wdwait.until(ExpectedConditions.invisibilityOfAllElements());
        WebElement productTitle = driver.findElement(new By.ByClassName("title"));
        System.out.println(productTitle+ " " + productTitle.getText()); //da ispise koji text izlazi
        assertEquals(productTitle.getText(), "PRODUCTS");



    }

    @Test //(enabled = false)
    public void logIn1()  {
        WebElement userNameInput = driver.findElement(new By.ById("user-name"));
        userNameInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.click();
        String userName = driver.findElement(new By.ById("login_credentials")).getText();
        System.out.println(userName);
        String[] userNames = userName.split("\n");
        for (String s : userNames) {
            if (s.equals("problem_user")){
                userName = s;
                break;

            }
        }
        wdwait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.sendKeys(userName);
        WebElement passwordInput = driver.findElement(new By.ById("password"));
        passwordInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        String password = driver.findElement(new By.ByClassName("login_password")).getText();
        System.out.println(password);
        String[] passwords = password.split("\n");
        for (String s : passwords) {
            if (s.equals("secret_sauce")){
                password = s;
                break;

            }
        }
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(new By.ById("login-button"));
        loginButton.click();
        wdwait.until(ExpectedConditions.invisibilityOfAllElements());
        WebElement productTitle = driver.findElement(new By.ByClassName("title"));
        System.out.println(productTitle+ " " + productTitle.getText()); //da ispise koji text izlazi
        assertEquals(productTitle.getText(), "PRODUCTS");


    }

    @Test //(enabled = false)
    public void logIn2() {
        WebElement userNameInput = driver.findElement(new By.ById("user-name"));
        userNameInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.click();
        String userName = driver.findElement(new By.ById("login_credentials")).getText();
        System.out.println(userName);
        String[] userNames = userName.split("\n");
        for (String s : userNames) {
            if (s.equals("performance_glitch_user")){
                userName = s;
                break;

            }
        }
        wdwait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.sendKeys(userName);
        WebElement passwordInput = driver.findElement(new By.ById("password"));
        passwordInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        String password = driver.findElement(new By.ByClassName("login_password")).getText();
        System.out.println(password);
        String[] passwords = password.split("\n");
        for (String s : passwords) {
            if (s.equals("secret_sauce")){
                password = s;
                break;

            }
        }
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(new By.ById("login-button"));
        loginButton.click();
        wdwait.until(ExpectedConditions.invisibilityOfAllElements());
        WebElement productTitle = driver.findElement(new By.ByClassName("title"));
        System.out.println(productTitle+ " " + productTitle.getText()); //da ispise koji text izlazi
        assertEquals(productTitle.getText(), "PRODUCTS");

    }
    @Test //(enabled = false)
    public void lockedInLogIn() {
        WebElement userNameInput = driver.findElement(new By.ById("user-name"));
        wdwait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.click();
        String userName = driver.findElement(new By.ById("login_credentials")).getText();
        System.out.println(userName);
        String[] userNames = userName.split("\n");
        for (String s : userNames) {
            if (s.equals("locked_out_user")){
                userName = s;
                break;

            }
        }
        wdwait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.sendKeys(userName);
        WebElement passwordInput = driver.findElement(new By.ById("password"));
        passwordInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        String password = driver.findElement(new By.ByClassName("login_password")).getText();
        System.out.println(password);
        String[] passwords = password.split("\n");
        for (String s : passwords) {
            if (s.equals("secret_sauce")){
                password = s;
                break;

            }
        }
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(new By.ById("login-button"));
        loginButton.click();
        wdwait.until(ExpectedConditions.visibilityOf(driver.findElement(new By.ByCssSelector("#login_button_container > div > form > div.error-message-container.error > h3"))));
        WebElement msgErrorContainer = driver.findElement(new By.ByCssSelector("#login_button_container > div > form > div.error-message-container.error > h3"));
        msgErrorContainer.getText();
        System.out.println(msgErrorContainer.getText());
        assertEquals(msgErrorContainer.getText(), "Epic sadface: Sorry, this user has been locked out.");
        msgErrorContainer.findElement(new By.ByCssSelector("#login_button_container > div > form > div.error-message-container.error > h3 > button > svg > path")).click();
    }





        @AfterTest
        public void cleanup () throws InterruptedException {
           Thread.sleep(5000);
           driver.close();


        }
    }


