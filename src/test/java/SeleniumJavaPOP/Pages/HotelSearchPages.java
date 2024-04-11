package SeleniumJavaPOP.Pages;

import SeleniumJavaPOP.utils.SeleniumHelper;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.Logger;
//import org.apache.logging.log4j.LogManager;


//import java.util.logging.LogManager;

public class HotelSearchPages extends SeleniumHelper{


    @FindBy(xpath = "//span[contains(text(),'Search by H')]")
    private WebElement searchHotelSpan;

    @FindBy(xpath = "//div[@id='select2-drop']//input")
    private WebElement searchHotelInput;

    @FindBy(xpath = "//span[@class='select2-match']")
    private WebElement hotelMatch;

    @FindBy(name = "checkin")
    private WebElement checkIn;

    @FindBy(name = "checkout")
    private WebElement checkOut;
    @FindBy(id = "travellersInput")
    private WebElement travellersInput;
    @FindBy(id = "adultPlusBtn")
    private WebElement adultPlusBtn;

    @FindBy(id = "childPlusBtn")
    private WebElement childPlusBtn;

    @FindBy(xpath = "//button[text()=' Search']")
    private WebElement searchButton;

    private WebDriver driver;

    private static final Logger logger = LogManager.getLogger();

    // --------------- Inicjalizacja zmiennych @FindBy za pomocą page object factory ----------------------- //
    public HotelSearchPages(WebDriver driver) {
        logger.info("Initializing driver.");
        PageFactory.initElements(driver, this);
        logger.info("Driver initialized");
        this.driver = driver;
    }

    // --------------- Metody na stronie ----------------------- //

    public void setCity(String cityName) {
        logger.info("Setting city name:" + cityName);
        clickElement(driver,searchHotelSpan);
        setInputField(driver,searchHotelInput,cityName);
        clickElement(driver,driver.findElement
                (By.xpath(String.format("//span[@class='select2-match' and text()='%s']",cityName))));
        logger.info("Setting city done.");
    }

    public void setDates(String checkInData, String checkOutData) {
        logger.info("Setting data in: " + checkInData);
        setInputField(driver,checkIn,checkInData);
        logger.info("Setting data in: " + checkOutData);
        setInputField(driver,checkOut,checkOutData);
        logger.info("Setting done.");

    }

    public void setTravelers(int adultsToAdd, int childToAdd) {
        clickElement(driver,travellersInput);
        logger.info("Setting adults: " + adultsToAdd);
        addTraveler(adultPlusBtn, adultsToAdd);
        logger.info("Setting child: " + childToAdd);
        addTraveler(childPlusBtn, childToAdd);
        logger.info("Setting travelers done.");
    }

    private void addTraveler(WebElement travelerBtn, int numberOfTravelers) {
        logger.info("Adding travelers: " +numberOfTravelers);
        for (int i = 0; i < numberOfTravelers; i++) {
            clickElement(driver,travelerBtn);
        }
        logger.info("Setting travelers done.");
    }

    public void performSearch() {
        logger.info("performing search.");
        clickElement(driver,searchButton);
        logger.info("performing search done.");

    }

}
