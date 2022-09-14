package secondproject.ResponseBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class CreateUserResponseBody {

    @Setter
    private int statusCode;

    private String meta;


    @JsonProperty("data")
    private Data data;

    @Getter
    public class Data{

        private String name;
        private String email;
        private String status;
        private String gender;
        private int id;

    }



}
