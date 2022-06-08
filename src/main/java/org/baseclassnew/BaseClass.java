package org.baseclassnew;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
		
		public static WebDriver driver;
		
		public static WebDriver browserLaunch(String browsername) {
			if (browsername.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				WebDriver driver=new ChromeDriver();
			    }
	        else if (browsername.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				WebDriver driver=new EdgeDriver();
				}
	        else if (browsername.equalsIgnoreCase("firefox")) {
	        	WebDriverManager.firefoxdriver().setup();
	    		driver=new FirefoxDriver();
	    		
			}
			return driver;
					
			}
		public static WebDriver chromeBrowser() {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			return driver;
		}
		public static WebDriver edgeBrowser() {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver(); 
			return driver;
		}
		
		public static WebDriver firefoxBrowser() {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			return driver;
		}
		
		public static void urlLaunching(String url) {
			driver.get(url);
		}
		public static void Maximize() {
			driver.manage().window().maximize();
		
		}
		public static void implicitywait(long sec) {
			driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);

		}
	    public static void sendKeys(WebElement a,String value) {
	    	a.sendKeys(value);
			
		}
	    public static void click(WebElement b) {
	    	b.click();
	    }
	    public static void moveToElement(WebElement target) {
	    	Actions a=new Actions(driver);
	    	a.moveToElement(target).perform();
			

		}
		public static void selectByIndex(WebElement b,int index) {
			Select s=new Select(b);
			s.selectByIndex(index);
			
		}
		public static String title() {
			String title = driver.getTitle();
			return title;
			
		}
		public static String currentUrl() {
			String currentUrl = driver.getCurrentUrl();
			return currentUrl;
			
		}
		
		public static String getAttribute(WebElement c) {
			String att = c.getAttribute("value");
			return att;

		}
		
		public static void refresh() {
			driver.navigate().refresh();
		}
		
		public static String readExcel(String filename,String sheet,int row,int cell) throws IOException {
			File f=new File("C:\\Users\\my pc\\eclipse-workspace\\Mugilavan\\src\\test\\resources\\"+filename+".xlsx");
			FileInputStream fi=new FileInputStream(f);
			Workbook w=new XSSFWorkbook(fi);
			Sheet s = w.getSheet(sheet);
			Row r = s.getRow(row);
			Cell c = r.getCell(cell);
			int type = c.getCellType();
			
			String value=null;
			if (type==1) {
				value = c.getStringCellValue();
			}
			else {
				if (DateUtil.isCellDateFormatted(c)) {
					Date d = c.getDateCellValue();
					SimpleDateFormat sd=new SimpleDateFormat("yyyy-MMM-dd");
					value = sd.format(d);
									}
				else {
					double dou = c.getNumericCellValue();
					long num=(long)dou;
					value = String.valueOf(num);
		}
		
			}
			return value;
			}}

		
