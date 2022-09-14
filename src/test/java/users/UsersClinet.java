package users;


import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.Create.Request.CreateUserRequestbody;


import static io.restassured.RestAssured.given;

public class UsersClinet {
    String url = "https://gorest.co.in/public/v1/users";

    public Response create(CreateUserRequestbody body) {
        Response response = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 4cfc4a225c7c3756320db1a12fdb54df2f688250bc47287c2271dd4ddf701498")
                .body(body)
                .when()
                .post(url);
        response
                .then()
                    .log().body();
        return response;
    }

    public Response getAll() {
        Response response = given()
                .when()
                .get(url);
        response
                .then()
                .log().body();

        return response;
    }

    public  Response get(int id) {
        Response response = given()
                .pathParam("id", id)
                .when()
                .get("https://gorest.co.in/public/v1/{id}");
        response
                .then()
                .log().body();
        return response;
    }

    public Response delete(int id){
        Response response =
                given()
                        .header("Authorization", "Bearer 4cfc4a225c7c3756320db1a12fdb54df2f688250bc47287c2271dd4ddf701498")
                        .pathParam("id", id)
                .when()
                        .delete("https://gorest.co.in/public/v1/users/{id}");
                        response
                .then()
                       .log().body();
        return response;

    }
}

