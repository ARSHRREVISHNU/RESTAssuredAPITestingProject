package users.Create.Request;


import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateUserRequestbody {
    private String name;
    private String gender;
    private String email;
    private String status;

    public CreateUserRequestbody(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.gender = builder.gender;
        this.status = builder.status;

    }


    public static class Builder {

        private String name;
        private String gender;
        private String email;
        private String status;

        public Builder() {
            this.name = "Sample name 1";
            this.gender = "male";
            this.email = String.format("%s@gmail.com", UUID.randomUUID());
            this.status = "active";
        }

        public Builder gender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder status(String status) {
            this.status = status;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;

        }

        public CreateUserRequestbody build() {

        CreateUserRequestbody createUserRequestbody = new CreateUserRequestbody(this);
        return createUserRequestbody;
        }
    }
}