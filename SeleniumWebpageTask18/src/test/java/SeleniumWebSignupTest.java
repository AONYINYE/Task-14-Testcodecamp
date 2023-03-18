import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class SeleniumWebSignupTest {

    //import the selenium WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the edge driver is
        System.setProperty("webdriver.edge.driver", "src/resources/msedgedriver");
        //1 open the chrome driver
        driver.new EdgeDriver();
        //2 open url https://selenium-blog.herokuapp.com
        driver.get("https://selenium-blog.herokuapp.com");
        // Test1. Verify the user input the right url and his on the right webpage
        if (driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //Pass
            System.out.println("Correct Webpage");
        else//FailSystem.out.println("Wrong Webpage")
            Thread.sleep(10000);
        //3. Maximise the browser
        driver.manage().window().maximize();
        //4. click on Signup button
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(10000);
    }

    @Test(priority = 0)
    public void positiveSignup()
    //Test7 Verify user can signup with valid details
    //5. input username on username field
    driver.findElement(By.id("user_name")).

    sendKeys("onyinye65");
    //Input email in the email field
    driver.findElement(By.id("user_id")).

    sendKeys("onyinye65@mailinator.com");
    //7. Locate the password field and input password
    driver.findElement(By.id("user_password")).

    sendKeys("onyie@56");
    //8. click on the Signup button
    driver.findElement(By.id("submit")).

    click();
}
}
