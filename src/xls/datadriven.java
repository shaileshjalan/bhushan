package xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.annotation.XmlInlineBinaryData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.annotations.VisibleForTesting;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class datadriven {
	@Test(dataProvider="softxls")
	public void hell(String username,String password){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shree\\Desktop\\class\\seleniumchrome\\chrom\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.xpath("//input[@type='submit']")).click();
	}
	
	
	@DataProvider(name="softxls")
	public Object[][] hello() throws BiffException, IOException{
	File src=new File("C:\\Users\\shree\\Desktop\\pqr.xls");
	FileInputStream fis=new FileInputStream(src);
	Workbook wb=Workbook.getWorkbook(fis);
	Sheet s=wb.getSheet("Sheet1");
	int row=s.getRows();
	int col=s.getColumns();
	String [][]data=new String[row][col];
   for(int i=0;i<row;i++){
	   for(int j=0;j<col;j++){
		   Cell c=s.getCell(j,i);
		   data[i][j]=c.getContents();
	   }
   }
return data;
}
}