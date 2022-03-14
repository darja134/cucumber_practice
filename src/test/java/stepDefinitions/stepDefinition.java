package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;
import org.apache.commons.lang3.RandomStringUtils;
import java.util.ArrayList;

public class stepDefinition {
    public WebDriver driver;
    public WebDriverWait wait;
    // Scenario 1
    @Given("User goes to phptravel home page and press Sign up button")
    public void user_goes_to_phptravel_home_page_and_press_sign_up_button() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        driver.get("https://phptravels.com");
        By SignInButton = By.xpath("/html/body/header/div/nav/a[5]");
        driver.findElement(SignInButton).click();
        // можно использовать, а можно нет, без этого просто не будет визуала
        ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
        driver.switchTo().window(tabs2.get(1));
        driver.close();
        driver.switchTo().window(tabs2.get(0));

    }
    @When("User fills in registration form and press Register button")
    public void user_fills_in_registration_form_and_press_register_button() {
        String password = "password123";
        driver.get("https://phptravels.org/register.php");
        driver.findElement(By.id("inputFirstName")).sendKeys(RandomStringUtils.randomAlphabetic(8));
        driver.findElement(By.id("inputLastName")).sendKeys(RandomStringUtils.randomAlphabetic(8));
        driver.findElement(By.id("inputEmail")).sendKeys(RandomStringUtils.randomAlphanumeric(5) + "@test.ru");
        driver.findElement(By.id("inputPhone")).sendKeys(RandomStringUtils.randomNumeric(10));
        driver.findElement(By.id("inputAddress1")).sendKeys(RandomStringUtils.randomAlphabetic(6));
        driver.findElement(By.id("inputAddress2")).sendKeys(RandomStringUtils.randomNumeric(3));
        driver.findElement(By.id("inputCity")).sendKeys(RandomStringUtils.randomAlphabetic(6));
        driver.findElement(By.id("customfield2")).sendKeys(RandomStringUtils.randomNumeric(10));
        driver.findElement(By.id("inputNewPassword1")).sendKeys(password);
        driver.findElement(By.id("inputNewPassword2")).sendKeys(password);
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/div/div/div/div[1]/form/div[5]/input")).click();
    }
    @Then("User cannot register without captcha")
    public void user_cannot_register_without_captcha() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div/div/div/div[1]/div")));
        driver.quit();
    }

}
