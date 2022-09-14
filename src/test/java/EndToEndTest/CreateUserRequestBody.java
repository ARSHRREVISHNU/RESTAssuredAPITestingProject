package EndToEndTest;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CreateUserRequestBody {
    private String name;
    private String email;
    private String gender;
    private String status;
}
