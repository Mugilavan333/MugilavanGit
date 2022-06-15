package org.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.PageFactory;
import org.baseclassnew.BaseClass;

public class FindBy1 extends BaseClass {
	public FindBy1() {
		  PageFactory.initElements(driver, this);
		}
	    //FindBys
		@FindBys({@FindBy(id="email"),@FindBy(xpath="//input[@id='email']")})
		private List <WebElement> txtUsername;
		
	    //FindAll
		@FindAll({@FindBy(id="pass"),@FindBy(xpath="//input[@id='email']")})
		private WebElement txtPassword;
		
		@FindBy(id="login")
		private WebElement btnLogin;
		
		public List<WebElement> getTxtUsername() {
			return txtUsername;
		}
		public WebElement getTxtPassword() {
			return txtPassword;
		}
		public WebElement getBtnLogin() {
			return btnLogin;
		}
		private void userpassword() {
			System.out.println("userpassword");
		}

} 
