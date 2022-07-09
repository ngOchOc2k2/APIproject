package com.example.demo3.TestAPI.DeleteComment;

import com.example.demo3.Controller.Controller;
import com.example.demo3.Data.DeleteCommentsData;
import com.example.demo3.Constant.constant;
import com.example.demo3.TestAPI.LoginTest.LoginTestAll;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class deleteCommentAll {
	public static StringBuilder a = new StringBuilder();
	@Test(dataProvider = "DeleteCommentsProvider", dataProviderClass = DeleteCommentsData.class)
	public void testAll(String auctionId,String code,String message) {
		RequestSpecification rq = RestAssured.given();
		rq.baseUri(constant.DELETE_COMMENT);
		String access_token = LoginTestAll.getAccessToken();
		rq.header("Authorization", "Bearer " + access_token).header("Content-Type", "application/json");
		Response response = rq.post("/" + auctionId);
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
