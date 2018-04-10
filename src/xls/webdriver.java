package xls;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class webdriver{
public static WebDriver driver;
	public static WebDriver getinstance(){
		if(driver==null){
			driver=new ChromeDriver();
}
		return driver;

	
}

}
