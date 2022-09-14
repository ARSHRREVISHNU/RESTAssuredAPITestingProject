package secondproject;

import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import secondproject.RequestBody.CreateUserRequestBody;
import secondproject.ResponseBody.GetResponseBody;
import users.UsersService;

import static io.restassured.RestAssured.given;

public class TestClass {
UsersServices usersServices;

@BeforeClass
public void beforeClass(){
  usersServices = new UsersServices();
}

    @Test
    public void testMethod(){

    GetResponseBody getResponseBody = usersServices.getUsers();
        Assert.assertEquals(getResponseBody.getStatusCode(), 200);

    }

    @Test
    public void createAndDeleteUser(){

        CreateUserRequestBody createUserRequestBody = new CreateUserRequestBody.Builder().build();
        int id = usersServices.createUser(createUserRequestBody).getData().getId();
        int statusCode = usersServices.deleteUser(id);
    Assert.assertEquals(statusCode, 204);
    usersServices.getUserErrorResponse(id).assertError(404, "Resource not found");



    }

}
