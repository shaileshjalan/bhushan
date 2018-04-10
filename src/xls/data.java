package xls;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class data {
	FileInputStream fis;
	Workbook wb;
	Sheet sheet;
	@Test
public void hello(){
	String str= "C:\\Users\\shree\\Desktop\\pqr.xlt";
	
	try {
		fis = new FileInputStream(str);
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	try {
		wb = Workbook.getWorkbook(fis);
	} catch (BiffException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	sheet=wb.getSheet(0);
	//System.out.println(sheet.getCell(0,0).getContents());
	int row=sheet.getRows();
	int col=sheet.getColumns();
	for(int i=0;i<row;i++)
	{
		for(int j=0;j<col;j++){
			System.out.println(sheet.getCell(j,i).getContents());
		}
	}
	
}
}