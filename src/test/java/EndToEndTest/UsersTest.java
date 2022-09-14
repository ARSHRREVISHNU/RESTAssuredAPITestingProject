package EndToEndTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import EndToEndTest.CreateUserRequestBody;
import EndToEndTest.GetUserResponse;
import EndToEndTest.UsersClient;

import java.util.Locale;
import java.util.UUID;

public class UsersTest {
private UsersClient client;
    @BeforeClass
    public void initial() {
        client = new UsersClient();
    }

    @Test
    public void shouldCreateAndGetUser(){

        //Arrange
        CreateUserRequestBody obj;
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        obj = CreateUserRequestBody.builder().build();
        //Act
        int id = client.getUser(obj).getData().getId();
        //Assert
        client.getUserById(id).assertUserId(obj);
    }

}
