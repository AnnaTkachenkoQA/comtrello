package regression;

import com.trello.UI.core.BrowserFactory;
import com.trello.UI.pages.BoardsPage;
import com.trello.UI.pages.LoginPage;
import org.testng.annotations.Test;

public class LoginTest extends BrowserFactory{

    LoginPage loginPage= new LoginPage();


    @Test
    public void login() {
        loginPage.open();
        loginPage.login("nanccy95@gmail.com", "anna5624787");
    }


}
