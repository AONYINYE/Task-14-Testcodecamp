import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;


//visit the URL Konga
        //Sign in to Konga Successfully
        //From the Categories, click on the “Computers and Accessories”
        //Click on the Laptop SubCategory
        //Click on the Apple MacBooks
        //Add an item to the cart
        //Select Address
        //Continue to make payment
        //Select a Card Payment Method
        //Input invalid card details
        //Print Out the error message: Invalid card number
        //Close the iFrame that displays the input card Modal
        //Quit the browser.
public class AnosikeKongaProjectTest {
    private By ModalButton = By.xpath("//]/div/div[2]/div[3]/div[2]/div/button");
    private By ModalCardbutton = By.xpath("//*[@id=\"channel-template\"]/div[2]/div/div[2]/button/div/span[1]");
    private By ModalCardNumber = By.id("card-number");
    private By ModalDate = By.id("expiry");
    private By ModalCVV = By.id("id=\"cvv\"");
    private By ModalPayNowButton = By.id("validateCardForm");
    private By CloseIframe = By.xpath("/html/body/section/section/section/div[2]/div[1]/aside");

    //import the Konga WebDriver
    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the edge driver is
        System.setProperty("webdriver.edge.driver", "resources/msedgedriver.exe");
        //1 open the edge driver
        driver = new EdgeDriver();
        //2 open url https://www.konga.com
        driver.get("https://www.konga.com");
        // Test1. Verify the user input the right url and is on the right webpage
        if (driver.getCurrentUrl().contains("https://www.konga.com"))
            //Pass
            // System.out.println("Correct Webpage");
            //FailSystem.out.println("Wrong Webpage")
            Thread.sleep(5000);
        //3. Maximise the browser
        driver.manage().window().maximize();
        //4. click on Login/Signup  button
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/div[4]/a")).click();

    }

    @Test(priority = 0)
    public void PostiveSignup() throws InterruptedException {
        //verify that user can log in with valid email details
        //input email and password
        driver.findElement(By.id("username")).sendKeys("gift4real005@yahoo.com");
        driver.findElement(By.id("password")).sendKeys("123@me0");
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[4]/section/section/aside/div[2]/div/form/div[3]/button")).click();
        Thread.sleep(15000);

    }

    @Test(priority = 1)
    public void Category() throws InterruptedException {
        //verify user will select category successfull
        //click on category and select Computers and Accessories
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[2]/div/a[2]")).click();
        Thread.sleep(10000);
    }

    @Test(priority = 2)
    public void SelectLaptops() throws InterruptedException {
        //verify user can select laptops category
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li[3]/a/label/span")).click();
        Thread.sleep(5000);
    }
    @Test(priority = 3)
    public void AppleMackBook() throws InterruptedException {
        //click on Apple MackBook
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/div/section/div[2]/div[2]/ul/li/a/ul/li[1]/a/label/span")).click();
        Thread.sleep(2000);

    }
    @Test(priority = 4)
    public void AddItemtoCart() throws InterruptedException {
        //select an item and add to cart
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/section[3]/section/section/section/section/ul/li[1]/div/div/div[2]/form/div[3]/button")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 5)
    public void ClickCartButton() throws InterruptedException {
        //select cart button
        //verify that user can interact with cart
        driver.findElement(By.xpath("//*[@id=\"nav-bar-fix\"]/div[1]/div/div/a[2]/span[1]")).click();
        Thread.sleep(2000);
    }

    @Test(priority = 6)
    public void CheckoutButton() throws InterruptedException {
        //select checkout button
        driver.findElement(By.xpath("//*[@id=\"app-content-wrapper\"]/div[3]/section/section/aside/div[3]/div/div[2]/button")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 7)
    public void AddDeliveryAddress() throws InterruptedException {
        //select change option button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[1]/div[2]/div/button")).click();
        //select add delivery address
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 8)
    public void SelectAddress() throws InterruptedException {
        //select address
        driver.findElement(By.id("6002997")).sendKeys("selectDeliveryAddress");
        //click on use this addres button
        driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div/form/div/div[1]/section[1]/div/div/div[2]/div[1]/div[2]/div[1]/div/button")).click();
        Thread.sleep(3000);
    }

    @Test(priority = 9)
    public void PaymentOption() throws InterruptedException {
        //click on pay now
        driver.findElement(By.xpath("//*[@id=\\\"mainContent\\\"]/div/form/div/div[1]/section[2]/div/div[2]/div[1]/div[1]/h2")).click();
    }
    @Test(priority = 10)
    public void ContinuePayment() throws InterruptedException {
        //click on continue to payment
        driver.findElement(By.xpath("//*[@id=\\\"mainContent\\\"]/div/form/div/div[1]/section[2]/div/div[2]/div[3]/div[2]/div/button")).click();
        Thread.sleep(10000);
    }

    @Test(priority = 11)
    public void PaymentMethod() throws InterruptedException {
     //select payment method
     //select card
     click(ModalButton);

    }

    private void click(By modalButton) {
    }

    @Test(priority = 12)
    public void EnterCardDetails() throws InterruptedException {
        //input invalid card number
        //Verify that user cannot pay with invalid card details
        setText(ModalCardNumber, 83561859);
        setText(ModalDate, 03/24);
        setText(ModalCVV, 450);
        click(ModalPayNowButton);
        String expectedUrl = "https://www.konga.com/checkout/complete-order";
        String actualUrl = driver.getCurrentUrl();
        if (actualUrl.contains(expectedUrl))
            //Pass
            System.out.println("invalid card number");
        else
            //Fail
            System.out.println("valid card number");
        Thread.sleep(5000);
    }

    private void setText(By modalCardNumber, int i) {
    }

    @AfterTest
    public void closeBrowser() {
     //Quit browser
    driver.quit();
    }
}
