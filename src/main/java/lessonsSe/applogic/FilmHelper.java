package lessonsSe.applogic;

import java.util.List;

import lessonsSe.model.Film;

public interface FilmHelper {

	void delete(Film film);
	List<Film> search(String title);
	void addImdb(Film film);

}
