package APITesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClinet;

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
        new UsersClinet().getUser(body)
                //Assert
                .then()
                .log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("tenali.ramakrishna36909090@15000ce3.com"));



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
        new UsersClinet().getUser(body)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.id",Matchers.notNullValue())
                .body("data.email", Matchers.equalTo("tenali.ramakrishna36909090@15034ce3.com"));
    }

}
