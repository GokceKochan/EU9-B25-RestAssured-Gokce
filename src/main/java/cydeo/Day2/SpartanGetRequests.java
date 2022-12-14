package cydeo.Day2;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.URI;

public class SpartanGetRequests {

    String baseUrl="http://54.208.45.78:8000";
    //Given Accept Type application/json
    //When user send GET request to api/spartans end point
    //Then status code must be 200
    //And response Content Type must be application/json
    //And response body should include spartan result

    @Test
    public void test1(){

       Response response= RestAssured.given().accept(ContentType.JSON)
                .when()
                .get(baseUrl+"/api/spartans");

       //printing status code from response object
        System.out.println("response.statusCode() = " + response.statusCode());

        //printing response content type from response object
        System.out.println("response.contentType() = " + response.contentType());

        //print whole result body
        System.out.println("response.prettyPrint() = " + response.prettyPrint());

        //how to do API testing then?
        //verify status code is 200
        Assertions.assertEquals(response.statusCode(),200);

        //verify content type is applicantion/json
        Assertions.assertEquals(response.contentType(),"application/json");



    }

    /*
    Given accept is application/json
    When users sends a get request to /api/spartans/3
    Then status code should be 200
    And content type should be application/json
    And json body should contain Fidole

     */

@DisplayName("Get one spartan /api/spartans/3 and verify")
@Test

    public void test2(){

    Response response =RestAssured.given().accept(ContentType.JSON).
            when().get(baseUrl+"/api/spartans/3");

    //verify status code is 200
    Assertions.assertEquals(response.statusCode(),200);

    //verify content type
    Assertions.assertEquals(response.contentType(),"application/json");

    //verify json body contains Fidole
    Assertions.assertTrue(response.body().asString().contains("Fidole"));


}

/*
Given no headers provided
When users sends GET request to /api/hello
Then response status code should be 200
And Content type header should be "text/plain;charset=UTF-8"
And header should contain date
And content-Length should be 17
And body should be "Hello from Sparta"

 */
  @DisplayName("Get Request to api/hello")
    @Test
    public void test3(){
      //send request and save response inside the response object
      Response response =RestAssured.when().get(baseUrl+"/api/hello");

      //verify status code is 200
      Assertions.assertEquals(200,response.statusCode());

      //verify content type
      Assertions.assertEquals("text/plain;charset=UTF-8",response.contentType());

      //verify we have headers named date
      //we use hasheaderWithName method to verify header exist or not
      Assertions.assertTrue(response.headers().hasHeaderWithName("Date"));


      //how to get and header from response using header key
      //we use response.header(String headerName) method to get any header value-it returns boolean

      System.out.println("response.header(\"Content-Length\") = " + response.header("Content-Length"));
      System.out.println("response.header(\"Date\") = " + response.header("Date"));

      //verify content lengh is 17
      Assertions.assertEquals("17",response.header("Content-Length"));

      Assertions.assertEquals("Hello from Sparta",response.body().asString());



  }


}
