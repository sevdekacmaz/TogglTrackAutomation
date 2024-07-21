package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage extends BaseLibrary {
    @Step("Google extension alanının kontrolü")
    public MainPage extensionNotAdd() throws InterruptedException {
        sleep(4000);
        WebElement element = driver.findElement(By.xpath("/html/body/div[3]/div/div"));
        if (element.isDisplayed())
            driver.findElement(By.xpath("/html/body/div[3]/div/div/div/div[1]/button")).click();
        return this;
    }
}