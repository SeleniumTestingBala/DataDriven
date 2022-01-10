package com.login;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

		static WebDriver driver;
		static Actions actions;
		static Robot robot;
		static Alert alert;
		static JavascriptExecutor js;
		static File file;
		static Select select;
		static WebDriverWait webwait;
		static Wait w1;
		static TakesScreenshot screenshot;
//1
		public WebDriver getDriver() {
			WebDriverManager.chromedriver().setup();
			
			driver=new ChromeDriver();

			driver.manage().window().maximize();
			
			return driver;

		}
//2		
		public void close() {
			driver.quit();
		}
//3
		public WebElement id(String idlocate) {
			
			WebElement e = driver.findElement(By.id(idlocate));
			return e;	
	}
//4
		public WebElement xpath(String Xpath) {
			WebElement e = driver.findElement(By.xpath(Xpath));
			return e;
		}
//5
		public WebElement className(String name) {
			WebElement e = driver.findElement(By.className(name));
			return e;
		}
//6		
		public void geturl(String url) {
			
			driver.get(url);	
		}
//7	
		public WebElement getAttributes(WebElement refname,String value) {
		
		refname.getAttribute(value);
		return refname;
		
	}
//8	
		public void getTitle() {
			
			driver.getTitle();
			}
//9
			public void getCurrentUrl() {
				
				driver.getCurrentUrl();

			}

//10	
		public void threadSleep(int ms) throws InterruptedException {
		
	Thread.sleep(ms);

	}
	
//11	
		public Actions actionsCreate() {
				actions=new Actions(driver);

				return actions;
			}
//12	
		public WebElement movetoElement(WebElement move) {
			
			
			actions.moveToElement(move).perform();
			return move;

		}
//13	
	public WebElement draganddrop(WebElement pick, WebElement drop) {
			
			
			actions.dragAndDrop(pick, drop).perform();
			return drop;

		}
//14
	public WebElement contextClick(WebElement d) {
		
		actions.contextClick(d).perform();
		return d;
		
	}
//15
	public Robot robot() throws AWTException {
		
		robot=new Robot();
		return robot;
		
	}

//16
	public void robotCapsLock() {
		
	robot.keyPress(KeyEvent.VK_CAPS_LOCK);
	robot.keyRelease(KeyEvent.VK_CAPS_LOCK);
		
		
	}
//17
	public void robotShift() {
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}
	
//18
	public void robotEnter() {
		
	robot.keyPress(KeyEvent.VK_ENTER);
	robot.keyRelease(KeyEvent.VK_ENTER);
		
	}
//19
	public void enumEnter(WebElement refname,String enumvalue) {
		
		refname.sendKeys(enumvalue,Keys.ENTER);
		
	}
//20

	public void actionDoubleClick(WebElement refname) {
		
		actions.doubleClick(refname).perform();

	}
//21

	public void alert() {
		
		 alert = driver.switchTo().alert();

	}

//22
	public void simpleAlert() {
		
	alert.accept();

	}
//23

	public void confirmAlert() {
		
	alert.dismiss();

	}
//24
	public void promptAlert(String value) {
		
	alert.sendKeys(value);
	alert.accept();

	}
//25

	public void screenShot() throws IOException {
		
		 screenshot=(TakesScreenshot)driver;
		
		
			}
//26
	public void filesUtil(String Filelocation) throws IOException {
	
	File screen = screenshot.getScreenshotAs(OutputType.FILE);
    file=new File(Filelocation+".png");
    FileUtils.copyFile(screen, file);

	}
	
//27
	public void javaScriptExecutor(){
		
		 js=(JavascriptExecutor)driver;
		 
		}

//28
	public void javaScriptsetAttribute(WebElement refname, String txt) {
		

	js.executeScript("arguments[0].setAttribute('value',"+txt+")", refname);
		
	}

//29
	public void javaScriptgetAttribute(WebElement refname) {
		

		Object txt = js.executeScript("return arguments[0].getAttribute('value')", refname);
		System.out.println(txt);
	}
//30
	public void javaScriptClick(WebElement refname) {
		

		js.executeScript("arguments[0].click()", refname);
		
	}
//31
	public void scrollUp(WebElement scrollUp) {
		
		js.executeScript("arguments[0].scrollIntoView(false)", scrollUp);

	}
//32
	public void scrollDown(WebElement scrollDown) {
		
		js.executeScript("arguments[0].scrollIntoView(true)",scrollDown);

	}
//33
	public void select(WebElement refname) {
		
		select=new Select(refname);

	}
//34
	public void selectByIndex(int a) {
		select.selectByIndex(a);

	}

//35
	public void selectByValue(String value) {
		select.selectByValue(value);

	}
//36
	public void selectByVisibleText(String value) {
		select.selectByVisibleText(value);
	}
//37

	public void getOptions() {
		
		select.getOptions();

	}
//38
	public void implicitwaitMillisec(long sec) {

		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.MILLISECONDS);

	}
//39
	public void implicitwaitseconds(long sec) {
		
		driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

	}
//40

	public void explicitWebdriverWait() {
		
		webwait=new WebDriverWait(driver, 5);

	}
//41

	public void webdriverWait(String value) {
		
		webwait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(value)));

	}
//42
	public void webelementframes(WebElement refname) {
		
		driver.switchTo().frame(refname);

	}
//43
	public void indexframes(int indexrefname) {
		
		driver.switchTo().frame(indexrefname);

	}
//44
	public void parentframes() {
		
		driver.switchTo().parentFrame();

	}
//45

	public void defaultContent() {
		
		driver.switchTo().defaultContent();

	}
//46
	public void parentWindow() {
		
	driver.getWindowHandle();	

	}
//47
	public void allwindowsId() {
	driver.getWindowHandles();	

	}
//48
	public void windowsIdString(String windId) {
		
		driver.switchTo().window(windId);
		

	}
//49
	public void webtableTagname(String tagvalue) {
		
		List<WebElement> refname = driver.findElements(By.tagName(tagvalue));
		

	}
//50
	public void findElementsXpath(String tagvalue) {
		
		List<WebElement> refname1 = driver.findElements(By.xpath(tagvalue));
		

	}
//51
	public void alertgetText() {
		
		alert.getText();

	}
//52
	public void navigateRefresh() {
		
		driver.navigate().refresh();

	}
//53
	public void navigateBack() {
		
		driver.navigate().back();

	}
//54
	public void navigateforward() {
		
		driver.navigate().forward();

	}
 //55
	public void multiselectFirstSelect() {
		
		select.getFirstSelectedOption();

	}
//56
	public void multiselectAllSelect() {
		
		select.getAllSelectedOptions();

	}
		


	}

