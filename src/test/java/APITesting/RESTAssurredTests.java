package APITesting;

import com.beust.ah.A;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.UsersClinet;
import users.getAll.GetAllUsersResponse;

public class RESTAssurredTests {


    private UsersClinet user;

    @BeforeClass
    public void beforeClass(){
        user = new UsersClinet();
    }

    @Test
    public void togGetAllUsers(){
        GetAllUsersResponse getAllUsersResponse = user.getUsers();
        Assert.assertEquals(getAllUsersResponse.getStatusCode(), 200);
        Assert.assertEquals(getAllUsersResponse.getDataList().size(), 10);
        Assert.assertTrue(getAllUsersResponse.checkMaleUser());

    }


}
