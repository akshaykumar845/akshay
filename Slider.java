package com.qt.scripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Slider {
	WebDriver driver;
	JavascriptExecutor jse;
	Actions actions;
	public void launch_browser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anwar\\Downloads\\chromedriver-win64 (2)\\chromedriver-win64\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://fitpeo.com/home");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		
		
	}
	public void navigate_to_calucatorpage() throws InterruptedException {
		driver.navigate().to("https://fitpeo.com/revenue-calculator");
		WebElement we=driver.findElement(By.xpath("//h4[text()='Medicare Eligible Patients']"));
		Thread.sleep(2000);
		jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",we);
		Thread.sleep(2000);
		}
	
	public void slider() {
		WebElement slider=driver.findElement(By.xpath("//span[@class='MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary MuiSlider-thumb MuiSlider-thumbSizeMedium MuiSlider-thumbColorPrimary css-1sfugkh']"));
	    Actions actions = new Actions(driver);
	    actions.dragAndDropBy(slider, 94, 0).perform();
	    
	    
	}
	
	public void update_text_field() throws InterruptedException {
		Actions actions = new Actions(driver);
		WebElement text_box=driver.findElement(By.xpath("//input[@type=\"number\"]"));
		text_box.click();
		actions.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(1000);
		actions.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(1000);
		text_box.sendKeys("560");
		Thread.sleep(3000);
		
	}
	
	public void check_box() throws InterruptedException {
		WebElement check_box=driver.findElement(By.xpath("//p[text()='CPT-99091']"));
		jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",check_box);
		driver.findElement(By.xpath("(//input[@class=\"PrivateSwitchBase-input css-1m9pwf3\"])[1]")).click();
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
		actions.sendKeys(Keys.TAB).sendKeys(Keys.SPACE).perform();
		WebElement check_box4=driver.findElement(By.xpath("//p[text()='CPT-99453']"));
		jse.executeScript("arguments[0].scrollIntoView(true);",check_box4);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='15']")).click();
		Thread.sleep(2000);
		
	}
	
	public void update_text_field_to_820_again() throws InterruptedException {
		
		WebElement we=driver.findElement(By.xpath("//h4[text()='Medicare Eligible Patients']"));
		jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",we);
		Actions actions = new Actions(driver);
		WebElement text_box=driver.findElement(By.xpath("//input[@type=\"number\"]"));
		text_box.click();
		actions.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.BACK_SPACE).perform();
		Thread.sleep(2000);
		actions.sendKeys(Keys.BACK_SPACE).perform();
        Thread.sleep(2000);
		text_box.sendKeys("820");
		Thread.sleep(2000);
	}
	
	public void validate_total_reimbursment() {
		WebElement check_box=driver.findElement(By.xpath("//p[text()='CPT-99091']"));
		jse=(JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true);",check_box);
	}

	public static void main(String[] args) throws InterruptedException {
		Slider obj=new Slider();
		obj.launch_browser();
		obj.navigate_to_calucatorpage();
		obj.slider();
		obj.update_text_field();
		obj.check_box();
		obj.update_text_field_to_820_again();
		obj.validate_total_reimbursment();

	}

}
