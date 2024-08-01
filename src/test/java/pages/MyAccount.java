package pages;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import base.BaseTest;

public class MyAccount extends BaseTest{

    public String credentials( String username, String password) throws Exception {

        System.out.println(driver.getTitle());
        WebDriverWait wait_username = new WebDriverWait(driver, 10);
        wait_username.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locators.getProperty("user_field")))));
        Thread.sleep(1000);
        driver.findElement(By.xpath(locators.getProperty("user_field"))).sendKeys(username);
        Thread.sleep(1000);
        driver.findElement(By.xpath(locators.getProperty("pw_field"))).sendKeys(password);
        Thread.sleep(1000);
        //System.out.println("Inserted on password");
        driver.findElement(By.xpath(locators.getProperty("button_submit"))).click();
        //System.out.println("LOGGED IN");
        String name = driver.findElement(By.xpath(locators.getProperty("student_name"))).getText();
        //System.out.println(name);
        //driver.findElement(By.xpath(locators.getProperty("logout_button"))).click();
        return name;
    }

    public int menulist(String student_name){
        List<WebElement> allOptionsToPick = driver.findElements(By.xpath(locators.getProperty("menu_list")));
        System.out.println("Below are listed all the options to pick for student: "+student_name);
        System.out.println("-----");
        for(WebElement option : allOptionsToPick) {
            System.out.println(option.getText());
            //System.out.println("-----");
        }
        return allOptionsToPick.size();
    }

    public String lessons() throws Exception {
        Thread.sleep(3000);
        driver.findElement(By.xpath(locators.getProperty("lessons"))).click();
        System.out.println("lessons page!!");
        Thread.sleep(3000);

        driver.findElement(By.xpath(locators.getProperty("maths"))).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath(locators.getProperty("maths"))).getText());
        List<WebElement> mathsarguments = driver.findElements(By.xpath(locators.getProperty("subject_table")));

        for (WebElement row : mathsarguments) {

            System.out.println(row.getText());
            System.out.println("-----");
        }

        driver.findElement(By.xpath(locators.getProperty("informatica"))).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.xpath(locators.getProperty("informatica"))).getText());
        List<WebElement> infoarguments = driver.findElements(By.xpath(locators.getProperty("subject_table")));
        for (WebElement row : infoarguments) {
            System.out.println(row.getText());
            System.out.println("-----");
        }

        return null;
    }

}
