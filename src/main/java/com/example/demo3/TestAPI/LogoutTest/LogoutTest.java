package com.example.demo3.TestAPI.LogoutTest;

import com.example.demo3.Constant.constant;
import com.example.demo3.Controller.Controller;
import com.example.demo3.Data.LogoutData;
import com.example.demo3.TestAPI.LoginTest.LoginTestAll;
import io.restassured.path.json.JsonPath;
import io.restassured.path.json.exception.JsonPathException;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class LogoutTest {
    public static StringBuilder a = new StringBuilder();
    @Test(dataProvider = "logoutDataProviderMethod", dataProviderClass = LogoutData.class)
    public static void testLogout(String logged_in, String code, String message) throws JsonPathException {
        baseURI = constant.LOG_OUT;
        RequestSpecification request = given();
        if (logged_in.equals("Y")) {
            String access_token = LoginTestAll.getAccessToken();
            request.header("Authorization", "Bearer " + access_token)
                    .header("Content-Type", "application/json");
        } else {
            request.header("Content-Type", "application/json");
        }
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

