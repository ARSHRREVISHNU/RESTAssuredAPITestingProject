package APITesting;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.Create.JSONObject;
import users.UsersClinet;

import java.util.Random;
import java.util.UUID;

public class NegativeUsersTest {

    private UsersClinet client;
    JSONObject obj;
    @BeforeClass
    public void beforeClass(){
        client = new UsersClinet();


    }


    @Test
    public void invalidEmailId(){
        String name = "Sample name";
        String gender = "male";
        String status = "active";
       String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n" +
                "\n" +
                "    \"name\": \"Sample name\",\n" +
                "    \"email\": \"%S\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}",email);
        obj = new JSONObject(name, gender,email, status);

        client.getUser(obj)
                .then()
                .log().body()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));

    }
}
