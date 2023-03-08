package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

@Epic("EPIC - 100: design login for open cart app")
@Story("US-Login: 101: design login page features for open cart")
public class LoginPageTest extends BaseTest{

	@Severity(SeverityLevel.TRIVIAL)
	@Description("....checking the title of the page.... tester: Naveen")
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actualTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}
	
	@Severity(SeverityLevel.NORMAL)
	@Description("....checking the url of the page.... tester: Naveen")
	@Test(priority=2)
	public void loginPageURLTest() {
		String actualURL=loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}
	
	@Severity(SeverityLevel.CRITICAL)
	@Description("....checking forgot pwd link exist.... tester: Naveen")
	@Test(priority=3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}
	
	
	@Test(priority=4)
	public void LogoExistTest() {
		Assert.assertTrue(loginPage.isLogoExist());
	}
	
	@Test(priority=5)
	public void isCartExistTest() {
		Assert.assertTrue(loginPage.isCartExist());
	}
	
	@Test(priority=6)
	public void isSearchBoxExistTest() {
		Assert.assertTrue(loginPage.isSearchBoxExist());
	}
	
	@Test(priority=7)
	public void isContinuLinkExistTest() {
		Assert.assertTrue(loginPage.isContinueLinkExist());
	}
	
	@Test(priority=8)
	public void isOrderHistoryLinkExistTest() {
		Assert.assertTrue(loginPage.isOrderHistoryLinkExist());
	}
	
	@Severity(SeverityLevel.BLOCKER)
	@Description("....checking user is able to login to app with correct username and password....")
	@Test(priority=9)
	public void loginTest() {
		loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
	}
}