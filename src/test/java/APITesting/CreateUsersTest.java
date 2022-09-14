package APITesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.Create.Request.CreateUserRequestbody;
import users.Create.Response.CreateUserResponsebody;
import users.UsersService;

import java.util.UUID;

public class CreateUsersTest {

   private UsersService usersService;
@BeforeClass
public void beforeClass(){
    usersService = new UsersService();
 }

    @Test
    public void toCreateMaleUser(){
        //Arrange
        CreateUserRequestbody obj;
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        obj = new CreateUserRequestbody.Builder().build();
        //Act
        CreateUserResponsebody createUserResponsebody = usersService.getUser(obj);
       //Assert
        createUserResponsebody.assertUser(obj);
    }


    @Test
    public void toCreateFemaleUser(){
        //Arrange
        CreateUserRequestbody obj;
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        obj = new CreateUserRequestbody.Builder().gender("female").build();
       //Act
        CreateUserResponsebody createUserResponsebody = usersService.getUser(obj);
        //Assert
        createUserResponsebody.assertUser(obj);

    }



}
