package SeleniumJavaPOP.Tests;

import SeleniumJavaPOP.Pages.HotelSearchPages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

public class HotelSearchTest extends BaseTest {


    @Test
    public void searchHotelTest(){
        //------------------ Test w wersji page object pattern ------------------//

        HotelSearchPages hotelSearchPages = new HotelSearchPages(driver);
        hotelSearchPages.setCity("Dubai");
        hotelSearchPages.setDates("01/05/2022","09/05/2022");
        hotelSearchPages.setTravelers();
        hotelSearchPages.performSearch();




        //----------------------- Test w wersji liniowej --------------------------- //

//        System.out.println(driver.getCurrentUrl());
//        //miasto
//        driver.findElement(By.xpath("//span[contains(text(),'Search by H')]")).click();
//        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Dubai");
//        driver.findElement(By.xpath("//span[@class='select2-match']")).click();
//        //data wpisanie daty
//        driver.findElement(By.name("checkin")).sendKeys("12/04/2022");
//        driver.findElement(By.name("checkout")).sendKeys("17/04/2022");
//        //wybranie daty z kalendarza
//        driver.findElements(By.xpath("//td[@class='day ' and text()='28']")).stream()
//                .filter(WebElement::isDisplayed)
//                .findFirst()
//                .ifPresent(WebElement::click);
//        driver.findElement(By.id("travellersInput")).click();
//        driver.findElement(By.id("adultPlusBtn")).click();
//        driver.findElement(By.id("childPlusBtn")).click();
//        driver.findElement(By.xpath("//button[text()=' Search']")).click();
//        List<String> hotelNames = driver.findElements(By.xpath("//h4[contains(@class, 'list_title')]//b")).stream()
//                .map(el -> el.getAttribute("textContent"))
//                .collect(Collectors.toList());
//        System.out.println(hotelNames.size());
//
//        hotelNames.forEach(System.out::println);
//        Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
//        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower" );
//        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
//        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");

    }
    @Test
    public void searchHotelWithoutName(){

        //data wpisanie daty
        driver.findElement(By.name("checkin")).sendKeys("12/04/2022");
        driver.findElement(By.name("checkout")).sendKeys("17/04/2022");
        //wybranie daty z kalendarza
        driver.findElements(By.xpath("//td[@class='day ' and text()='28']")).stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(WebElement::click);
        driver.findElement(By.id("travellersInput")).click();
        driver.findElement(By.id("childPlusBtn")).click();
        driver.findElement(By.xpath("//button[text()=' Search']")).click();

        WebElement noResultHeading = driver.findElement(By.xpath("//div[@class = 'itemscontainer']//h2"));
        Assert.assertTrue(noResultHeading.isDisplayed());
        Assert.assertEquals(noResultHeading.getText(), "No Results Found");

    }

}
