package lessonsSe.pages;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class FilmAddPage extends AnyPage {

	public FilmAddPage(PageManager pages) {
		super(pages);
	}

	@FindBy(name = "imdbsearch")
	private WebElement idImdb;
	
	@FindBy(name = "submit")
	private WebElement submitButton;

	public FilmAddPage setIdImdb(String imdb) {
		idImdb.sendKeys(imdb);
		return this;
	}
	
	public String setIdUrl(){
		String elurl = "movie_" + driver.getCurrentUrl().substring(39);
		return elurl;
		
	}
	
	public void searshFilmImdb() {
		driver.findElements(By.cssSelector("input[type='submit']")).get(0).click();
		driver.findElement(By.cssSelector(".title")).click();
	}
	
	public void clickSubmitButton() {
		submitButton.click();
	}
	
	public FilmAddPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.id("loginform")));
		return this;
	}

}
