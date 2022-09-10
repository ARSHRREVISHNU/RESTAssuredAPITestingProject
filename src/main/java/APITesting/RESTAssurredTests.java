package APITesting;

import org.testng.annotations.*;
import users.UsersClinet;

import static io.restassured.RestAssured.*;

public class RESTAssurredTests {


    private UsersClinet user;

    @BeforeClass
    public void beforeClass(){
        user = new UsersClinet();
    }

    @Test
    public void togGetAllUsers(){
               user.getUsers()
             .then()
                        .log().body()
                        .statusCode(200);

    }


}
