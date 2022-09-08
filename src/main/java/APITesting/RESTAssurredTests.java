package APITesting;

import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

public class RESTAssurredTests {

    String url = "https://gorest.co.in/public/v1/users";
    @Test(priority = 1)
    public void togGetAllUsers(){

        //given() - Arrange
        given()
        //when() - Act
                .when()
                    .get(url)
        //then() - Assert
                .then()
                .log().body()
                .statusCode(200);

    }
}
