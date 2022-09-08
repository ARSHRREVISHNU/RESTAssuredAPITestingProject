package APITesting;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import users.UsersClinet;

public class NegativeUsersTest {

    @Test
    public void invalidEmailId(){
        String body = "{\n" +
                "\n" +
                "    \"name\": \"Sample name\",\n" +
                "    \"email\": \"samplenametv13900.com\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";
        new UsersClinet().getUser(body)
                .then()
                .log().body()
                .statusCode(422)
                .body("data", Matchers.hasItem(Matchers.hasEntry("field", "email")))
                .body("data", Matchers.hasItem(Matchers.hasEntry("message","is invalid")));

    }
}
