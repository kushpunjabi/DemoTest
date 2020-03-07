package com.technocredits;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.technocredits.constant.ConstantPath;
import com.technocredits.pages.RegistrationPage;
import com.technocredits.util.ExcelFileOperations;

//com.technocredits

public class LoginTest extends TestBase {
	@Test(dataProvider = "LoginDataProvider")
	void loginData(String username, String password, String expectedresult) throws IOException {
		String expectedString = expectedresult;
		RegistrationPage ok = goto_registration();
		ok.Login(username, password);
		String actualString = ok.handleAlert();
		System.out.println(actualString);
		Assert.assertEquals(actualString, expectedString);

	}

	@DataProvider(name = "LoginDataProvider")
	public String[][] provideLoginData() throws IOException {

		String[][] data = ExcelFileOperations.readExcelData(
				ConstantPath.LoginDataworkBook, ConstantPath.LoginDataSheet);

		return data;

	}
	
	
	//ScreenshotCode
//	TakesScreenshot screenShot = (TakesScreenshot)driver;
//	File src = screenShot.getScreenshotAs(OutputType.FILE);
//	//File target = new File("./src/test/resources/screenshots/landingpage.png");
//	Files.copy(src, new File("./src/test/resources/screenshots/"+result.getMethod()+"_"+getTimeStamp()+".png"));

}
