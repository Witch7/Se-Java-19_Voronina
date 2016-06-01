package LessonsSe;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeletSumFilm extends TestNgTestBase {
	@Test
	public void deletSumFilm() throws Exception {
		// Вход и авторизация на учебный проект
		driver.get(baseUrl + "/php4dvd/");
		String username = "username";
		driver.findElement(By.id(username)).clear();
		driver.findElement(By.id(username)).sendKeys("admin");
		String password = "password";
		driver.findElement(By.name(password)).clear();
		driver.findElement(By.name(password)).sendKeys("admin");
		driver.findElement(By.name("submit")).click();

		// Удаление фильма
		driver.findElements(By.cssSelector(".center>nav>ul>li>a")).get(0).click();
		(new WebDriverWait(driver, 30, 1))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".movie_box")));
		int kol = driver.findElements(By.cssSelector(".title")).size();
		String elmovi = driver.findElements(By.cssSelector(".movie_box")).get(0).getAttribute("id");
		driver.findElements(By.cssSelector(".title")).get(0).click();
		driver.findElement(By.linkText("Remove")).click();
		driver.switchTo().alert().accept();
		(new WebDriverWait(driver, 30, 1))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".movie_box")));
		Assert.assertEquals(kol-1, driver.findElements(By.cssSelector(".title")).size());
		AssertJUnit.assertFalse("Фильм удален",
				driver.findElements(By.cssSelector(".movie_box")).get(0).getAttribute("id").equals(elmovi));

		driver.quit();

	}

}
