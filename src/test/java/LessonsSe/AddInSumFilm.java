package LessonsSe;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddInSumFilm extends TestNgTestBase {

	@Test
	public void addInSumFilm() throws Exception {
		// Вход и авторизация на учебный проект
		driver.get(baseUrl + "/php4dvd/");
		String username = "username";
		driver.findElement(By.id(username)).clear();
		driver.findElement(By.id(username)).sendKeys("admin");
		String password = "password";
		driver.findElement(By.name(password)).clear();
		driver.findElement(By.name(password)).sendKeys("admin");
		driver.findElement(By.name("submit")).click();

		// Добавление нового фильма произвольного фильма
		driver.findElements(By.cssSelector(".button>div>a>img")).get(0).click();
		(new WebDriverWait(driver, 30, 1))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".required.error")));
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("FilmNew");
		driver.findElement(By.cssSelector("input[name='year']")).sendKeys("2010");
		driver.findElements(By.cssSelector("input[type='submit']")).get(1).click();
		String elurl = "movie_" + driver.getCurrentUrl().substring(39);
		driver.findElements(By.cssSelector(".center>nav>ul>li>a")).get(0).click();
		(new WebDriverWait(driver, 30, 1))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".title")));
		Assert.assertTrue(driver.findElement(By.id(elurl)).getAttribute("id").equals(elurl), "Нет такого идентифекатора фильма");

		driver.quit();
	}

}
