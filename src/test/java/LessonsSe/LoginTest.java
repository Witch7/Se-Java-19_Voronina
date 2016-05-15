package LessonsSe;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestNgTestBase {

    @Test
    public void testLogin() throws Exception {
        driver.get(baseUrl + "/php4dvd/");
        driver.findElement(By.id("username")).clear();
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("submit")).click();
    }


}
