package com.example.demo3.TestAPI.CreateItem;

import com.example.demo3.Controller.Controller;
import com.example.demo3.Data.CreateItemData;
import com.example.demo3.Constant.constant;
import com.example.demo3.TestAPI.LoginTest.LoginTestAll;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.DecimalFormat;
import java.util.concurrent.ThreadLocalRandom;

public class CreateItemAll {
	public static StringBuilder a = new StringBuilder();
	private static final DecimalFormat df = new DecimalFormat("0.00");
	@Test(dataProvider = "CreateItemDataProvider", dataProviderClass = CreateItemData.class)
	public void testCreateAuction(String auction_id, String logged_in, String name, String starting_price, String brand_id, String description, String series, String images, String code, String message) {
		RequestSpecification request = RestAssured.given();
		request.baseUri(constant.CREATE_ITEM);
		//login
		String access_token = LoginTestAll.getAccessToken();
		//create item
		double randomNum = ThreadLocalRandom.current().nextDouble(0.0, 10.0);
		String random_num = df.format(randomNum);
		if(logged_in.equals("Y")) {
			request.header("Authorization","Bearer "+access_token)
			.header("Content-Type","application/json");
		} else {
			request.header("Content-Type","application/json");
		}
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", name+random_num);
		requestParams.put("starting_price", starting_price);
		requestParams.put("brand_id", brand_id);
		requestParams.put("description", description);
		requestParams.put("series", series);
		requestParams.put("images", images);
		request.body(requestParams.toJSONString());
		Response response = request.post("/"+auction_id);
		String x = response.prettyPrint();
		a.append(x);
		Controller.gettextoutput = a;
		Assert.assertEquals(200,response.getStatusCode());
		boolean page_loaded = true;
		try {
			Assert.assertTrue(response.getStatusCode()==200);
		} catch (AssertionError e) {
			page_loaded = false;
			System.out.println("\nTest failed! Không load được api");
			Controller.gettextoutput.append("\nTest failed! Không load được api" + '\n');
			throw e;
		}
		if(page_loaded) {
			JsonPath jsonpath = response.jsonPath();
			int testCode = jsonpath.get("code");
			String testMessage = jsonpath.getString("message");
			try {
				Assert.assertTrue(testCode==Integer.parseInt(code));
			} catch (AssertionError e) {
				System.out.println("\nTest failed!\nExpected code: "+code+"\nActual: "+testCode);
				Controller.gettextoutput.append("\nTest failed!\nExpected code: "+code+"\nActual: "+testCode + '\n');
				throw e;
			}
			try {
				Assert.assertTrue(testMessage.equals(message));
			} catch (AssertionError e) {
				System.out.println("\nTest failed!\nExpected message: "+message+"\nActual: "+testMessage);
				Controller.gettextoutput.append("\nTest failed!\nExpected message: "+message+"\nActual: "+testMessage + '\n');
				throw e;
			}
		}
		Controller.gettextoutput.append("Test passed!\n");
	}
}
