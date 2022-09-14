package IntegrationTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.Create.Request.CreateUserRequestbody;
import users.UsersClinet;

import java.util.UUID;

public class UserTests {
  private UsersClinet usersClinet;

    @BeforeClass
    public void before(){

usersClinet = new UsersClinet();
    }

    @Test
    public void shouldCreateAndReturnUser(){
       //Arrange
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        CreateUserRequestbody createUserRequestbody = CreateUserRequestbody.builder().build();

        //Arrange
        int id = usersClinet.getUser(createUserRequestbody).getData().getId();

//Assert
        usersClinet.getuser(id).assertUser(createUserRequestbody);
    }

}
