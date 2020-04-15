package ru.geekbrains.main.site.at;

import com.sun.prism.impl.BaseTexture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.geekbrains.main.site.at.base.BaseTest;

public class NavPostsTest extends BaseTest {
    @Test
    void checkNavigation() throws InterruptedException {
        driver.get("https://geekbrains.ru/posts");
        WebElement buttonPosts = driver.findElement(By.cssSelector("[class*=\"main-page-hidden\"] [href=\"/posts\"]"));
        buttonPosts.click();
        WebElement headerPagePosts = driver.findElement(By.cssSelector("[class=\"gb-header__title\"]"));
        Assertions.assertEquals("Блог", headerPagePosts.getText());
    }
}