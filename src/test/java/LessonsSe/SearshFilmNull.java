package LessonsSe;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearshFilmNull extends TestNgTestBase {
	@Test
	public void searshFilmNull() throws Exception {
		// Вход и авторизация на учебный проект
		driver.get(baseUrl + "/php4dvd/");
		String username = "username";
		driver.findElement(By.id(username)).clear();
		driver.findElement(By.id(username)).sendKeys("admin");
		String password = "password";
		driver.findElement(By.name(password)).clear();
		driver.findElement(By.name(password)).sendKeys("admin");
		driver.findElement(By.name("submit")).click();

		// Поиск не коррктного значения
		driver.findElement(By.id("q")).sendKeys("sdflksdhgsd");
		driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
		(new WebDriverWait(driver, 30, 1))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".content")));
		Assert.assertTrue(driver.findElement(By.cssSelector(".content")).getText().equals("No movies where found."),
				"Нет такого фильма");

		driver.quit();
	}
}
