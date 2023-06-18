package opencarttest.Testcases;

import com.microsoft.playwright.Page;
import com.opencart.opencartnewpakagetest.Pages.homePage;
import com.opencart.opencartnewpakagetest.base.playwrightFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class homePageTest {
    playwrightFactory pf;
    Page page;
    homePage HomePage;
    @BeforeTest
    public void setUp() throws InterruptedException {
        pf=new playwrightFactory();
        page= pf.intBrowser("chrome");
        HomePage=new homePage(page);
        Thread.sleep(3000);
    }
    @Test
    public void homepageTitleTest() throws InterruptedException {
        String actualTitle = HomePage.getHomePageTitle();
        Assert.assertEquals(actualTitle, "Your Store");
        Thread.sleep(3000);
    }
    @Test
    public void homepageURLTest() throws InterruptedException {
        String actualURL=HomePage.getHomePageURL();
        Assert.assertEquals(actualURL, "https://naveenautomationlabs.com/opencart/");
        Thread.sleep(3000);
    }
    @Test
    public void searchTest() throws InterruptedException {
        String actualSearchHeader=  HomePage.doSearch("Macbook");
        Assert.assertEquals(actualSearchHeader,"Search - Macbook");
        Thread.sleep(3000);

    }
    @AfterTest
    public void tearDown(){
        page.context().browser().close();
    }
}
