package junk;

import com.trello.UI.core.BrowserFactory;
import org.testng.annotations.Test;

public class TryBrowser extends BrowserFactory {

    @Test
    public void openClose() {
        driver().get("https://google.com");
    }
}
