package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		String driverpath = System.getProperty("webdriver.chromedriver.driver");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps/control/main");
		
driver.manage().window().maximize();
		
		//Enter Username
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("DemoSalesManager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
				
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		driver.findElement(By.linkText("Leads")).click();
			
		driver.findElement(By.linkText("Create Lead")).click();
					
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TCS");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Viji");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Vasu");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("TATA");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("Create Lead for Assignment");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("viji.vasu5@gmail.com");
		
		WebElement Stateselection = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		
		Select SSdd = new Select(Stateselection);
		SSdd.selectByVisibleText("New York");

		WebElement selectDropdown = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select dd = new Select(selectDropdown);
		dd.selectByValue("LEAD_CONFERENCE");
		
		driver.findElement(By.name("submitButton")).click();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equals("View Lead | opentaps CRM")) {
			System.out.println(true);
		}
			else {
				System.out.println(false);
		}
		
		//Duplicate Lead
		
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
		driver.findElement(By.id("createLeadForm_companyName")).clear();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TATA Consulting Service");
		
		driver.findElement(By.id("createLeadForm_firstName")).clear();
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Vijayalakshmi");
		
		driver.findElement(By.name("submitButton")).click();
		
		String duptitle = driver.getTitle();
		System.out.println(duptitle);
		
		if(duptitle.equals("View Lead | opentaps CRM")) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
		
		driver.close();

	}

}
