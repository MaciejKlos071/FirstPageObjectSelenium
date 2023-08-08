package SeleniumJavaPOP.Tests;

import SeleniumJavaPOP.Pages.HotelSearchPages;
import SeleniumJavaPOP.Pages.ResultsPage;
import SeleniumJavaPOP.utils.ExcelReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class HotelSearchTest extends BaseTest {


    @Test
    public void searchHotelTest() {

        //------------------ Test w wersji page object pattern ------------------//
        HotelSearchPages hotelSearchPages = new HotelSearchPages(driver);
        hotelSearchPages.setCity("Dubai");
        hotelSearchPages.setDates("01/05/2022", "09/05/2022");
        hotelSearchPages.setTravelers(1, 2);
        hotelSearchPages.performSearch();

        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelNames = resultsPage.getHotelNames();
        System.out.println("Starting Asseretions");
        Assert.assertEquals(hotelNames.get(0), "Jumeirah Beach Hotel");
        Assert.assertEquals(hotelNames.get(1), "Oasis Beach Tower");
        Assert.assertEquals(hotelNames.get(2), "Rose Rayhaan Rotana");
        Assert.assertEquals(hotelNames.get(3), "Hyatt Regency Perth");
        System.out.println("Asseretions done.");

    }

    @Test
    public void searchHotelWithoutName() {

        //------------------ Test w wersji page object pattern ------------------//
        HotelSearchPages hotelSearchPages = new HotelSearchPages(driver);
        hotelSearchPages.setDates("01/05/2022", "09/05/2022");
        hotelSearchPages.setTravelers(1, 2);
        hotelSearchPages.performSearch();
        ResultsPage resultsPage = new ResultsPage(driver);
        Assert.assertEquals(resultsPage.getHeadingText(), "No Results Found");
        Assert.assertTrue(resultsPage.resultHeading.isDisplayed());

    }


    @Test(dataProvider = "data")
    public void searchHotelTestWithDataProvider(String city, String hotel) {

        //------------------ Test w wersji page object pattern z data providerem------------------//
        HotelSearchPages hotelSearchPages = new HotelSearchPages(driver);
        hotelSearchPages.setCity(city);
        hotelSearchPages.setDates("01/05/2022", "09/05/2022");
        hotelSearchPages.setTravelers(1, 2);
        hotelSearchPages.performSearch();

        ResultsPage resultsPage = new ResultsPage(driver);
        List<String> hotelNames = resultsPage.getHotelNames();
        System.out.println("Starting Asseretions");
        Assert.assertEquals(hotelNames.get(0), hotel);

        System.out.println("Asseretions done.");
    }

    public Object[][] data() throws IOException {
        return ExcelReader.readExcel("testData.xslx");

    }

}