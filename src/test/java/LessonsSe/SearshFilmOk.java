package LessonsSe;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearshFilmOk extends TestNgTestBase {
	@Test
	public void searshFilmOk() throws Exception {
		// Вход и авторизация на учебный проект
		driver.get(baseUrl + "/php4dvd/");
		String username = "username";
		driver.findElement(By.id(username)).clear();
		driver.findElement(By.id(username)).sendKeys("admin");
		String password = "password";
		driver.findElement(By.name(password)).clear();
		driver.findElement(By.name(password)).sendKeys("admin");
		driver.findElement(By.name("submit")).click();

		// Создание фильма
		driver.findElements(By.cssSelector(".button>div>a>img")).get(0).click();
		(new WebDriverWait(driver, 30, 1))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".required.error")));
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("FilmForSearsh");
		driver.findElement(By.cssSelector("input[name='year']")).sendKeys("2016");
		driver.findElements(By.cssSelector("input[type='submit']")).get(1).click();
		driver.findElements(By.cssSelector(".center>nav>ul>li>a")).get(0).click();
		(new WebDriverWait(driver, 30, 1))
		.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".movie_box")));
		int kol = driver.findElements(By.cssSelector(".title")).size();

		// Поиск фильма
		driver.findElement(By.id("q")).sendKeys("Film");
		driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
		(new WebDriverWait(driver, 30, 1)).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("results")));
		if (driver.findElements(By.cssSelector(".title")).size() < kol) {
			Assert.assertTrue(driver.findElement(By.cssSelector(".title")).getText().equals("FilmForSearsh"),
					"Такого фильма нет");
		} else Assert.fail("Количество фильмов осталось прежним");


		driver.quit();
	}

}
