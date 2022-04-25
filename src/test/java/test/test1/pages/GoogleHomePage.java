package test.test1.pages;

import com.github.jsdevel.testng.selenium.AbstractPage;
import java.net.URL;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleHomePage extends AbstractPage<GoogleHomePage, SamplePageFactory> {
  @FindBy(css = "[name=q]")
  public WebElement q;

  public GoogleSearchResultsPage submitSearch(String query) {
    q.sendKeys(query);
    q.submit();
    System.out.println("test");
    return getPageFactory().getSearchResultsPage();
   
  }

  @Override
  public boolean isPageViewableFrom(URL proposedUrl) {
    return proposedUrl.getPath().startsWith("/");
  }
}
