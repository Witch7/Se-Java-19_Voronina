package lessonsSe.applogic2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import lessonsSe.applogic.FilmHelper;
import lessonsSe.model.Film;

public class FilmHelper2 extends DriverBasedHelper implements FilmHelper {

	public FilmHelper2(ApplicationManager2 manager) {
		super(manager.getWebDriver());
	}
	private String elurl;
	@Override
	public void addImdb(Film film) {
		pages.filmAddPage.ensurePageLoaded().setIdImdb(film.getImdb()).searshFilmImdb();
		pages.filmAddPage.clickSubmitButton();
		String elurl = pages.filmAddPage.setIdUrl();
	}
	
	public void checkAddImdb() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".title")));
		Assert.assertTrue(driver.findElement(By.id(elurl)).getAttribute("id").equals(elurl), "Нет такого идентифекатора фильма");
	}

	
	@Override
	public void delete(Film film) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Film> search(String title) {
		// TODO Auto-generated method stub
		return null;
	}

}
