import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.MainPage;
import org.testng.annotations.Test;

import static java.awt.SystemColor.text;


public class TimeEntryTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    MainPage mainPage = new MainPage();

    @Test(description = "Girilen zamanın açıklanması eklenir.")
    public void addEntryDescription() throws InterruptedException {
        loginPage
                .emailDoldur(eMail)
                .passwordDoldur(password)
                .loginClick();
        sleep(5000);
        mainPage.extensionNotAdd();
        sleep(5000);
        homePage.entryDescription(text);
        sleep(5000);
    }

}

