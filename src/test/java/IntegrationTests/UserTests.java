package IntegrationTests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.Create.Request.CreateUserRequestbody;
import users.UsersClinet;
import users.UsersService;

import java.util.UUID;

public class UserTests {
  private UsersService usersService;

    @BeforeClass
    public void before(){

        usersService = new UsersService();
    }

    @Test
    public void shouldCreateAndReturnUser(){
       //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestbody createUserRequestbody = new CreateUserRequestbody.Builder().build();

        //Arrange
        int id = usersService.getUser(createUserRequestbody).getData().getId();
        System.out.println("ID: "+id);
//Assert
        usersService.getuser(id).assertUser(createUserRequestbody);
    }



    @Test
    public void shouldCreateAndDeleteUser(){
        CreateUserRequestbody requestbody = new CreateUserRequestbody.Builder().build();
        int id = usersService.getUser(requestbody).getData().getId();

        int statusCode = usersService.deleteUser(id);

        Assert.assertEquals(statusCode, 204);

       usersService.getUserExpectingError(id).assertError(404, "Resource Not Found");
    }
}
