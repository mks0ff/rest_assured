package com.apis.rest.test;

import com.apis.rest.test.common.AcceptanceTest;
import com.jersey.providers.NotFoundMapper;
import com.jersey.providers.TodoServiceProvider;
import com.jersey.resources.TodoResource;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

/**
 * @author SLA
 * @version 1.0
 */
public class TestRESTApi extends AcceptanceTest
{
    @Override
    protected String getResources() {
        return TodoResource.class.getName() + ";" + TodoServiceProvider.class.getName() + ";" + NotFoundMapper.class.getName();
    }

    @Test
    public void testTodoOK() {

        final String todo = "toto";

        //given
        given()
                .contentType("application/json")
                .baseUri("http://localhost:9998")
                .body(todo)
        // when
        .when()
                .post("/todo")
        // verify
        .then()
                .statusCode(204);

        //given
        given()
                .baseUri("http://localhost:9998")
                        // when
        .when()
                .get("/todo")
                        // verify
        .then()
                .statusCode(200)
                .body(containsString(todo));

    }

}
