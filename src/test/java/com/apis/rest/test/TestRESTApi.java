package com.apis.rest.test;

import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

/**
 * @author SLA
 * @version 1.0
 */
public class TestRESTApi {

    @Test
    public void test_HTTP_GET() throws Exception {

        String expected = "Not Found";

        //given
        given().baseUri("https://www.googleapis.com")

        // when
        .when().get("/urlshortener")

        // verify
        .then().statusCode(404)
               .body(equalTo(expected));

    }

    @Test
    public void test_HTTP_POST() throws Exception {

        String json =   "{\n" +
                        "  \"longUrl\": \"http://fitnesse.org/\"\n" +
                        "}\n";

        String expected = "http://goo.gl/CVOB";

        //given
        given().contentType("application/json").baseUri("https://www.googleapis.com/urlshortener").body(json)

        // when
        .when().post("/v1/url")

        // verify
        .then().statusCode(200)
               .body(containsString(expected));

    }
}
