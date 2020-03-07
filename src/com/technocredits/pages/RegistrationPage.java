package com.technocredits.pages;

import java.io.IOException;

import javax.management.relation.RelationServiceNotRegisteredException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.technocredits.base.PredefinedActions;
import com.technocredits.constant.ConstantPath;
import com.technocredits.util.PropertyFileOperation;

public class RegistrationPage extends PredefinedActions {

	private static RegistrationPage registration=null;
	private String unameID = "";
	private String passwordID = "";
	private String checkboxID = "";
	private String buttonID = "";
	private String registrationbutton = "";
	public PropertyFileOperation probop;
	private String Fullname,Address,EmailID,city,Company,Uname="";

	private RegistrationPage() {

		try {
			probop = new PropertyFileOperation(
					ConstantPath.registrationPageLocator);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static RegistrationPage getObject() {
		if (registration == null) {
			registration = new RegistrationPage();
		}
		return registration;

	}

	public void Login(String username, String password) throws IOException {
		unameID = probop.readProp("txtuname");
		passwordID = probop.readProp("txtpassword");
		checkboxID = probop.readProp("chkbox");
		buttonID = probop.readProp("button");
		setTextonRegistrationpage(unameID, username);
		setTextonRegistrationpage(passwordID, password);
		clickevent(checkboxID);
		clickevent(buttonID);
	}

	public String handleAlert() {
		return acceptalert();

	}

	private void setTextonRegistrationpage(String locator, String value) {
		setText(locator, value);

	}

	public void clickevent(String locator)

	{
		clickOnElement(locator);
	}

	public RegistrationPage goto_registration() throws IOException {
		registrationbutton = probop.readProp("registrationlink");
		clickOnElement(registrationbutton);
		return this;

	}

	public void RegistrationEnterData(String Name, String Pata, String ID, String Sehar, String Organiza,String AchaName) throws IOException {
		Fullname = probop.readProp("Fullname");
		Address = probop.readProp("Address");
		EmailID = probop.readProp("EmailID");
		city = probop.readProp("city");
		Company = probop.readProp("Company");
		Uname = probop.readProp("Userbame");
		setTextonRegistrationpage(Fullname, Name);
		setTextonRegistrationpage(Address, Pata);
		setTextonRegistrationpage(EmailID, ID);
		setTextonRegistrationpage(city, Sehar);
		setTextonRegistrationpage(Company, Organiza);
		setTextonRegistrationpage(Uname, AchaName);

	}
}
