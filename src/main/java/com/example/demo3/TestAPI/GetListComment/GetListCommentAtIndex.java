package com.example.demo3.TestAPI.GetListComment;

import com.example.demo3.Controller.Controller;
import com.example.demo3.Data.GetListCommentData;
import com.example.demo3.Constant.constant;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetListCommentAtIndex {
	public static StringBuilder a = new StringBuilder();
	@Test(dataProvider = "dataRandom", dataProviderClass = GetListCommentData.class)
	public static void testAll(String auctionId, String index, String count, String code, String message) {
		RequestSpecification request = RestAssured.given();
		request.baseUri(constant.GET_LIST_COMMENT);

		request.header("Content-Type","application/json");
		JSONObject requestParams = new JSONObject();
		requestParams.put("index", index);
		requestParams.put("count", count);
		request.body(requestParams.toJSONString());
		Response response = request.get("/"+auctionId);
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