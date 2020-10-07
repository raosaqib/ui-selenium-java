package com.globalkinetic.swaglabs.basics;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.globalkinetic.swaglabs.ui.helper.logger.LoggerHelper;
import com.globalkinetic.swaglabs.ui.test.helper.wait.WaitHelper;

public class Basics {
	Logger log = LoggerHelper.getLogger(Basics.class);
	WaitHelper waithelper;
	WebElement element;
	String text;
	boolean status;

	protected WebDriver driver;

	protected Basics(WebDriver driver) {
		this.driver = driver;
		waithelper = new WaitHelper(driver);

	}

	protected String getAppTitle() {
		String title = driver.getTitle();
		return title;
	}

	protected WebElement getElement(WebElement ele) {
		return ele;
	}

	public String getText(WebElement element) {
		String text = element.getText();
		return text;
	}

	protected boolean clickWebelement(WebElement element) {
		try {
			if (element.isEnabled() || element.isDisplayed()) {

				element.click();

				return true;
			}

		} catch (Throwable t) {
			t.printStackTrace();
			System.out.print("t");
			return false;
		}
		return false;
	}

	protected boolean findElementAndFillText(WebElement element, String textNeedToPass) {
		try {
			if (textNeedToPass != null) {
				status = this.clickWebelement(element);
				if (status) {

					element.clear();
					element.sendKeys(textNeedToPass);
					return true;
				}
			}
		} catch (Throwable t) {
			t.printStackTrace();
			System.out.print("t");
		}
		return false;
	}

	protected boolean isDsiplayed(WebElement element) {
		try {
			element.isDisplayed();
			return true;
		} catch (Throwable t) {
			t.getStackTrace();
			System.out.println("element is not displayed");
			return false;
		}

	}

}