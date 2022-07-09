package com.example.demo3.TestAPI.GetListAuction;

import com.example.demo3.Data.GetListAuctionsData;
import com.example.demo3.Constant.constant;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetListAuctionsAtIndex {
	@Test(dataProvider = "dataRandom", dataProviderClass = GetListAuctionsData.class)
	public void testAll(String index, String count, String code, String message) {
		RequestSpecification request = RestAssured.given();
		request.baseUri(constant.GET_LIST_AUCTIONS);
		
		
		request.header("Content-Type","application/json");
		
		JSONObject requestParams = new JSONObject();
		requestParams.put("index", index);
		requestParams.put("count", count);
		request.body(requestParams.toJSONString());
		
		Response response = request.get();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		JsonPath jsonpath = response.jsonPath();
		int testCode = jsonpath.get("code");
		
		String testMessage = jsonpath.getString("message");
		Assert.assertEquals(testCode, Integer.parseInt(code));
		Assert.assertEquals(testMessage, message);
	}
}
