package cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import  static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;

public class HrGetRequests {


    //BeforeAll is a annotation equals to @BeforeClsdd in testNg,we use with static method name
    @BeforeAll

    public static void init() {

        baseURI = "http://54.208.45.78:1000/ords/hr";

    }

        @DisplayName("GET request to /regions")
        @Test

        public void test1(){
            Response response = RestAssured.get("/regions");

            //print the status code
            System.out.println("response.statusCode() = " + response.statusCode());

        }

        /*
        Given accept type is json
        When user sends get request to regions/2
        Then response status code must be 200
        And content type equals to application/json
        And response body contains Americas
         */


    @DisplayName("GET request to /regions/2")
    @Test
    public void test2(){
        Response response = RestAssured.get("/regions/2");

        //verify status code
        Assertions.assertEquals(200,response.statusCode());

        //verify content type
        Assertions.assertEquals("application/json",response.contentType());
        response.prettyPrint();

        //verify body contains Americas
        Assertions.assertEquals(response.body().asString().contains("Americas"),true);
    }







}
