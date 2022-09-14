package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Setup browser driver
		
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.chromedriver().setup();
		String driverpath = System.getProperty("webdriver.chromedriver.driver");
		System.out.println(driverpath);
		
		//Launch the browser
		
		ChromeDriver driver = new ChromeDriver();
		
		//Load the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//maximize the browser
		
		driver.manage().window().maximize();
		
		//Enter Username
		
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("DemoSalesManager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//Click on link 
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//Click on MyHome page link
		
		//driver.findElement(By.linkText("My Home")).click();
		
		//Click on Leads tab
		
		driver.findElement(By.linkText("Leads")).click();
		
		//Click on Create Lead
		
		driver.findElement(By.linkText("Create Lead")).click();
		
		//Enter the Form
		
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
				
		
		//Select Source from drop down
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
		
		
		driver.close();
		
		/*String leadValidation = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		
		System.out.println(leadValidation);

		if(leadValidation.equals("Viji")) {
		
		
		
			System.out.println(true);
		}else
			System.out.println(false);*/
		
	
	}

}
