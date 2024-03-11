import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindElementAndCheckCart {

     WebDriver driver;
    String username="standard_user";
    String password="secret_sauce";

    By usernameField=By.xpath("//input[@ placeholder='Username']");
    By passwordField=By.id("password");
    By loginField=By.id("login-button");
    By shoppingCart = By.id("shopping_cart_container");

 //   By itemShoppingCart = By.xpath("//div[@class='inventory_item_name'][contains(text(), 'Sauce Labs Bike Light')]");


//  By button = By.xpath("//div[@class=\"inventory_item_name \"][contains(text(),\"Sauce Labs Bike Light\")]/../../../div[2]/button\n");
//div/div/div/div/div/div[3]/a/span
// css selector #shopping_cart_container>a>span
// //*[@id='cart_contents_container'][contains(.,'Sauce Labs Backpack')]

    // /html/body/div/div/div/div[2]/div/div[1]/div[3]/div[2]/a/div
    // //div[@class="cart_item_label"][contains(., 'Sauce Labs Backpack')]


    public By itemName(String itemName){
        String newButtonGeneric = String.format("//div[@class=\"inventory_item_name \"][contains(text(), \"%s\")]/../../../div[2]/button", itemName);
        By button = By.xpath(newButtonGeneric);
        return button;

    }

    public By itemNameShoppingCart(String itemName){
        String newButtonGeneric = String.format("//div[@class='inventory_item_name'][contains(text(), '%s')]", itemName);
        By button = By.xpath(newButtonGeneric);
        return button;

    }

    @Test
    public void testDemo() {
        String itemTest= "Sauce Labs Bike Light";
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        By button = itemName(itemTest);
        driver.findElement(usernameField).sendKeys(username);
        driver.findElement(passwordField).sendKeys(password);
        driver.findElement(loginField).click();
        WebElement buttonSelector =  driver.findElement(button);
        buttonSelector.click();
        driver.findElement(shoppingCart).click();
        By itemShoppingCart = itemNameShoppingCart(itemTest);
        WebElement itemShopping =  driver.findElement(itemShoppingCart);
        Assert.assertTrue(itemShopping.isDisplayed(), "not found sorry");
        driver.quit();

//div[@class="inventory_item_name "][contains(text(),"Sauce Labs Bike Light")]/../../../div[2]/button

    }



}