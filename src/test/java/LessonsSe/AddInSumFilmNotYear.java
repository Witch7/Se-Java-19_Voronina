package LessonsSe;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddInSumFilmNotYear extends TestNgTestBase {
	@Test
	public void addInSumFilmNotYear() throws Exception {
		// Вход и авторизация на учебный проект
		driver.get(baseUrl + "/php4dvd/");
		String username = "username";
		driver.findElement(By.id(username)).clear();
		driver.findElement(By.id(username)).sendKeys("admin");
		String password = "password";
		driver.findElement(By.name(password)).clear();
		driver.findElement(By.name(password)).sendKeys("admin");
		driver.findElement(By.name("submit")).click();

		// Добавление нового фильма без заполнения года
		driver.findElements(By.cssSelector(".button>div>a>img")).get(0).click();
		(new WebDriverWait(driver, 30, 1))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".required.error")));
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("NewFilm2");
		driver.findElement(By.cssSelector("input[name='year']")).clear();
		driver.findElements(By.cssSelector("input[type='submit']")).get(1).click();
		AssertJUnit.assertTrue("Поле год не заполнено",
				driver.findElement(By.cssSelector("label[for='year']")).getText().equals("This field is required"));

		driver.quit();
	}

}
