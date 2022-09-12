package APITesting;

import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.Create.Request.CreateUserRequestbody;
import users.Create.Response.CreateUserErrorResponse;
import users.Create.Response.CreateUserResponsebody;
import users.UsersClinet;

import java.util.UUID;

public class NegativeUsersTest {

    private UsersClinet client;
    CreateUserRequestbody obj;
    @BeforeClass
    public void beforeClass(){
        client = new UsersClinet();


    }
    @Test
    public void invalidEmailId(){

       obj = CreateUserRequestbody.builder().name("Sample name").email("se1237896tloo@gma.com").status("active").gender("male").build();

        CreateUserErrorResponse errorResponse = client.createUserExpectingError(obj);
        Assert.assertEquals(errorResponse.getStatusCode(), 422);
        errorResponse.assertHasError("email", "is invalid");


    }
    @Test
    public void invalidStatusAndGender(){
        obj = CreateUserRequestbody.builder().name("Sample name").email("shrrevdtrdtrfyr@gmail.com").status("").gender("").build();
        CreateUserErrorResponse errorResponse = client.createUserExpectingError(obj);
        errorResponse.assertHasError("gender", "can't be blank, can be male of female");
        errorResponse.assertHasError("status","can't be blank");
    }
}
