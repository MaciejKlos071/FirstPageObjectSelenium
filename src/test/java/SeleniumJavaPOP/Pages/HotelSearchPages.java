package SeleniumJavaPOP.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HotelSearchPages {


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

    // --------------- Inicjalizacja zmiennych @FindBy za pomocą page object factory ----------------------- //
    public HotelSearchPages(WebDriver driver) {
        System.out.println("Initializing driver.");
        PageFactory.initElements(driver, this);
        System.out.println("Driver initialized");
        this.driver = driver;
    }

    // --------------- Metody na stronie ----------------------- //

    public void setCity(String cityName) {
        System.out.println("Setting city name:" + cityName);
        searchHotelSpan.click();
        searchHotelInput.sendKeys(cityName);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityName);
        driver.findElement(By.xpath(xpath)).click();
        System.out.println("Setting city done.");
    }

    public void setDates(String checkInData, String checkOutData) {
        System.out.println("Setting data in: " + checkInData);
        this.checkIn.sendKeys(checkInData);
        System.out.println("Setting data in: " + checkOutData);
        this.checkOut.sendKeys(checkOutData);
        System.out.println("Setting done.");
    }

    public void setTravelers(int adultsToAdd, int childToAdd) {
        travellersInput.click();
        System.out.println("Setting adults: " + adultsToAdd);
        addTraveler(adultPlusBtn, adultsToAdd);
        System.out.println("Setting child: " + childToAdd);
        addTraveler(childPlusBtn, childToAdd);
        System.out.println("Setting travelers done.");
    }

    private void addTraveler(WebElement travelerBtn, int numberOfTravelers) {
        System.out.println("Adding travelers: " +numberOfTravelers);
        for (int i = 0; i < numberOfTravelers; i++) {
            travelerBtn.click();
        }
        System.out.println("Setting travelers done.");
    }

    public void performSearch() {
        System.out.println("performing search.");
        searchButton.click();
        System.out.println("performing search done.");

    }

}
