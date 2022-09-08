package APITesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class CreateUsersTest {

    String url = "https://gorest.co.in/public/v1/users";
    @Test
    public void toCreateMaleUser(){
//Arrange
        String body = "{\n" +
                "  \"name\": \"Tenali Ramakrishna\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"tenali.ramakrishna36909090@15000ce3.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";

        //Act
        getUser(body)
                //Assert
                .then()
                .log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("tenali.ramakrishna36909090@15000ce3.com"));



    }

    private Response getUser(String body) {

        return given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 4cfc4a225c7c3756320db1a12fdb54df2f688250bc47287c2271dd4ddf701498")
                .body(body)
                .when()
                .post(url);
    }

    @Test
    public void toGETUsers(){


        given()
                .when()
                .get(url)
                .then()
                .log().body()
                .statusCode(200)
                .body("data",Matchers.hasItem(Matchers.hasEntry("email", "bobbie_metz@collins.info")));






    }

    @Test
    public void toCreateFemaleUser(){
//Arrange
        String body = "{\n" +
                "  \"name\": \"Tenali Ramakrishna\",\n" +
                "  \"gender\": \"male\",\n" +
                "  \"email\": \"tenali.ramakrishna36909090@15034ce3.com\",\n" +
                "  \"status\": \"active\"\n" +
                "}";
       //Act
        getUser(body)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.id",Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("tenali.ramakrishna36909090@15034ce3.com"));
    }

}
