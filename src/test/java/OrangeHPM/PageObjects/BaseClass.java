package OrangeHPM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

public class BaseClass {
    public WebDriver driver;
    @BeforeClass
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        Logger logger = LoggerFactory.getLogger(BaseClass.class);
        logger.info("WebDriver is set");
    }
    public String getUserName() {
        return "Admin";
    }
    public String getPassword() {
        return "admin123";
    }
    //@Test
    public void testStuff(){
        System.out.println(System.getProperty("user.dir"));
        Logger logger = LoggerFactory.getLogger(BaseClass.class);
        logger.info("WebDriver is set");
    }
//    @AfterClass
//    public void TearDown() {
//        driver.quit();
//    }
}
