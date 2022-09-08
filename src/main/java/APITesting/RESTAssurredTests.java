package APITesting;

import org.testng.Assert;
import org.testng.annotations.*;

import static io.restassured.RestAssured.*;

public class RESTAssurredTests {
    @Test
    public void test(){

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

}
