package EndToEndTest;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class GetUserResponse {

@Setter
private int statusCode;

private Data data;
private String meta;

public void assertUserId(CreateUserRequestBody requestBody){
        Assert.assertEquals(data.email, requestBody.getEmail());
        Assert.assertEquals(data.name, requestBody.getName());
        Assert.assertEquals(data.gender, requestBody.getGender());
        Assert.assertEquals(data.status, requestBody.getStatus());
    }



@Getter
    public static class Data{

        private int id;
        private String name;
        private String email;
        private String gender;
        private String status;

    }


}
