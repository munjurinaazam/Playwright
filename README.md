package com.qa.opencart.test.base;

<!-- Please use this Base Class in A Package. Otherwise system will not be supported . -->

import com.microsoft.playwright.Page;
import com.opencart.opencartnewpakagetest.Pages.homePage;
import com.opencart.opencartnewpakagetest.base.playwrightFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.util.Properties;

public class baseTestClass {
    private playwrightFactory pf;
    private Page page;
    protected homePage HomePage;
    private Properties prop;

    @BeforeTest
    public void setUp() {
        pf = new playwrightFactory();
        prop = pf.init_prop();
        page = pf.intBrowser(prop);
        HomePage = new homePage(page);
    }

    @AfterTest
    public void tearDown() {
        page.context().browser().close();
    }
}
