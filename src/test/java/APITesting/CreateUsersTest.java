package APITesting;

import org.hamcrest.Matchers;
import org.testng.Assert;
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
        //String email = "shrre@vishnswffeu.com";
        //obj = new CreateUserRequestbody("Sample name", "male", email, "active");
        obj = CreateUserRequestbody.builder().name("Tenali Ramakrishna").email(email).gender("male").status("active").build();    //Act
        CreateUserResponsebody createUserResponsebody = client.getUser(obj);
        Assert.assertEquals(createUserResponsebody.getStatusCode(), 201);
        Assert.assertNotNull(createUserResponsebody.getData().getId());
        Assert.assertEquals(createUserResponsebody.getData().getEmail(), obj.getEmail());
    }




    @Test
    public void toCreateFemaleUser(){
//Arrange
        CreateUserRequestbody obj;
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        //String email = "shrre@vishnswffeu.com";
        //obj = new CreateUserRequestbody("Sample name", "male", email, "active");
        obj = CreateUserRequestbody.builder().name("Tenali Ramakrishna").email(email).gender("male").status("active").build();

       //Act
        CreateUserResponsebody createUserResponsebody = client.getUser(obj);

        Assert.assertEquals(createUserResponsebody.getStatusCode(), 201);
        Assert.assertNotNull(createUserResponsebody.getData().getId());
        Assert.assertEquals(createUserResponsebody.getData().getEmail(), obj.getEmail());
    }

}
