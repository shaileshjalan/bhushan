package xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class DATAT {
	
	@Test(dataProvider="test")
	public void hello(String username,String pass){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\shree\\Desktop\\class\\seleniumchrome\\chrom\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.facebook.com");
		driver.findElement(By.id("email")).sendKeys(username);
		driver.findElement(By.id("pass")).sendKeys(pass);
		driver.close();

	}
	@DataProvider(name="test")
	public Object[][]Good() throws BiffException, IOException{
		
	File src=new File("C:\\Users\\shree\\Desktop\\pqr.xls");
	FileInputStream fis = new FileInputStream(src);
	Workbook wb = Workbook.getWorkbook(fis);
	Sheet sheet=wb.getSheet(0);
	int row=sheet.getRows();
	int col=sheet.getColumns();
	String[][] obj=new String[row][col];
	for(int i=0;i<row;i++){
		for(int j=0;j<col;j++){
			Cell c=sheet.getCell(j,i);
			obj [i][j]=c.getContents();
		}
	}
	return obj;
	}
}
   
  

	

