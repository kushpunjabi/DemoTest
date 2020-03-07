package com.technocredits;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.technocredits.base.PredefinedActions;
import com.technocredits.pages.RegistrationPage;

public class TestBase {

	@BeforeClass
	void start() {
		PredefinedActions.initialization();
	}

	RegistrationPage goto_registration() throws IOException {
		
		RegistrationPage RG = RegistrationPage.getObject();
		RG.goto_registration();
		return RG;

	}

	void goto_Demotable() {

	}

//	@AfterMethod(alwaysRun = true)
//	void close() {
//		PredefinedActions.close();
//	}
}
