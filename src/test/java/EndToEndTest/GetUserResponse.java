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

public void assertUserId(CreateUserRequestBody responseBody){
        Assert.assertEquals(data.email, responseBody.getEmail());
        Assert.assertEquals(data.name, responseBody.getName());
        Assert.assertEquals(data.gender, responseBody.getGender());
        Assert.assertEquals(data.status, responseBody.getStatus());
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
