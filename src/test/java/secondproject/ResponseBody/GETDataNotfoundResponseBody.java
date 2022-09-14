package secondproject.ResponseBody;

import com.beust.ah.A;
import lombok.Getter;
import lombok.Setter;
import org.testng.Assert;

@Getter
public class GETDataNotfoundResponseBody {

    @Setter
    private int statusCode;

    private String meta;
    private Data data;


    public void assertError(int expectedStatusCode, String expectedMessage){

        Assert.assertEquals(getStatusCode(), expectedStatusCode);
        Assert.assertEquals(data.getMessage(), expectedMessage);
    }


@Getter
    public static class Data{
        private String message;

    }

}
