package com.example.demo3.TestAPI.LoginTest;

import com.example.demo3.Controller.Controller;
import com.example.demo3.Data.LoginData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.example.demo3.Controller.Controller;
import com.example.demo3.Data.LoginData;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class LoginTestSelect {
    public static String getAccessToken() {
        baseURI = "https://auctions-app-2.herokuapp.com/api/login";
        RequestSpecification request = given();
        request.header("Content-Type", "application/json");
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", "quangnghia.ns@gmail.com");
        requestParams.put("password", "123456");
        request.body(requestParams.toJSONString());
        Response response = request.post("/login");
        JsonPath jsonpath = response.jsonPath();
        String access_token = jsonpath.get("data.access_token");
        return access_token;
    }
    @Test(dataProvider = "dataAtIndex", dataProviderClass = LoginData.class)
    public static void testAtIndex(String email, String password, String code, String message){
        baseURI="https://auctions-app-2.herokuapp.com/api/login";
        RequestSpecification request = given();
        request.header("Content-Type","application/json");
        JSONObject requestParams = new JSONObject();
        requestParams.put("email", email);
        requestParams.put("password", password);
        request.body(requestParams.toJSONString());
        Response response = request.post();
        response.prettyPrint();
        Assert.assertEquals(200, response.getStatusCode());
        JsonPath jsonpath = response.jsonPath();
        int testCode = jsonpath.get("code");
        String testMessage = jsonpath.getString("message");
        Assert.assertEquals(testCode, Integer.parseInt(code));
        Assert.assertEquals(testMessage, message);
    }
}
