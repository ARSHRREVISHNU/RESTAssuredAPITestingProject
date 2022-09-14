package APITesting;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClinet;
import users.UsersService;
import users.getAll.GetAllUsersResponse;

public class RESTAssurredTests {


    private UsersService usersService;

    @BeforeClass
    public void beforeClass(){
        usersService = new UsersService();
    }

    @Test
    public void togGetAllUsers(){
        GetAllUsersResponse getAllUsersResponse = usersService.getUsers();
        Assert.assertEquals(getAllUsersResponse.getStatusCode(), 200);
        Assert.assertEquals(getAllUsersResponse.getDataList().size(), 10);
        Assert.assertTrue(getAllUsersResponse.checkMaleUser());

    }


}
