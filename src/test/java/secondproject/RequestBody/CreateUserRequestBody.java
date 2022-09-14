package secondproject.RequestBody;


import lombok.Getter;

import java.util.UUID;

@Getter
public class CreateUserRequestBody {

    private String name;
    private String email;
    private String status;
    private String gender;

    public CreateUserRequestBody(Builder builder){
        this.name = builder.name;
        this.email = builder.email;
        this.gender = builder.gender;
        this.status = builder.status;
    }

    public static class Builder{

        private String name;
        private String email;
        private String status;
        private String gender;

        public Builder(){
            this.name = "Sample Name From Second Project";
            this.email = String.format("%s@gmail.com", UUID.randomUUID());
            this.status = "active";
            this.gender = "male";
        }

        public Builder name(String name){
            this.name = name;
            return this;
        }
        public Builder email(String email){
            this.email = email;
            return this;
        }
        public Builder status(String status){
            this.status = status;
            return this;
        }
        public Builder gender(String gender){
            this.gender = gender;
            return this;
        }

        public CreateUserRequestBody build(){
            CreateUserRequestBody createUserRequestbody = new CreateUserRequestBody(this);
            return createUserRequestbody;
        }

    }

}
