package cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.baseURI;

import  static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.*;



public class SpartanNegativeGetTest {

    @BeforeAll
    public static void init(){
        //save baseUrl inside this variable so that we do not need to type each http method.
        baseURI="http://54.208.45.78:8000";

        /*
        Given accept type application/json
        When user send GET request to /api/spartans/10 en point
        Then status code must be 406
        And response content type must be application/xml;charset=UTF-8
         */



    }
    @DisplayName("GET request to /api/spartans/10")
    @Test
    public void test1(){

        Response response = given().accept(ContentType.XML).when().get("/api/spartans/10");

        //verify status code
        assertEquals(406,response.statusCode());

        //verify content type
        assertEquals("application/xml;charset=UTF-8",response.contentType());

    }

}
