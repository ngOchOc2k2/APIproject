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
		JsonPath jsonpath = response.jsonPath();
		int testCode = jsonpath.get("code");
		boolean page_loaded = true;
		try {
			Assert.assertTrue(response.getStatusCode() == 200);
		} catch (AssertionError e) {
			page_loaded = false;
			Controller.gettextoutput.append("Test failed!\n");
			throw e;
		}
		if (page_loaded) {
			try {
			} catch (AssertionError e) {
				Controller.gettextoutput.append("Test failed!\n");
				throw e;
			}
		}
		Controller.gettextoutput.append("Test passed!\n");
	}
}
