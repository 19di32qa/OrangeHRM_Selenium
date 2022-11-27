package OrangeHPM.PageObjects;

import org.openqa.selenium.WebDriver;

public class BaseLogin {
    WebDriver driver;
    public BaseLogin(WebDriver driver) {
        this.driver = driver;
    }
    public void login() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getPage();
        loginPage.setUsername("Admin");
        loginPage.setPassword("admin123");
        loginPage.getLoginBTN().click();
    }
}
