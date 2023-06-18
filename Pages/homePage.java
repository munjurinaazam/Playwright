package opencarttest.Pages;

import com.microsoft.playwright.Page;

public class homePage {
    private Page page;
    //    1.String Locator
    private String search= "//input[@placeholder='Search']";
    private  String searchIcon= "//button[@class='btn btn-default btn-lg']";
    private String searchPageHeader="div#content h1";
    //    2.page Constructor
    public homePage(Page page){
        this.page=page;

    }
    //page actions/methods
//    public String getHomePageTitle(){
//        String title=page.title();
//        System.out.println("Page Title is: "+title);
//        return  title;
//    }
    public String getHomePageTitle() {
        String title = page.title();
        System.out.println("Page Title is: " + title);
        return title;
    }
    public String getHomePageURL(){
        String url=page.url();
        System.out.println("URL is:"+url);
        return url ;
    }
    public String doSearch(String productName){
        page.fill(search,productName);
        page.click(searchIcon);
        String header=page.textContent(searchPageHeader);
        System.out.println("Search Header is:"+header);
        return header;

    }
}
