package users;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import users.Create.JSONObject;

import static io.restassured.RestAssured.given;

public class UsersClinet {
    String url = "https://gorest.co.in/public/v1/users";
    public Response getUser(JSONObject body) {

        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 4cfc4a225c7c3756320db1a12fdb54df2f688250bc47287c2271dd4ddf701498")
                .queryParam("","")
                .body(body)
                .when()
                .post(url);
    }


    public Response getUsers() {
        return given()
                //when() - Act
                .when()
                .get(url);
    }
}
