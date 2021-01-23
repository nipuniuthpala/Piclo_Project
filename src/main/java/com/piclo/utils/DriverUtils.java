package com.piclo.utils;
import com.piclo.models.Frontend;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.piclo.common.Constants;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DriverUtils {


    public static List<Frontend> getTableValues() {

        System.setProperty("webdriver.chrome.driver",Constants.chromedriver );
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Navigate to the  website
        driver.get("http://localhost:8000/competitions.html");

        //To locate rows of table.
        List< WebElement > rows_table = driver.findElements(By.className("bid-data"));
        List<Frontend> data=new ArrayList<>();
        //To calculate no of rows In table.
        int rows_count = rows_table.size();
        //Loop will execute till the last row of table.
        for (int row = 0; row < rows_count; row++) {
            //To locate columns(cells) of that specific row.
            //To calculate no of columns (cells). In that specific row.
            List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("span"));
            String competition = Columns_row.get(0).getText();
            String buyer = Columns_row.get(1).getText();
            String seller = Columns_row.get(2).getText();
            String bid = Columns_row.get(3).getText();
            Frontend frontend=new Frontend();
            frontend.setCompetition_id(competition);
            frontend.setBid_count(bid);
            frontend.setBuyer(buyer);
            frontend.setSeller(seller);
            data.add(frontend);

        }


        driver.quit();
        return data;

    }

    public static List<Frontend> getCompetitionColumnValuesAfterSort() {

        System.setProperty("webdriver.chrome.driver",Constants.chromedriver );
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Navigate to the  website
        driver.get("http://localhost:8000/competitions.html");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement input= driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/label/input"));
        input.click();
        input.clear();
        input.sendKeys("Competition");
        //To locate rows of table.
        List< WebElement > rows_table = driver.findElements(By.className("bid-data"));
        List<Frontend> data=new ArrayList<>();
        //To calculate no of rows In table.
        int rows_count = rows_table.size();
        //Loop will execute till the last row of table.
        for (int row = 0; row < rows_count; row++) {
            //To locate columns(cells) of that specific row.
            //To calculate no of columns (cells). In that specific row.
            List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("span"));
            String competition = Columns_row.get(0).getText();

            Frontend frontend=new Frontend();
            frontend.setCompetition_id(competition);
            data.add(frontend);

        }

        driver.quit();
        return data;

    }


    public static List<Frontend> getBidCountColumnValuesAfterSort() {

        System.setProperty("webdriver.chrome.driver",Constants.chromedriver );
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Navigate to the  website
        driver.get("http://localhost:8000/competitions.html");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement input= driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/label/input"));
        input.click();
        input.clear();
        input.sendKeys("Bid count");
        //To locate rows of table.
        List< WebElement > rows_table = driver.findElements(By.className("bid-data"));
        List<Frontend> data=new ArrayList<>();
        //To calculate no of rows In table.
        int rows_count = rows_table.size();
        //Loop will execute till the last row of table.
        for (int row = 0; row < rows_count; row++) {
            //To locate columns(cells) of that specific row.
            //To calculate no of columns (cells). In that specific row.
            List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("span"));
            String bid = Columns_row.get(3).getText();
            Frontend frontend=new Frontend();
            frontend.setBid_count(bid);
            data.add(frontend);

        }

        driver.quit();
        return data;

    }


    public static List<Frontend> getBuyerColumnValuesAfterSort() {

        System.setProperty("webdriver.chrome.driver",Constants.chromedriver );
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Navigate to the  website
        driver.get("http://localhost:8000/competitions.html");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement input= driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/label/input"));
        input.click();
        input.clear();
        input.sendKeys("Buyer");
        //To locate rows of table.
        List< WebElement > rows_table = driver.findElements(By.className("bid-data"));
        List<Frontend> data=new ArrayList<>();
        //To calculate no of rows In table.
        int rows_count = rows_table.size();
        //Loop will execute till the last row of table.
        for (int row = 0; row < rows_count; row++) {
            //To locate columns(cells) of that specific row.
            //To calculate no of columns (cells). In that specific row.
            List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("span"));
            String buyer = Columns_row.get(1).getText();
            Frontend frontend=new Frontend();
            frontend.setBuyer(buyer);
            data.add(frontend);

        }

        driver.quit();
        return data;

    }

    public static List<Frontend> getSellersColumnValuesAfterSort() {

        System.setProperty("webdriver.chrome.driver",Constants.chromedriver );
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // Navigate to the  website
        driver.get("http://localhost:8000/competitions.html");

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement input= driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/label/input"));
        input.click();
        input.clear();
        input.sendKeys("Seller");
        //To locate rows of table.
        List< WebElement > rows_table = driver.findElements(By.className("bid-data"));
        List<Frontend> data=new ArrayList<>();
        //To calculate no of rows In table.
        int rows_count = rows_table.size();
        //Loop will execute till the last row of table.
        for (int row = 0; row < rows_count; row++) {
            //To locate columns(cells) of that specific row.
            //To calculate no of columns (cells). In that specific row.
            List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("span"));
            String seller = Columns_row.get(2).getText();
            Frontend frontend=new Frontend();
            frontend.setSeller(seller);
            data.add(frontend);

        }

        driver.quit();
        return data;

    }

}








