package APITesting;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.Create.Request.CreateUserRequestbody;
import users.Create.Response.CreateUserErrorResponse;
import users.UsersClinet;
import users.UsersService;

public class NegativeUsersTest {

    private UsersService usersService;
    CreateUserRequestbody obj;
    @BeforeClass
    public void beforeClass(){
        usersService = new UsersService();


    }
    @Test
    public void invalidEmailId(){

       obj = new CreateUserRequestbody.Builder().email("se1237896tloo.com").build();

        CreateUserErrorResponse errorResponse = usersService.createUserExpectingError(obj);
        Assert.assertEquals(errorResponse.getStatusCode(), 422);
        errorResponse.assertHasError("email", "is invalid");


    }
    @Test
    public void invalidStatusAndGender(){
        obj = new CreateUserRequestbody.Builder().status("").gender("").build();
        CreateUserErrorResponse errorResponse = usersService.createUserExpectingError(obj);
        errorResponse.assertHasError("gender", "can't be blank, can be male of female");
        errorResponse.assertHasError("status","can't be blank");
    }
}
