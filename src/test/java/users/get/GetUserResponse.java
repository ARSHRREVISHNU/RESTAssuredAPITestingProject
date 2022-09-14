package users.get;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import users.Create.Request.CreateUserRequestbody;

@Getter
public class GetUserResponse {

    @Setter
    private int statusCode;

    private String meta;
    private Data data;


    public void assertUser(CreateUserRequestbody requestbody){

        Assert.assertEquals(data.email, requestbody.getEmail());
        Assert.assertEquals(data.name, requestbody.getName());
        Assert.assertEquals(data.gender, requestbody.getGender());
        Assert.assertEquals(data.status, requestbody.getStatus());
    }


    @Getter
    public static class Data{
        private String name;
        private String id;
        private String email;
        private String gender;
        private String status;
    }

}
