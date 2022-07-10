package com.example.demo3.TestAPI.EditAuction;

import com.example.demo3.Controller.Controller;
import com.example.demo3.Data.EditAuctionData;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadLocalRandom;

public class EditAuction {
	public static StringBuilder a = new StringBuilder();
	private static final DecimalFormat df = new DecimalFormat("0.00");
	@Test(dataProvider = "EditAuctionDataProvider", dataProviderClass = EditAuctionData.class)
	public void testCreateAuction(String auction_id, String logged_in, String category_id, String TTS, String TTL, String title_ni, String code, String message) {
		RequestSpecification request = RestAssured.given();
		request.baseUri(constant.EDIT_AUCTION);
		String access_token = LoginTestAll.getAccessToken();
		LocalDateTime today = LocalDateTime.now();
		LocalDateTime startDate = today.plusDays(Integer.parseInt(TTS));
		LocalDateTime endDate = startDate.plusDays(Integer.parseInt(TTL));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		String start_date = formatter.format(startDate);
		String end_date = formatter.format(endDate);
		double randomNum = ThreadLocalRandom.current().nextDouble(0.0, 10.0);
		String random_num = df.format(randomNum);
		if(logged_in.equals("Y")) {
			request.header("Authorization","Bearer "+access_token)
			.header("Content-Type","application/json");
		} else {
			request.header("Content-Type","application/json");
		}
		JSONObject requestParams = new JSONObject();
		requestParams.put("category_id", category_id);
		requestParams.put("start_date", start_date);
		requestParams.put("end_date", end_date);
		requestParams.put("title_ni", title_ni+random_num);
		request.body(requestParams.toJSONString());
		Response response = request.post("/"+auction_id);
		String x = response.prettyPrint();
		a.append(x);
		Controller.gettextoutput = a;
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
