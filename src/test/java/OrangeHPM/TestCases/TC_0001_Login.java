package OrangeHPM.TestCases;

import OrangeHPM.PageObjects.BaseClass;
import OrangeHPM.PageObjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_0001_Login extends BaseClass {
    @DataProvider(name = "userCredentials")
    public Object[][] userCredentials() {
        return new String[][] {{"Admin","admin123"}};
    }
    @Test(dataProvider = "userCredentials")
    public void loginTest(String name, String password) throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.getPage();
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //Thread.sleep(3000);
        //lp.getUserName().sendKeys(name);
        //lp.getPassword().sendKeys(password);
        lp.setUsername(name);
        lp.setPassword(password);
        lp.getLoginBTN().click();
        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
        Assert.assertEquals(driver.getTitle(),"OrangeHRM");
    }

}
