package com.example.demo3.TestAPI.ContactUs;

import com.example.demo3.Controller.Controller;
import com.example.demo3.Data.ContactUsData;
import com.example.demo3.Constant.constant;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ContactUsAll {
	public static StringBuilder a = new StringBuilder();
	@Test(dataProvider = "ContactUsDataProvider", dataProviderClass = ContactUsData.class)
	public void testAll(String name, String phone, String email, String content, String file, String report_type, String code, String message) {
		RequestSpecification request = RestAssured.given();
		request.baseUri(constant.CONTACT_US);
		request.header("Content-Type","application/json");
		JSONObject requestParams = new JSONObject();
		requestParams.put("name", name);
		requestParams.put("phone", phone);
		requestParams.put("email", email);
		requestParams.put("content", content);
		requestParams.put("file", file);
		requestParams.put("report_type", report_type);
		request.body(requestParams.toJSONString());
		Response response = request.post();
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
