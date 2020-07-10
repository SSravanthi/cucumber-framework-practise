package Steps;

import Base.BaseUtil;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;


public class Hook extends BaseUtil {

    private BaseUtil base;

    public Hook(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void InitializeTest(){
        System.out.println("Opening the browser: Chrome");

        //Passing a dummy variable
        // base.StepInfo ="Chromedriver";

        //System.setProperty("webdriver.firefox.marionette", "C:\\Users\\Sravanthi Somalaraju\\Documents\\Selenium\\firefoxdriver\\geckodriver.exe");
        //base.Driver =  new ChromeDriver();

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Sravanthi Somalaraju\\Documents\\Selenium\\chromedriver\\chromedriver.exe");
        base.Driver =  new ChromeDriver();

    }

    @After
    public void TearDownTest(Scenario scenario){
        if (scenario.isFailed()){
            System.out.println(scenario.getStatus());
        }

        System.out.println("Closing the browser");
    }
}
