package StepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test_Steps {

	public static WebDriver driver = null;
	private String URL = "https://reqres.in";

	@Given("User Launches the chromebrowser")
	public void user_launches_the_chromebrowser() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\HOME\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Given("Navigates to the URL")
	public void navigates_to_the_url() {
		driver.get(URL);
		driver.manage().window().maximize();

	}

	@Then("Verify the title of the page")
	public void verify_the_title_of_the_page() {

		String Expected_Title = "Reqres - A hosted REST-API ready to respond to your AJAX requests";
		String Actual_Title = driver.getTitle();
		org.junit.Assert.assertEquals(Expected_Title, Actual_Title);

	}

	@When("I click on the GET button method for List User")
	public void i_click_on_the_button_method_for_list_user() {

		driver.findElement(By.xpath("//li[@data-id='users']")).click();

	}

	@Then("Verify the Associate method end point for List User")
	public void verify_the_associate_method_end_point_for_list_user() {
		String End_point_url = driver.findElement(By.xpath("//*[@class='url']")).getText();
		System.out.println("End Point URL for GET--> List Users method is " + End_point_url);


	}

	@Then("Verify Associated method Response for List User should be displayed")
	public void verify_associated_method_response_for_list_user_should_be_displayed() {
		String Respcode = driver.findElement(By.xpath("//*[@class='response-code']")).getText();
		System.out.println("Response Code is "+Respcode);
		String output_resp = driver.findElement(By.xpath("//*[@data-key='output-response']")).getText();
		System.out.println("Out put response is "+output_resp);

	}

	@Then("Verify Whether Support displayed or not Under List User")
	public void verify_whether_support_displayed_or_not_under_list_user() {
		Boolean Display = driver.findElement(By.xpath("//button[text()='Support ReqRes']")).isDisplayed();
		//To print the value
		System.out.println("Support ReqRes Button displayed is :"+Display);

		driver.close();
	}

	@When("I click on the GET button method for Single User")
	public void i_click_on_the_button_method_for_single_user() {

		driver.findElement(By.xpath("//li[@data-id='users-single']")).click();

	}

	@Then("Verify the Associate method end point for Single User")
	public void verify_the_associate_method_end_point_for_single_user() {
		String End_point_url = driver.findElement(By.xpath("//*[@class='url']")).getText();
		System.out.println("End Point URL for GET--> Single User method is " + End_point_url);

	}

	@Then("Verify Associated method Response for Single User  should be displayed")
	public void verify_associated_method_response_for_single_user_should_be_displayed() {

		String Respcode = driver.findElement(By.xpath("//*[@class='response-code']")).getText();
		System.out.println("Response Code is "+Respcode);
		String output_resp = driver.findElement(By.xpath("//*[@data-key='output-response']")).getText();
		System.out.println("Out put response is "+output_resp);

	}

	@Then("Verify Whether Support displayed or not Under Single User")
	public void verify_whether_support_displayed_or_not_under_single_user() {

		Boolean Display = driver.findElement(By.xpath("//button[text()='Support ReqRes']")).isDisplayed();
		//To print the value
		System.out.println("Support ReqRes Button displayed is :"+Display);

		driver.close();

	}

	@When("I click on the GET button method for Single User not Found")
	public void i_click_on_the_button_method_for_single_user_not_found() {

		driver.findElement(By.xpath("//li[@data-id='users-single-not-found']")).click();



	}

	@Then("Verify the Associate method end point for Single User not Found")
	public void verify_the_associate_method_end_point_for_single_user_not_found() {

		String End_point_url = driver.findElement(By.xpath("//*[@class='url']")).getText();
		System.out.println("End Point URL for GET--> Single User Not Found method is " + End_point_url);

	}

	@Then("Verify Associated method Response for Single User not Found  should be displayed")
	public void verify_associated_method_response_for_single_user_not_found_should_be_displayed() {

		String Respcode = driver.findElement(By.xpath("//span[@data-key='response-code']")).getText();
		System.out.println("Response Code is "+Respcode);
		String output_resp = driver.findElement(By.xpath("//pre[@data-key='output-response']")).getText();
		System.out.println("Out put response is "+output_resp);

	}

	@Then("Verify Whether Support displayed or not Under Single User not Found")
	public void verify_whether_support_displayed_or_not_under_single_user_not_found() {

		Boolean Display = driver.findElement(By.xpath("//button[text()='Support ReqRes']")).isDisplayed();
		//To print the value
		System.out.println("Support ReqRes Button displayed is :"+Display);

		driver.close();

	}


	@When("I click on the POST button method for Create User")
	public void i_click_on_the_post_button_method_for_create_user() {

		driver.findElement(By.xpath("//li[@data-id='post']")).click();

	}

	@Then("Verify the Associate method end point for Create User")
	public void verify_the_associate_method_end_point_for_create_user() {

		String End_point_url = driver.findElement(By.xpath("//*[@class='url']")).getText();
		System.out.println("End Point URL for POST Create User method is " + End_point_url);

	}

	@Then("Verify the Body of the request for Create User")
	public void verify_the_body_of_the_request_for_create_user() {

		String body = driver.findElement(By.xpath("//pre[@data-key='output-request']")).getText();

		System.out.println(body);
	}

	@Then("Verify Associated method Response for Create User  should be displayed")
	public void verify_associated_method_response_for_create_user_should_be_displayed() {

		String Respcode = driver.findElement(By.xpath("//*[@class='response-code']")).getText();
		System.out.println("Response Code is "+Respcode);
		String output_resp = driver.findElement(By.xpath("//*[@data-key='output-response']")).getText();
		System.out.println("Out put response is "+output_resp);

	}

	@Then("Verify Whether Support displayed or not Under Create User Page")
	public void verify_whether_support_displayed_or_not_under_create_user_page() {

		Boolean Display = driver.findElement(By.xpath("//button[text()='Support ReqRes']")).isDisplayed();
		//To print the value
		System.out.println("Support ReqRes Button displayed is :"+Display);

		driver.close();

	}


	@When("I click on the PUT button method for  Update User")
	public void i_click_on_the_put_button_method_for_update_user() {

		driver.findElement(By.xpath("//li[@data-id='put']")).click();	
	}
	@Then("Verify the Associate method end point for Update User")
	public void verify_the_associate_method_end_point_for_update_user() {

		String End_point_url = driver.findElement(By.xpath("//*[@class='url']")).getText();
		System.out.println("End Point URL for PUT Update User method is " + End_point_url);

	}
	@Then("Verify the Body of the request for Update User")
	public void verify_the_body_of_the_request_for_update_user() {

		String body = driver.findElement(By.xpath("//pre[@data-key='output-request']")).getText();

		System.out.println(body);
	}


	@Then("Verify Associated method Response for Update User  should be displayed")
	public void verify_associated_method_response_for_update_user_should_be_displayed() {

		String Respcode = driver.findElement(By.xpath("//*[@class='response-code']")).getText();
		System.out.println("Response Code is "+Respcode);
		String output_resp = driver.findElement(By.xpath("//*[@data-key='output-response']")).getText();
		System.out.println("Out put response is "+output_resp);

	}


	@Then("Verify Whether Support displayed or not Under update User Page")
	public void verify_whether_support_displayed_or_not_under_update_user_page() {

		Boolean Display = driver.findElement(By.xpath("//button[text()='Support ReqRes']")).isDisplayed();
		//To print the value
		System.out.println("Support ReqRes Button displayed is :"+Display);

		driver.close();

	}

	@When("I click on the PATCH button method for  Update User partially")
	public void i_click_on_the_patch_button_method_for_update_user_partially() {

		driver.findElement(By.xpath("//li[@data-id='patch']")).click();

	}
	@Then("Verify the Associate method end point for Update User User partially")
	public void verify_the_associate_method_end_point_for_update_user_user_partially() {
		String End_point_url = driver.findElement(By.xpath("//*[@class='url']")).getText();
		System.out.println("End Point URL for PATCH--> method is " + End_point_url);

	}
	@Then("Verify the Body of the request for Update User User partially")
	public void verify_the_body_of_the_request_for_update_user_user_partially() {

		String body = driver.findElement(By.xpath("//pre[@data-key='output-request']")).getText();

		System.out.println(body);

	}
	@Then("Verify Associated method Response for Update User User partially should be displayed")
	public void verify_associated_method_response_for_update_user_user_partially_should_be_displayed() {

		String Respcode = driver.findElement(By.xpath("//*[@class='response-code']")).getText();
		System.out.println("Response Code is "+Respcode);
		String output_resp = driver.findElement(By.xpath("//*[@data-key='output-response']")).getText();
		System.out.println("Out put response is "+output_resp);

	}
	@Then("Verify Whether Support displayed or not Under update User User partially Page")
	public void verify_whether_support_displayed_or_not_under_update_user_user_partially_page() {

		Boolean Display = driver.findElement(By.xpath("//button[text()='Support ReqRes']")).isDisplayed();
		//To print the value
		System.out.println("Support ReqRes Button displayed is :"+Display);

		driver.close();

	}

	@When("I click on Support reqres button")
	public void i_click_on_support_reqres_button() {
		
		driver.findElement(By.xpath("//button[text()='Support ReqRes']")).click();
		
	
	}

	@Then("Verify available options")
	public void verify_available_options() {
	
	List ele = driver.findElements(By.xpath("//input[@type='radio']"));
	
	int size = ele.size();
	
	System.out.println(size);
		
	
	WebElement radioEle = driver.findElement(By.id("supportOneTime"));
	boolean select = radioEle.isSelected();
	System.out.print(select);
	// performing click operation if element is not already selected
	if (select == false) {
		radioEle.click();
	}

	/**
	 * Find radio button using Xpath, Validate isDisplayed and click to select
	 */
	WebElement radioElem = driver.findElement(By.id("supportRecurring"));
	boolean sel = radioEle.isDisplayed();

	// performing click operation if element is displayed
	if (sel == true) {
		radioElem.click();
	}

	

}
	
	
	
	
	
	
	
	
	
	}
	
	
	
	
	
