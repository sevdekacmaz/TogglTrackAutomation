package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BaseLibrary {

    @Step("Email alanı doldurulur.")
    public LoginPage emailDoldur(String eMail){
        driver.findElement(By.id("email")).sendKeys(eMail);
        return this;
    }
    @Step("Şifre alanı doldurulur.")
    public LoginPage passwordDoldur(String password){
        driver.findElement(By.id("password")).sendKeys(password);
        return this;
    }
    @Step("Login butonuna tıklanır")
    public LoginPage loginClick(){
        driver.findElement(By.name("submit")).click();
        return this;
    }

    public LoginPage hataMesajKontrol(String text)
    {
        String value = driver.findElement(By.cssSelector("[class='remix-css-1wigd07']")).getText();
        Assert.assertEquals(text,value);
        return this;
    }

    public LoginPage inputKontrol(String text2) {
        String value = driver.findElement(By.cssSelector("[class='remix-css-hn9ccu']")).getText();
        Assert.assertEquals(text2,value);
        return this;
    }
}
