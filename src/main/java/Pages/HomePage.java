package Pages;

import Base.BaseLibrary;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.security.Key;

public class HomePage extends BaseLibrary {

    @Step("Zaman açıklaması girilir.")
    public HomePage entryDescription(String text) throws InterruptedException {
        sleep(3000);
        WebElement descriptionField = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div[1]/div[1]"));
        descriptionField.click();
        WebElement description = driver.findElement(By.xpath("//*[@id=\"root\"]/div/div/div[2]/div[3]/div/div[1]/div[2]/div[1]/div/div[1]/div[2]/div[1]/div/input"));
        description.sendKeys(text, Keys.ENTER);
        return this;


    }



}
