package OrangeHPM.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeListPage {
    WebDriver driver;
    private final String url = "https://opensource-demo.orangehrmlive.com/web/index.php/pim/viewEmployeeList";
    public EmployeeListPage(WebDriver driver) {
        this.driver = driver;
    }
    public void getPage() {
        driver.get(url);
    }
}
