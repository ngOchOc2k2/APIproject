package com.example.demo3.TestAPI.GetListLike;


import com.example.demo3.Controller.Controller;
import com.example.demo3.Data.GetListLikesData;
import com.example.demo3.Constant.constant;
import com.example.demo3.TestAPI.LoginTest.LoginTestAll;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class getListLikes {
	public static StringBuilder a = new StringBuilder();
	@Test(dataProvider = "GetListLikesProvider", dataProviderClass = GetListLikesData.class)
		public void testAll(String statusId, String index,String count,String code,String message) {
		RequestSpecification rq = RestAssured.given();
		rq.baseUri(constant.GET_LIST_LIKE);
		String access_token = LoginTestAll.getAccessToken();
		JSONObject requestParams = new JSONObject();
		requestParams.put("index",index);
		requestParams.put("count",count);
		rq.body(requestParams.toJSONString());
		rq.header("Authorization","Bearer "+access_token).header("Content-Type","application/json");
		Response response = rq.get("/"+statusId);
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