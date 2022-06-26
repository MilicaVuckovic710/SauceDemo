import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.List;

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
        String userNames = driver.findElement(new By.ById("login_credentials")).getText();
        System.out.println(userNames);
        String[] token = userNames.split("\n");
        String username = token[1]; //menjamo index za svaki sledeci string, ne treba for
        userNameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(new By.ById("password"));
        passwordInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        String passwords = driver.findElement(new By.ByClassName("login_password")).getText();
        System.out.println(passwords);
        String[] Token = passwords.split("\n");
        String password = Token[1];
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(new By.ById("login-button"));
        wdwait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        wdwait.until(ExpectedConditions.presenceOfElementLocated(new By.ByClassName("title")));
        WebElement productTitle = driver.findElement(new By.ByClassName("title"));
        System.out.println(productTitle+ " " + productTitle.getText());
        assertEquals(productTitle.getText(), "PRODUCTS");
    }

    @Test //(enabled = false)
    public void logIn1()  {
        WebElement userNameInput = driver.findElement(new By.ById("user-name"));
        userNameInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.click();
        String userNames = driver.findElement(new By.ById("login_credentials")).getText();
        System.out.println(userNames);
        String[] token = userNames.split("\n");
        String username = token[3];
        //wdwait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(new By.ById("password"));
        passwordInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        String passwords = driver.findElement(new By.ByClassName("login_password")).getText();
        System.out.println(passwords);
        String[] Token = passwords.split("\n");
        String password = Token[1];
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
        String userNames = driver.findElement(new By.ById("login_credentials")).getText();
        System.out.println(userNames);
        String[] token = userNames.split("\n");
        String username = token[4];
        //wdwait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(new By.ById("password"));
        passwordInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        String passwords = driver.findElement(new By.ByClassName("login_password")).getText();
        System.out.println(passwords);
        String[] Token = passwords.split("\n");
        String password = Token[1];
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
        String userNames = driver.findElement(new By.ById("login_credentials")).getText();
        System.out.println(userNames);
        String[] token = userNames.split("\n");
        String username = token[2];
        userNameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(new By.ById("password"));
        passwordInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        String passwords = driver.findElement(new By.ByClassName("login_password")).getText();
        System.out.println(passwords);
        String[] Token = passwords.split("\n");
        String password = Token[1];
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


    @Test (enabled = false)
    public void productSorting() {
        WebElement userNameInput = driver.findElement(new By.ById("user-name"));
        userNameInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(userNameInput));
        userNameInput.click();
        String userNames = driver.findElement(new By.ById("login_credentials")).getText();
        System.out.println(userNames);
        String[] token = userNames.split("\n");
        String username = token[4];
        userNameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(new By.ById("password"));
        passwordInput.clear();
        wdwait.until(ExpectedConditions.elementToBeClickable(passwordInput));
        passwordInput.click();
        String passwords = driver.findElement(new By.ByClassName("login_password")).getText();
        System.out.println(passwords);
        String[] Token = passwords.split("\n");
        String password = Token[1];
        passwordInput.sendKeys(password);
        WebElement loginButton = driver.findElement(new By.ById("login-button"));
        wdwait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
        wdwait.until(ExpectedConditions.invisibilityOfAllElements());
        WebElement productTitle = driver.findElement(new By.ByClassName("title"));
        System.out.println(productTitle + " " + productTitle.getText()); //da ispise koji text izlazi
        assertEquals(productTitle.getText(), "PRODUCTS");
        //List<WebElement> prices = driver.findElements(new By.ByClassName("inventory_item_price"));
        //System.out.println(prices.size());
        String price = driver.findElement(new By.ByClassName("inventory_item_price")).getText();
        System.out.println(price);
        String[] prices = price.split("$");
        /*int max = Integer.parseInt(prices.get(0).getText());
        for (WebElement we : prices) {
            System.out.println(we + " " + we.getText());
            int currentValue = Integer.parseInt(we.getText());
            if (currentValue > max) {
                max = currentValue;
            }
        }
        System.out.println(max);*/

    }
        @AfterTest
        public void cleanup () throws InterruptedException {
            Thread.sleep(5000);
           driver.close();

        }
    }


