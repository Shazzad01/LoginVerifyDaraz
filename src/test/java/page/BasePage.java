package page;

import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Driver_Setup;

import java.io.ByteArrayInputStream;
import java.util.List;
import java.util.Locale;

public class BasePage extends Driver_Setup {
    public WebElement getElement(By locator){
        return getDriver().findElement(locator);

    }
    public void clickOnElement(By locator){
        getElement(locator).click();

    }
    public void writeOnElement(By locator, String text){
        getElement(locator).clear();
        getElement(locator).sendKeys(text);
    }

    public String getElementText(By locator){
        return getElement(locator).getText();

    }
    public String getCurrentPageUrl(){
        return getDriver().getCurrentUrl();

    }
    public String getTitle(){
        return getDriver().getTitle();

    }
    public void sendTextOnElement(WebElement element, String value){
        element.clear();
        element.sendKeys(value);
    }

    public void hover(By locator){
        Actions actions = new Actions(getDriver());
        actions.clickAndHold(getElement(locator)).build().perform();

    }
    public void shadowDomePopup(WebElement host,By element){
        SearchContext context = host.getShadowRoot();
        context.findElement(element).click();
    }

    public void selectItemByValue(WebElement element, String value){

        Select selectItems = new Select(element);
        selectItems.selectByValue(value);

    }
    public void selectItemByVisibleText(WebElement element,String value){
        Select selectItems = new Select(element);
        selectItems.selectByVisibleText(value);
    }
    public void selectItemByIndex(WebElement element, int index){
        Select selectItems = new Select(element);
        selectItems.selectByIndex(index);
    }

    public String selectedItemText(WebElement element){
        Select selectItems = new Select(element);
        return selectItems.getFirstSelectedOption().getText();

    }

    public boolean itemsSelectedStatus(List<WebElement> elements, String value){
        for (WebElement element: elements){
            if (element.getAttribute("value").equals(value)){
                return  element.isSelected();
            }
        }
        return false;

    }

    public void clickOnNthNumberButtton(List<WebElement> elements, int position){
        elements.get(position - 1).click();

    }

    public void listItem(List<WebElement> elements, String visibleText){
        for (WebElement element:elements){
            if(element.getText().equals(visibleText)){
                element.click();
                break;
            }
        }
    }
    /****************************
     * Faker Related Task *
     ****************************
     */

    static Faker faker = new Faker(new Locale("en-US"));

    public String emailGenerate() {
        return faker.bothify("????##@mail.com");
    }

    public String firstNameGenerate() {
        return faker.name().firstName();
    }

    public String lastNameGenerate() {
        return faker.name().lastName();
    }

    public String zipCodeGenerate(){return faker.address().zipCode();}

    public String phoneNumberGenerate() {
        return faker.numerify("###-###-####");
    }

    public String passwordGenerate() {
        return faker.animal().name();
    }
    public void takeScreenShot(String name){
        Allure.addAttachment(name, new ByteArrayInputStream(((TakesScreenshot)(getDriver())).getScreenshotAs(OutputType.BYTES)));
    }

}
