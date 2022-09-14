package users;

import io.restassured.response.Response;
import users.Create.Request.CreateUserRequestbody;
import users.Create.Response.CreateUserErrorResponse;
import users.Create.Response.CreateUserResponsebody;
import users.get.GetUserErrorResponse;
import users.get.GetUserResponse;
import users.getAll.GetAllUsersResponse;

public class UsersService {
UsersClinet usersClinet = new UsersClinet();
    public CreateUserResponsebody getUser(CreateUserRequestbody body) {

        Response response = usersClinet.create(body);
        CreateUserResponsebody createUserResponsebody = response.as(CreateUserResponsebody.class);
        createUserResponsebody.setStatusCode(response.statusCode());

        return createUserResponsebody;
    }
    public CreateUserErrorResponse createUserExpectingError(CreateUserRequestbody body){

        Response response = usersClinet.create(body);
        CreateUserErrorResponse errorResponse = response.as(CreateUserErrorResponse.class);
        errorResponse.setStatusCode(response.statusCode());
        return errorResponse;
    }
    public GetAllUsersResponse getUsers() {
    Response response = usersClinet.getAll();

     int statusCode = response.statusCode();

        GetAllUsersResponse getAllUsersResponse = response.as(GetAllUsersResponse.class);
        getAllUsersResponse.setStatusCode(statusCode);
        return getAllUsersResponse;
    }
    public GetUserResponse getuser(int id){

        Response response = usersClinet.get(id);

        GetUserResponse getUserResponse =  response.as(GetUserResponse.class);
        getUserResponse.setStatusCode(response.getStatusCode());
        return getUserResponse;
    }

    public int deleteUser(int id){
        Response response = usersClinet.delete(id);
        return response.statusCode();

    }
  public  GetUserErrorResponse getUserExpectingError(int id){
Response response = usersClinet.get(id);
int statusCode = response.statusCode();
        GetUserErrorResponse getUserResponse = response.as(GetUserErrorResponse.class);
getUserResponse.setStatusCode(statusCode);
return getUserResponse;
    }
}
