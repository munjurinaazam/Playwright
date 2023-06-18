package opencarttest.base;

import com.microsoft.playwright.*;

public class playwrightFactory {
    private Playwright playwright;
    private Browser browser;
    private BrowserContext browserContext;
    private Page page;


    public Page intBrowser(String browserName) {
        System.out.println("Browser Name is: " + browserName);
        playwright = Playwright.create();
        switch (browserName) {
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "firefox":
                browser = playwright.firefox().launch(new BrowserType.LaunchOptions().setHeadless(false));
                break;
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));
                break;
            default:
                System.out.println("please pass the right browser");
                break;
        }
        browserContext = browser.newContext();
        page = browserContext.newPage();
        page.navigate("https://naveenautomationlabs.com/opencart/");
        return page;
    }

}
