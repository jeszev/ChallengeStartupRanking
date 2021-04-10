package com.challenge.selectores;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChallengeSelectores {
	
	private WebDriver website;
	By yourName = By.cssSelector("input[name='user-submitted-name']");
	By emailAdress = By.cssSelector("input[name='user-submitted-email']");
	By productTitle = By.name("user-submitted-title");
	By productUrl = By.xpath("//*[contains(@name,'user-submitted-url[]')]");
	By describeProduct = By.xpath("//*[contains(@name,'user-submitted-content')]");
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver");
		website = new ChromeDriver();
		website.manage().window().maximize();
		website.get("https://apprater.net/add/");
	}

	@Test
	public void completefields() throws InterruptedException {
		website.findElement(yourName).sendKeys("Rick Smith");
		website.findElement(emailAdress).sendKeys("rick@correo.com");
		website.findElement(productTitle).sendKeys("Kroma - Turn your photos into animations");
		website.findElement(productUrl).sendKeys("http://google.com");
		website.findElement(describeProduct).sendKeys("Kroma is an app that allows you to convert some images into a 15 second animation so you can share it on your social networks.");
	}
	
	@After
	public void tearDown() throws Exception {
		website.quit();
	}
}
