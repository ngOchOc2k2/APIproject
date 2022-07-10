package com.example.demo3.TestAPI.LoginTest;

import com.example.demo3.Controller.Controller;
import com.example.demo3.Data.LoginData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class LoginTestRandom {
    public static StringBuilder a = new StringBuilder();
    @Test(dataProvider = "dataRandom", dataProviderClass = LoginData.class)
    public static void testRandom(String email, String password, String code, String message) {
        Controller.gettextoutput = new StringBuilder();
        baseURI = "https://auctions-app-2.herokuapp.com/api/login";
        RequestSpecification request = given();
        request.header("Content-Type","application/json");
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", email);
        requestParams.put("password", password);
        request.body(requestParams.toJSONString());
        Response response = request.post();
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
