package users.Create.Response;

import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;
import users.Create.Request.CreateUserRequestbody;


@Getter
public class CreateUserResponsebody {
    @Setter
    private int statusCode;

    private String meta;
    private Data data;

    public void assertUser(CreateUserRequestbody responseBody){
        Assert.assertEquals(this.getStatusCode(), 201);
        Assert.assertNotNull(this.getData().getId());
        Assert.assertEquals(this.getData().getName(), responseBody.getName());
        Assert.assertEquals(this.getData().getEmail(), responseBody.getEmail());
        Assert.assertEquals(this.getData().getGender(), responseBody.getGender());
        Assert.assertEquals(this.getData().getStatus(), responseBody.getStatus());
    }

}
