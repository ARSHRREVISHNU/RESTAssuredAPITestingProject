package EndToEndTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.Create.Request.CreateUserRequestbody;
import users.Create.Response.CreateUserResponsebody;

import static io.restassured.RestAssured.given;

public class UsersClient {

    String url = "https://gorest.co.in/public/v1/users";


    public GetUserResponse getUser(CreateUserRequestBody body){
       Response response =  createUser(body);
       GetUserResponse getUserResponse = response.as(GetUserResponse.class);
       getUserResponse.setStatusCode(response.statusCode());
       return getUserResponse;
    }

    public Response createUser(CreateUserRequestBody body){

        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .headers("Authorization","Bearer 4cfc4a225c7c3756320db1a12fdb54df2f688250bc47287c2271dd4ddf701498")
                .body(body)
                .when()
                .post(url);
               response.then()
                .log().body();
               return response;
    }

    public GetUserResponse getUserById(int id){

        Response response = given()
                .pathParam("id", id)
                .when()
                .get("https://gorest.co.in/public/v1/{id}");
        response.then().log().body();
        int statusCode = response.statusCode();
        GetUserResponse getUserResponse = response.as(GetUserResponse.class);
        getUserResponse.setStatusCode(statusCode);
return getUserResponse;
    }




}
