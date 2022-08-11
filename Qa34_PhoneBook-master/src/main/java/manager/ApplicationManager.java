package manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.Browser;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class ApplicationManager {

    WebDriver wd;
    HelperUser helperUser;
    HelperContact contact;
    String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    Logger logger = LoggerFactory.getLogger(ApplicationManager.class);
    public void init(){
        if(browser.equals(Browser.CHROME.browserName())) {
            wd=new ChromeDriver();
            logger.info("All tests run in 'CHROME' browser");
        }else if(browser.equals(Browser.FIREFOX.browserName())){
            wd=new FirefoxDriver();
            logger.info("All tests run in 'FIREFOX' browser");
        }


        WebDriverListener listener = new MyListener();
        wd = new EventFiringDecorator(listener).decorate(wd);

        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wd.navigate().to("https://contacts-app.tobbymarshall815.vercel.app/");
        logger.info("Current Url ---> "+ wd.getCurrentUrl());
        helperUser=new HelperUser(wd);
        contact = new HelperContact(wd);

    }

    public void stop(){

        wd.quit();
    }


    public HelperUser getHelperUser() {
        return helperUser;
    }

    public HelperContact contact() {
        return contact;
    }
}
