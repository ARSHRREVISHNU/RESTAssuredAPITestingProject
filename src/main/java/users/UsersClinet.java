package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.Create.Request.CreateUserRequestbody;
import users.Create.Response.CreateUserErrorResponse;
import users.Create.Response.CreateUserResponsebody;

import static io.restassured.RestAssured.given;

public class UsersClinet {
    String url = "https://gorest.co.in/public/v1/users";
    public CreateUserResponsebody getUser(CreateUserRequestbody body) {

        Response response = create(body);
        CreateUserResponsebody createUserResponsebody = response.as(CreateUserResponsebody.class);
        createUserResponsebody.setStatusCode(response.statusCode());

        return createUserResponsebody;
    }

    public Response create(CreateUserRequestbody body) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 4cfc4a225c7c3756320db1a12fdb54df2f688250bc47287c2271dd4ddf701498")
                .queryParam("", "")
                .body(body)
                .when()
                .post(url);
        response
                .then()
                    .log().body();
        return response;
    }



    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestbody body){

        Response response = create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());
        return errorResponse;
    }
    public Response getUsers() {
        return given()
                //when() - Act
                .when()
                .get(url);
    }
}
