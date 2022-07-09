package com.example.demo3.TestAPI.DeleteComment;

import com.example.demo3.Data.DeleteCommentsData;
import com.example.demo3.Constant.constant;
import com.example.demo3.TestAPI.LoginTest.LoginTestAll;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class deleteCommentRanDom {
	@Test(dataProvider = "dataRandom", dataProviderClass = DeleteCommentsData.class)
	public static void testAll(String auctionId,String code,String message) {
		RequestSpecification rq = RestAssured.given();
		rq.baseUri(constant.DELETE_COMMENT);
		String access_token = LoginTestAll.getAccessToken();
		rq.header("Authorization", "Bearer " + access_token).header("Content-Type", "application/json");
		Response response = rq.post("/"+auctionId);
		Assert.assertEquals(200, response.getStatusCode());	
		JsonPath jsonpath = response.jsonPath();
		int testCode = jsonpath.get("code");
		String testMessage = jsonpath.getString("message");
		Assert.assertEquals(testCode, Integer.parseInt(code));
		Assert.assertEquals(testMessage, message);
		response.prettyPrint();

	}
}
