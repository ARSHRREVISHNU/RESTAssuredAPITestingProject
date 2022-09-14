package APITesting;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.Create.Request.CreateUserRequestbody;
import users.Create.Response.CreateUserResponsebody;
import users.UsersClinet;

import java.util.UUID;

public class CreateUsersTest {

   private UsersClinet client;
@BeforeClass
public void beforeClass(){
    client = new UsersClinet();
 }

    @Test
    public void toCreateMaleUser(){
        //Arrange
        CreateUserRequestbody obj;
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        obj = CreateUserRequestbody.builder().name("Tenali Ramakrishna").email(email).gender("male").status("active").build();
        //Act
        CreateUserResponsebody createUserResponsebody = client.getUser(obj);
       //Assert
        createUserResponsebody.assertUser(obj);
    }


    @Test
    public void toCreateFemaleUser(){
        //Arrange
        CreateUserRequestbody obj;
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        obj = CreateUserRequestbody.builder().name("Tenali Ramakrishna").email(email).gender("male").status("active").build();
       //Act
        CreateUserResponsebody createUserResponsebody = client.getUser(obj);
        //Assert
        createUserResponsebody.assertUser(obj);

    }



}
