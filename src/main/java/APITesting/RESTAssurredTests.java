package APITesting;

import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

public class RESTAssurredTests {
    @Test
    public void togGetAllUsers(){

        //given() - Arrange
        given()
        //when() - Act
                .when()
                    .get("https://gorest.co.in/public/v2/users")
        //then() - Assert
                .then()
                    .statusCode(200)
                    .log().body();
        Assert.assertEquals(1,1);
    }

    @Test
    public void toPostANewUser(){

        //Arrange
        given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .header("Authorization", "Bearer 4cfc4a225c7c3756320db1a12fdb54df2f688250bc47287c2271dd4ddf701498")
                .body(
                        "{\n" +
                                "  \"name\": \"Tenali Ramakrishna\",\n" +
                                "  \"gender\": \"male\",\n" +
                                "  \"email\": \"tenali.ramakrishna34@15ce.com\",\n" +
                                "  \"status\": \"active\"\n" +
                                "}"
                )
                //Act
                .when()
                .post("https://gorest.co.in/public/v2/users")
        //Assert
                .then()
                .log().body()
                .statusCode(201);


    }
}
