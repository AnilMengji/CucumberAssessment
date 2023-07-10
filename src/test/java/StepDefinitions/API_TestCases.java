package StepDefinitions;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

import com.google.common.collect.MapDifference;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class API_TestCases {

	private static final String BASE_URL = "https://reqres.in/";
	private static final String RESPONSE_FILE_PATH = "C:\\\\Users\\\\HOME\\\\Downloads\\\\Test\\\\resp.json";
	private static final String ENDPOINT = "api/users";
	private static final String REQUEST_BODY_FILE_PATH = "C:\\Users\\HOME\\Downloads\\Test\\create_user.json";

	private Response response;
	String EndPoint = "api/users/2";

	@Given("I have a GET API endpoint")
	public void i_have_a_get_api_endpoint() {
		// System.out.println(RESPONSE_FILE_PATH);

	}

	@When("I send a GET request")
	public void i_send_a_get_request() {
		response = RestAssured.get(BASE_URL + EndPoint);

	}

	@Then("I should receive a successful response")
	public void i_should_receive_a_successful_response() {
		response.then().statusCode(200);

		System.out.println(response.asPrettyString());

	}

	@Then("I store the response in a file")
	public void i_store_the_response_in_a_file() {
		try {

			FileWriter fw = new FileWriter(RESPONSE_FILE_PATH);
			fw.write(response.getBody().asPrettyString());

			fw.close();
			// fw.flush();

		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	@Then("Compare Actual and expected Response files")
	public void compare_actual_and_expected_response_files() {

		JsonElement Json1 = getJson1();
		JsonElement Json2 = getJson2();

		Gson g = new Gson();
		Type mapType = new TypeToken<Map<String, Object>>() {
		}.getType();
		Map<String, Object> firstMap = g.fromJson(Json1, mapType);
		Map<String, Object> secondMap = g.fromJson(Json2, mapType);
		MapDifference<String, Object> difference = Maps.difference(firstMap, secondMap);

		// System.out.println("\n\nEntries are missing in
		// Json2\n--------------------------\n");
		// difference.entriesOnlyOnLeft().forEach((key, value) ->
		// System.out.println("\n--> " + key + ": " + value));

		// System.out.println("\n\nEntries are missing in
		// Json1\n--------------------------\n");
		// difference.entriesOnlyOnRight().forEach((key, value) ->
		// System.out.println("\n--> " + key + ": " + value));

		System.out.println("\n\nEntries Mismatching between two JSON files:\n--------------------------\n");
		difference.entriesDiffering().forEach((key, value) -> System.out.println("\n--> " + key + ": " + value));

		// System.out.println("\n\nEntries Common:\n--------------------------\n");
		// difference.entriesInCommon().forEach((key, value) ->
		// System.out.println("\n--> " + key + ": " + value));
	}

	@SuppressWarnings("deprecation")
	public static JsonElement getJson1() {
		@SuppressWarnings("deprecation")
		JsonParser jsonParser = new JsonParser();
		JsonElement jsonElement = null;
		try {
			FileReader fileReader = new FileReader("C:\\Users\\HOME\\Downloads\\Test\\resp.json");
			jsonElement = jsonParser.parse(fileReader);
		} catch (Exception e) {
			System.out.println("File not found");
		}
		return jsonElement;
	}

	public static JsonElement getJson2() {
		JsonParser jsonParser = new JsonParser();
		JsonElement jsonElement = null;
		try {
			FileReader fileReader = new FileReader("C:\\Users\\HOME\\Downloads\\Test\\resp1.json");// Json2 filePath
			jsonElement = jsonParser.parse(fileReader);
		} catch (Exception e) {
			System.out.println("File not found");
		}
		return jsonElement;
	}

	@Given("I have a request to create a user")
	public void i_have_a_request_to_create_a_user() {

	}

	@When("I send a POST request with user details")
	public void i_send_a_post_request_with_user_details() {

		RequestSpecification request = RestAssured.given();

		JSONObject requestparams = new JSONObject();

		requestparams.put("name", "morpheus");
		requestparams.put("job", "leader");

		request.header("ContentType", "application/json");

		request.body(requestparams.toJSONString());

		System.out.println(response.getStatusCode());

	}

	@Then("I should receive a successful response with status code {int}")
	public void i_should_receive_a_successful_response_with_status_code(Integer int1) {

		// System.out.println(response.getStatusCode());

	}

}
