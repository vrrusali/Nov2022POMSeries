package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

import io.qameta.allure.Step;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	// 1.private by locators:
	private By emailId = By.id("input-email");
	private By passwd = By.id("input-password");
	private By loginbtn = By.xpath("//input[@value='Login']");
	private By ForgotPwdLink = By.linkText("Forgotten Password");
	private By logo=By.id("logo");
	private By cart=By.id("cart");
	private By searchBox=By.id("search");
	private By Continuelink=By.linkText("Continue");
	private By OrderHistorylink=By.linkText("Order History");
	private By registerLink=By.linkText("Register");

	// 2. Page constructor..
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil=new ElementUtil(driver);
	}

	// 3. Page actions/methods
	@Step("....getting the login page title.....")
	public String getLoginPageTitle() {
		String title= eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SMALL_TIME_OUT, AppConstants.LOGIN_PAGE_TITLE_VALUE);
		System.out.println("The Page title:" + title);
		return title;
	}

	// LoginPageURL
	@Step("....getting the login page URL.....")
	public String getLoginPageURL() {
		String url=eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIME_OUT, AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE);
		System.out.println("The Page title:" + url);
		return url;
	}

	// Forgot Passwd link exist or nt
	@Step("....getting the forgot pwd link.....")
	public boolean isForgotPwdLinkExist() {
		return eleUtil.waitForElementVisible(ForgotPwdLink, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
	}
	
	@Step("login with username : {0} and password: {1}")
	public AccountsPage doLogin(String un, String Pwd) {
		System.out.println("App cred are:"+ un +":"+ Pwd);
		eleUtil.waitForElementVisible(emailId, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(un);
		eleUtil.doSendKeys(passwd, Pwd);
		eleUtil.doClick(loginbtn);
		return new AccountsPage(driver);
	}
	
	public boolean isLogoExist() {
		return driver.findElement(logo).isDisplayed();
	}
	
	public boolean isCartExist() {
		return driver.findElement(cart).isDisplayed();
	}
	
	public boolean isSearchBoxExist() {
		return driver.findElement(searchBox).isDisplayed();
	}
	
	public boolean isContinueLinkExist() {
		return driver.findElement(Continuelink).isDisplayed();
	}
	
	public boolean isOrderHistoryLinkExist() {
		return driver.findElement(OrderHistorylink).isDisplayed();
	}
	
	@Step("navigating to register page")
	public RegisterPage navigateToRegisterPage(){
		eleUtil.doClick(registerLink);
		return new RegisterPage(driver);
	}
}
