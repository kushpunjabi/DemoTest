package com.technocredits.base;

import java.beans.Visibility;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.constant.ConstantPath;

public class PredefinedActions {
	private static WebDriver driver;

	final static public void initialization() {
		System.setProperty(ConstantPath.chromedriverKey,
				ConstantPath.chromedriver);
		driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://automationbykrishna.com");

	}

	protected String acceptalert() {
		Alert alert = driver.switchTo().alert();
		String actualString = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		return actualString;

	}

	public static void close() {
		driver.close();
	}

	private WebElement getElemenet(String locator) {
		String[] loc = locator.split("]:-");
		String locatorType = loc[0].substring(1).toLowerCase();
		String locatorvalue = loc[1];
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		switch (locatorType) {
		case "id":

			element =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorvalue)));
		}
		return element;

	}

	protected void setText(String locator, String value) {
		WebElement element = getElemenet(locator);
		if (element.isEnabled()) {
			element.sendKeys(value);

		} else
			System.out.println("Elemenet is not visible");

	}

	protected void clickOnElement(String locator) {
		WebElement element = getElemenet(locator);
		if (element.isEnabled()) {
			element.click();
		} else {
			System.out.println("elemenet is not visiable");
		}
	}

}
