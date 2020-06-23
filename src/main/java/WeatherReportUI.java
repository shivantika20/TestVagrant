import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WeatherReportUI {

    public static WebDriver driver = null;

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "/Users/shivantika.t/Downloads/chromedriver");
        ChromeOptions options = new ChromeOptions();
//to disable the warnings
        options.addArguments("['--disable-web-security', '--user-data-dir', '--allow-running-insecure-content','--disable-notifications']");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

//open the chrome app
        driver.navigate().to("https://www.ndtv.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String title = driver.getTitle();
        System.out.println(title);

        WebElement userElement = driver.findElement(By.xpath("/html/body/div[2]/div/div/div/div/div[3]/a"));
//userElement.sendKeys(properties.getProperty("username"));
        userElement.click();
        driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div/div/a[8]")).click();

        Thread.sleep(3000);

        WebElement passwordElement = driver.findElement(By.xpath("/html/body/div[7]/div/div[3]/div[3]/label/input"));
        passwordElement.click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[4]/div[12]/div/div[2]")).click();
        Thread.sleep(1000);

        WebElement weather = driver.findElement(By.xpath("/html/body/div[6]/div[1]/div[6]/div/div[1]/div/div/span[4]/b"));
        System.out.println(weather.getText());
    }
}

