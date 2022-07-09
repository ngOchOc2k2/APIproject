package com.example.demo3.TestAPI.CreateBid;

import com.example.demo3.Controller.Controller;
import com.example.demo3.Data.CreateBidData;
import com.example.demo3.TestAPI.LoginTest.LoginTestAll;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.example.demo3.Constant.constant;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class CreateBidAll {
	public static StringBuilder a = new StringBuilder();
	@Test(dataProvider = "CreateBidDataProvider", dataProviderClass = CreateBidData.class)
	public void testAll(String auction_id, String logged_in, String price, String last_bid_id, String code, String message) {
		baseURI = constant.CREATE_BID;
		RequestSpecification request = given();
		
		if(logged_in.equals("Y")) {
			String access_token = LoginTestAll.getAccessToken();
			request.header("Authorization","Bearer "+access_token)
			.header("Content-Type","application/json");
		} else {
			request.header("Content-Type","application/json");
		}
		JSONObject requestParams = new JSONObject();
		requestParams.put("price", price);
		requestParams.put("bid_last_id", last_bid_id);
		request.body(requestParams.toJSONString());
		Response response = request.post("/"+auction_id);
		String x = response.prettyPrint();
		a.append(x);
		Controller.gettextoutput = a;
		JsonPath jsonpath = response.jsonPath();
		int testCode = jsonpath.get("code");
		String testMessage = jsonpath.getString("message");
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
				Assert.assertTrue(testCode == Integer.parseInt(code) && testMessage.equals(message));
			} catch (AssertionError e) {
				Controller.gettextoutput.append("Test failed!\n");
				throw e;
			}
		}
		Controller.gettextoutput.append("Test passed!\n");
	}
}
