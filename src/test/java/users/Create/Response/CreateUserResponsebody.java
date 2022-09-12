package users.Create.Response;

import lombok.Getter;
import lombok.Setter;


@Getter
public class CreateUserResponsebody {
    @Setter
    private int statusCode;

    private String meta;
    private Data data;


}
