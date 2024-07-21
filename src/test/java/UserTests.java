import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class UserTests extends BaseTest {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

   @Test(description = "Başarılı kullanıcı girişi kontrolü")
    public void loginSuccessful() throws InterruptedException {
       loginPage
               .emailDoldur(eMail)
               .passwordDoldur(password)
               .loginClick();
       sleep(3000);
   }

    @Test(description = "Hatalı kullanıcı girişi")
    public void loginError() throws InterruptedException {
        loginPage
                .emailDoldur(eMail)
                .passwordDoldur("12345")
                .loginClick();
        sleep(3000);
        loginPage
                .hataMesajKontrol(errorMsg);

    }

    @Test(description = "Geçersiz mail adresi girişi")
    public void NotValidEmail() throws InterruptedException {
        loginPage
                .emailDoldur("sevdekuulhan@gmail.com")
                .passwordDoldur(password)
                .loginClick();
        sleep(3000);
        loginPage
                .hataMesajKontrol(errorMsg);
    }

    @Test(description = "Boş mail alanı kontrolü")
    public void EmptyMail() throws InterruptedException {
        loginPage
                .emailDoldur("")
                .passwordDoldur(password)
                .loginClick();
        sleep(3000);
        loginPage
                .inputKontrol(inputError);
    }

    @Test(description = "Boş şifre alanı kontrolü")
    public void EmptyPassword() throws InterruptedException {
        loginPage
                .emailDoldur(eMail)
                .passwordDoldur("")
                .loginClick();
        sleep(3000);
        loginPage
                .inputKontrol(inputError2);
        loginPage
                .passwordDoldur(password)
                .loginClick();

    }

    @Test(description = "Maximum karakter kontrolü")
    public void maxControl() throws InterruptedException {
        loginPage
                .emailDoldur("bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb")
                .passwordDoldur("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa")
                .loginClick();
        sleep(3000);
        driver.findElement(By.id("email")).clear();
        loginPage.emailDoldur(eMail).loginClick();
        sleep(3000);
        driver.findElement(By.id("password")).clear();
        loginPage.passwordDoldur(password).loginClick();
        sleep(3000);
    }

}

