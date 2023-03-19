package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountsPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By logoutlink=By.linkText("Logout");
	private By accsHeaders=By.cssSelector("div#content h2");
	private By search=By.name("search");
	private By searchIcon=By.cssSelector("#search button");
	
	//Creating constructor of AccountsPage
	public AccountsPage(WebDriver driver) {
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	
	public String getAccountsPageTitle() {
		String title= eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_SMALL_TIME_OUT, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
		System.out.println("Acc Page Title is: "+title);
		return title;
	}
	
	public String getAccountsPageUrl() {
		String Url= eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_SMALL_TIME_OUT, AppConstants.ACCOUNTS_PAGE_URL_FRACTION_VALUE);
		System.out.println("Acc Page Title: "+Url);
		return Url;
	}
	
	public boolean isLogoutLinkExist() {
		return eleUtil.waitForElementVisible(logoutlink, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
	}
	
	public boolean isSearchExist() {
		return eleUtil.waitForElementVisible(search, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
	}
	
	public List<String> getAccountsPageHeaderList() {
		List<WebElement> accHeadersList=eleUtil.waitForElementsVisible(accsHeaders, AppConstants.DEFAULT_MEDIUM_TIME_OUT);
		//List<WebElement> accHeadersList=driver.findElements(accsHeaders);
		List<String>accHeadersValList=new ArrayList<String>();
		
		for(WebElement e:accHeadersList) {
			String text=e.getText();
			accHeadersValList.add(text);
		}
		return accHeadersValList;
	}
	
public SearchPage performSearch(String searchKey) {
		
		if(isSearchExist()) {
			eleUtil.doSendKeys(search, searchKey);
			eleUtil.doClick(searchIcon);
			return new SearchPage(driver);
		}
		else {
			System.out.println("Search field is not present on the page....");
			return null;
		}
}


}
