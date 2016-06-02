package LessonsSe;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import lessonsSe.applogic.ApplicationManager;
import lessonsSe.applogic2.ApplicationManager2;

public class TestNgTestBase {

  protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager2();
	}
	
	@AfterSuite
	public void stop() {
	  app.stop();
	}

}
