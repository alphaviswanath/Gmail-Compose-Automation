package com.gmail.automate.send;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutomateGmail {
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException {
		String subject="Incubyte", body="Automation QA test for Incubyte";
		String[] emails={"nandutes0001@gmail.com","vivekvnath001@gmail.com"};
		String[] passwords= {"94Nandu@94","94Vivek@94"};
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\alpha\\Downloads\\Essentials\\Eclipse\\Webdrivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
		System.out.println("Entering email ID in the text field!");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("identifierId")).sendKeys(emails[0]);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		
		System.out.println("Entering password!");
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(passwords[0]);
		System.out.println("Clicking on Next and logging in...");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
		
		/*Verify Login*/
		String title="Gmail";
		if (driver.getTitle().contains(title)) {
			System.out.println("Logged in successfully to Gmail");
		}
		else {
			System.out.println("Unable to login to Gmail :( ");
		}
		
		Thread.sleep(000);
		System.out.println("Trying to compose a mail");
		driver.findElement(By.className("aic")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		System.out.println("Entering the email ID of the reciever!");
		driver.findElement(By.name("to")).sendKeys(emails[1]);
		
		System.out.println("Entering subject");
		driver.findElement(By.name("subjectbox")).sendKeys(subject);
		System.out.println("Entering contents of body");
		driver.findElement(By.xpath("//div[@aria-label='Message Body']")).sendKeys(body);
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println("Sending email!");
		driver.findElement(By.xpath("//div[contains(text(),'Send')]")).click();
		

		Thread.sleep(6000);
		System.out.println("Trying to find sent mail!");
		driver.findElement(By.xpath("//div[@data-tooltip='Sent']")).click();
				
		Thread.sleep(3000);
		System.out.println("Logging out of sender account!");
		driver.navigate().to("https://accounts.google.com/Logout?hl=en&continue=https://mail.google.com/mail&service=mail&timeStmp=1626034283&secTok=.AG5fkS8Ba7lG3voGeErSCVyoNTmBcu_uYQ&ec=GAdAFw");
		
		Thread.sleep(3000);
		System.out.println("Logging into the receiver account!");
		driver.navigate().to("https://accounts.google.com/signin/v2/identifier?continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&service=mail&sacu=1&rip=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		
		System.out.println("Entering receiver email ID in the text field!");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("identifierId")).sendKeys(emails[1]);
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click();
		
		System.out.println("Entering receiver password!");
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys(passwords[1]);
		System.out.println("Clicking on Next and logging in...");
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();
					
	}


}