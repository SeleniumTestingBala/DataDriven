package com.login;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DataDriven {
	static List<String> userNameList = new ArrayList<String>();
	static List<String> passwordList = new ArrayList<String>();

	public void launchBrowser(String user, String pass) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bala\\eclipse-workspace\\DataDriven\\chrome\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/");
		WebElement userName = driver.findElement(By.id("txtUsername"));
		userName.sendKeys(user);
		WebElement password = driver.findElement(By.id("txtPassword"));
		password.sendKeys(pass);
		WebElement btnLogin = driver.findElement(By.id("btnLogin"));
		btnLogin.click();

		driver.quit();
	}

	public void readExcel() throws IOException {

		FileInputStream file = new FileInputStream("C:\\Users\\Bala\\Downloads\\Bala.xlsx");
		Workbook workbook = new XSSFWorkbook(file);
		Sheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
		while (rowIterator.hasNext()) {
			Row rowValue = rowIterator.next();
			Iterator<Cell> columnIterator = rowValue.iterator();
			int i=2;
			while (columnIterator.hasNext()) {
				if (i%2==0) {
					userNameList.add(columnIterator.next().getStringCellValue());

				}else {
					passwordList.add(columnIterator.next().getStringCellValue());
				}
				i++;				
			}

		}

	}
	public void executeTest() {
		for (int i = 0; i < userNameList.size(); i++) {
		launchBrowser(userNameList.get(i), passwordList.get(i));	
		}
		
	}
	public static void main(String[] args) throws IOException {
		DataDriven a = new DataDriven();
		a.readExcel();
		System.out.println("UserName : "+ userNameList);
		System.out.println(" Password : " + passwordList);
		a.executeTest();
		
	}


}
