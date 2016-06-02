package LessonsSe;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import lessonsSe.model.Film;
import lessonsSe.model.User;
import lessonsSe.pages.FilmAddPage;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddInImbd extends TestNgTestBase {
	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isNotLoggedIn()) {
			User user = new User().setLogin("admin").setPassword("admin");
			app.getUserHelper().isLoggedInAs(user);
		}
		return;
	}

	@Test
	public void addInImbd() throws Exception {
		// Добавление нового фильма из imbd
		app.getNavigationHelper().gotoAddFilmPage();
		Film film = new Film().setImdb("tt3385516");
		app.getFilmHelper().addImdb(film);
		
//		driver.findElement(By.id("imdbsearch")).sendKeys("tt3385516");		
//		driver.findElements(By.cssSelector("input[type='submit']")).get(0).click();
//		driver.findElement(By.cssSelector(".title")).click();
//		driver.findElement(By.id("submit")).click();
//		String elurl = "movie_" + driver.getCurrentUrl().substring(39);
//		driver.findElements(By.cssSelector(".center>nav>ul>li>a")).get(0).click();
		app.getNavigationHelper().openMainPage();
		
//		(new WebDriverWait(driver, 30, 1))
//				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".title")));
//		driver.findElement(By.id(elurl)).isDisplayed();

	}
}
