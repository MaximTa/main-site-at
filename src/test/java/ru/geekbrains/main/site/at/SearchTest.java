package ru.geekbrains.main.site.at;


import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.geekbrains.main.site.at.base.BaseTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class SearchTest extends BaseTest {


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

//4
        WebDriverWait wait = new WebDriverWait(driver, 40);
        assertThat(Integer.parseInt(textProfession.getText()), greaterThanOrEqualTo(2));
        assertThat(Integer.parseInt(textCourses.getText()), greaterThan(15));
        assertThat(Integer.parseInt(textWebinars.getText()), allOf(greaterThan(180), lessThan(300)));
        assertThat(Integer.parseInt(textBlogs.getText()), greaterThan(300));
        assertThat(Integer.parseInt(textForum.getText()), not(equalTo(350)));
        assertThat(Integer.parseInt(textTests.getText()), not(equalTo(0)));
    }

//        @Test
//        public void givenNumberTests () {
//            WebElement countTests = driver.findElement(By.xpath("//html/body/div[1]/div[6]/div/div[1]/div/ul/li[6]/a/span"));
//            assertThat(Integer.parseInt(countTests.getText()), not(equalTo(0)));
//    }

}
