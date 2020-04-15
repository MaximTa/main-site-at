package ru.geekbrains.main.site.at;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.base.BaseTest;

public class SearchTest extends BaseTest {
//    Перейти на сайт https://geekbrains.ru/courses
//    Нажать на кнопку Поиск
//    В поле Поиск ввести текст: java
//    Проверить что отобразились блоки:
//            Профессии
//            Курсы
//            Вебинары
//            Блоги
//            Форум
//            Тесты
//            Проекты и компании
//3
    @Test
    void name() {
        driver.get("https://geekbrains.ru/courses");
        WebElement buttonSearch = driver.findElement(By.cssSelector("[id=\"top-menu\"] [class=\"show-search-form\"] svg"));
        buttonSearch.click();

        WebElement inputSearch = driver.findElement(By.cssSelector("input[class=\"search-panel__search-field\"]"));
        inputSearch.sendKeys("java");

        WebElement textProfession = driver.findElement(By.xpath("//header/h2[text()='Профессии']"));
        WebElement textCourses = driver.findElement(By.xpath("//header/h2[text()='Курсы']"));
        WebElement textWebinars = driver.findElement(By.xpath("//header/h2[text()='Вебинары']"));
        WebElement textBlogs = driver.findElement(By.xpath("//header/h2[text()='Блоги']"));
        WebElement textForum = driver.findElement(By.xpath("//header/h2[text()='Форум']"));
        WebElement textTests = driver.findElement(By.xpath("//header/h2[text()='Тесты']"));
        WebElement textProjectsAndCompanies = driver.findElement(By.xpath("//header/h2[text()='Проекты и компании']"));


        WebDriverWait wait = new WebDriverWait(driver, 40);
//
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Профессии']"),"Профессии"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Курсы']"),"Курсы"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Вебинары']"),"Вебинары"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Блоги']"),"Блоги"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Форум']"),"Форум"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Тесты']"),"Тесты"));
//        wait.until(ExpectedConditions.textToBe(By.xpath("//header/h2[text()='Проекты и компании']"),"Проекты и компании"));
//
//        wait.until(ExpectedConditions.textToBePresentInElement(textProfession,"Профессии"));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//header/h2[text()='Профессии']"),2));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan((By) textCourses,15));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan((By) textWebinars,180));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan((By) textBlogs,300));
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan((By) textForum, 350));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan((By) textTests,0));
        wait.until(ExpectedConditions.textToBePresentInElement(textProjectsAndCompanies,"GeekBrains"));

//        Assertions.assertEquals("Курсы", textCourses.getText());
//        Assertions.assertEquals("Вебинары", textWebinars.getText());
//        Assertions.assertEquals("Блоги", textBlogs.getText());
//        Assertions.assertEquals("Форум", textForum.getText());
//        Assertions.assertEquals("Тесты", textTests.getText());
//        Assertions.assertEquals("Проекты и компании", textProjectsAndCompanies.getText());


    }
}
