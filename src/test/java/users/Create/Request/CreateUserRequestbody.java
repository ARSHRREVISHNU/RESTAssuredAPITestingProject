package users.Create.Request;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CreateUserRequestbody {
    private String name;
    private String gender;
    private String email;
    private String status;


}
