package utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CommonFunctions {	
	
	public static String randomString() {
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMddhhmmSS");
		Date date = new Date();	
		return 	dateFormat.format(date);
	}
	
	public static void highlight(WebElement element, WebDriver driver)
    {
        for (int i = 0; i <2; i++) 
        {
            try {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "color: black; border: 4px solid red;");
                Thread.sleep(100);
                js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element, "");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
}
