package pl.com.aay.story;


import java.util.ArrayList;

import net.thucydides.jbehave.ThucydidesJUnitStories;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@SuppressWarnings("unused")
public class AcceptanceTestSuite extends ThucydidesJUnitStories 
{
	
	public AcceptanceTestSuite()
	{

		System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();
	    runThucydides().withDriver("firefox").inASingleSession();

	}
	
	@Override
    public ArrayList<String> storyPaths()
    {
		ArrayList <String> storiesList =  new ArrayList<>();
		storiesList.add("story/ContactUs.story");

		return storiesList;
    }
}
