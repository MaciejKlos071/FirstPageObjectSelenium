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
    public HotelSearchPages(WebDriver driver){
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }



    public void setCity(String cityName){
        searchHotelSpan.click();
        searchHotelInput.sendKeys(cityName);
        String xpath = String.format("//span[@class='select2-match' and text()='%s']", cityName);
        driver.findElement(By.xpath(xpath)).click();
//        hotelMatch.click();
    }

    public void setDates(String checkInData, String checkOutData){
        this.checkIn.sendKeys(checkInData);
        this.checkOut.sendKeys(checkOutData);
    }

    public void setTravelers(int adultsToAdd, int childToAdd){

        travellersInput.click();
        addTraveler(adultPlusBtn,adultsToAdd);
        addTraveler(childPlusBtn,childToAdd);
    }

    private void addTraveler(WebElement travelerBtn, int numberOfTravelers){
        for (int i = 0; i < numberOfTravelers; i++) {
            travelerBtn.click();
        }

    }
    public void performSearch(){
        searchButton.click();
    }

//        driver.findElement(By.xpath("//span[contains(text(),'Search by H')]")).click();
//        driver.findElement(By.xpath("//div[@id='select2-drop']//input")).sendKeys("Dubai");
//        driver.findElement(By.xpath("//span[@class='select2-match']")).click();
//    //data wpisanie daty
//        driver.findElement(By.name("checkin")).sendKeys("12/04/2022");
//        driver.findElement(By.name("checkout")).sendKeys("17/04/2022");
//    //wybranie daty z kalendarza
//        driver.findElements(By.xpath("//td[@class='day ' and text()='28']")).stream()
//                .filter(WebElement::isDisplayed)
//                .findFirst()
//                .ifPresent(WebElement::click);
//        driver.findElement(By.id("travellersInput")).click();
//        driver.findElement(By.id("adultPlusBtn")).click();
//        driver.findElement(By.id("childPlusBtn")).click();
//        driver.findElement(By.xpath("//button[text()=' Search']")).click();
//    List<String> hotelNames = driver.findElements(By.xpath("//h4[contains(@class, 'list_title')]//b")).stream()
//            .map(el -> el.getAttribute("textContent"))
//            .collect(Collectors.toList());
//        System.out.println(hotelNames.size());

}
