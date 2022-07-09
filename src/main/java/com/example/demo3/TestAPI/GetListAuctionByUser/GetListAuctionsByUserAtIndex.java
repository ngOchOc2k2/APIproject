package com.example.demo3.TestAPI.GetListAuctionByUser;

import com.example.demo3.Controller.Controller;
import com.example.demo3.Data.GetListAuctionsByUserData;
import com.example.demo3.Constant.constant;
import com.example.demo3.TestAPI.LoginTest.LoginTestAll;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetListAuctionsByUserAtIndex {
	public static StringBuilder a = new StringBuilder();
	@Test(dataProvider = "dataRandom", dataProviderClass = GetListAuctionsByUserData.class)
	public static void testAll(String logged_in, String index, String count, String status_id, String code, String message) {
		RequestSpecification request = RestAssured.given();
		request.baseUri(constant.GET_LIST_AUCTIONS_BY_USER);
		String access_token = LoginTestAll.getAccessToken();
		if(logged_in.equals("Y")) {
			request.header("Authorization","Bearer "+access_token)
					.header("Content-Type","application/json");
		} else {
			request.header("Content-Type","application/json");
		}
		JSONObject requestParams = new JSONObject();
		requestParams.put("index", index);
		requestParams.put("count", count);
		request.body(requestParams.toJSONString());
		Response response = request.get("/"+status_id);
		String x = response.prettyPrint();
		a.append(x);
		Controller.gettextoutput = a;
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
