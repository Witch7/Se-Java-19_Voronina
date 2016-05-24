package LessonsSe;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddInImbd extends TestNgTestBase {

	@Test
	public void addInImbd() throws Exception {
		// Вход и авторизация на учебный проект
		driver.get(baseUrl + "/php4dvd/");
		String username = "username";
		driver.findElement(By.id(username)).clear();
		driver.findElement(By.id(username)).sendKeys("admin");
		String password = "password";
		driver.findElement(By.name(password)).clear();
		driver.findElement(By.name(password)).sendKeys("admin");
		driver.findElement(By.name("submit")).click();

		// Добавление нового фильма из imbd
		driver.findElements(By.cssSelector(".button>div>a>img")).get(0).click();
		driver.findElement(By.id("imdbsearch")).sendKeys("tt3385516");
		driver.findElements(By.cssSelector("input[type='submit']")).get(0).click();
		driver.findElement(By.cssSelector(".title")).click();
		driver.findElement(By.id("submit")).click();
		String elurl = "movie_" + driver.getCurrentUrl().substring(39);
		driver.findElements(By.cssSelector(".center>nav>ul>li>a")).get(0).click();
		(new WebDriverWait(driver, 30, 1))
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".title")));
		driver.findElement(By.id(elurl)).isDisplayed();
		
		driver.quit();
	}
}
