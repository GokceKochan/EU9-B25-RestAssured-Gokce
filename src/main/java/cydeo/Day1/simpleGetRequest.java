package cydeo.Day1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;


public class simpleGetRequest {

    String url = "http://54.208.45.78:8000/api/spartans";


    @Test
    public void test1(){

        //send a get request and save response inside the Response object
        Response response= RestAssured.get(url);

        //print Response status code
        System.out.println(response.statusCode());

        //print response body
        response.prettyPrint();


    }



}
