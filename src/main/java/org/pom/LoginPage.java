package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.baseclassnew.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		   PageFactory.initElements(driver,this);
		}
		@FindBy(id="email")
		private WebElement txtUsername;
		
		@FindBy(id="pass")
		private WebElement txtPassword;
		
		@FindBy(id="login")
		private WebElement btnLogin;

		public WebElement getTxtUsername() {
			return txtUsername;
		}

		public WebElement getTxtPassword() {
			return txtPassword;
		}

		public WebElement getBtnLogin() {
			return btnLogin;
		}
		

}
