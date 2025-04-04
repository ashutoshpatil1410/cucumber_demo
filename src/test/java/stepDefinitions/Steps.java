package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	WebDriver driver;
	@Given("the user is on the nopcommerce login page")
	public void the_user_is_on_the_nopcommerce_login_page() {
	     driver=new EdgeDriver();
	    driver.get("https://demo.nopcommerce.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    driver.findElement(By.xpath("//a[text()='Log in']")).click();
		
	}

	@When("the user enters valid credentials\\(username:{string}, password :{string})")
	public void the_user_enters_valid_credentials_username_password(String username, String password) {
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys(password);
	    
	}

	@When("the user clicks on the login button")
	public void the_user_clicks_on_the_login_button() {
	    
		driver.findElement(By.xpath("//button[text()='Log in']")).click();
	}
	@Then("the user should be redirected to the my account page")
	public void the_user_should_be_redirected_to_the_my_account_page() {
	   boolean status=driver.findElement(By.xpath("//a[text()='My account' and @class='ico-account']")).isDisplayed();
	   Assert.assertEquals(status, true);
	}

	@Then("the user shoudl see a welcome message")
	public void the_user_shoudl_see_a_welcome_message() {
	   boolean status= driver.findElement(By.xpath("//h2[starts-with(text(),'Welcome')]")).isDisplayed();
	   Assert.assertTrue(status);
	}

}
