package com.duckduckgo.features;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;

public class CheckWebPageTitleTest extends PageObject {

	@Test
	public void testTitleEquals() {

		browseWeb();

		// interact with any element on page
		getDriver().findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		getDriver().findElement(By.id("search_button_homepage")).click();

		// check something: Web page title
		String acutalTitle = getDriver().getTitle();
		String actualExpect = "Selenium Vietnam at DuckDuckGo";

		// Verify
		assertEquals(acutalTitle, actualExpect);
	}

	@Test
	public void testTitleNotEquals() {

		// set browser is Coccoc using chromeOptions
		// ChromeOptions options = new ChromeOptions();
		// options.setBinary("C:\\Users\\tranvan\\AppData\\Local\\CocCoc\\Browser\\Application\\browser.exe");
		// chromeDriver = new ChromeDriver(options);

		browseWeb();

		// find element
		getDriver().findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		getDriver().findElement(By.id("search_button_homepage")).click();

		String actualString = getDriver().getTitle();
		String expectedString = "SeleniumVietnam";

		// Verify
		assertNotEquals(actualString, expectedString);
	}

	@Test
	public void testTitleContains() {

		browseWeb();
		// find element
		getDriver().findElement(By.id("search_form_input_homepage")).sendKeys("Selenium Vietnam");
		getDriver().findElement(By.id("search_button_homepage")).click();

		String actualString = getDriver().getTitle();
		String expectedString = "Seleniumvn";

		// Verify
		// "Page title is contain "+expectedString,
		assertTrue(actualString.contains(expectedString));
	}
}