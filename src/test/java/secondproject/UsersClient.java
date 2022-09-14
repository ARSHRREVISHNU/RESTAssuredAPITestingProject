package secondproject;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import secondproject.RequestBody.CreateUserRequestBody;
import users.Create.Request.CreateUserRequestbody;

import static io.restassured.RestAssured.given;

public class UsersClient {

    public Response get(){
            Response response =
                    given()
                        .pathParam("fruit", "berry")
                        .pathParam("id", 14)
                    .when()
                            .get("https://pokeapi.co/api/v2/{fruit}/{id}");
                    response.then()
                            .log().body();
            return response;
    }


    public Response create(CreateUserRequestBody body){


        Response response =
                given()
                    .accept(ContentType.JSON)
                    .contentType(ContentType.JSON)
                    .header("Authorization", "Bearer 4cfc4a225c7c3756320db1a12fdb54df2f688250bc47287c2271dd4ddf701498")
                    .body(body)
                .when()
                    .post("https://gorest.co.in/public/v1/users");

        response
                .then()
                    .log().body();

        return response;







    }

    public Response delete(int id){
        Response response =
                given()
                        .pathParam("id",id)
                        .header("Authorization", "Bearer 4cfc4a225c7c3756320db1a12fdb54df2f688250bc47287c2271dd4ddf701498")
                        .when()
                        .delete("https://gorest.co.in/public/v1/users/{id}");
        response.then().log().body();

        return response;


    }

    public Response getUser(int id){
        Response response =
                given()
                        .pathParam("id", id)
                        .when()
                        .get("https://gorest.co.in/public/v1/users/{id}");
                        response.then().log().body();
                        return response;
    }
}
