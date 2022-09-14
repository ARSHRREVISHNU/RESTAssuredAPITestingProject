package secondproject;

import io.restassured.response.Response;
import secondproject.RequestBody.CreateUserRequestBody;
import secondproject.ResponseBody.CreateUserResponseBody;
import secondproject.ResponseBody.GETDataNotfoundResponseBody;
import secondproject.ResponseBody.GetResponseBody;

public class UsersServices {

    UsersClient usersClinet = new UsersClient();
    public GetResponseBody getUsers(){


        Response response = usersClinet.get();
        int statusCode = response.getStatusCode();

        GetResponseBody getResponseBody = response.as(GetResponseBody.class);
        getResponseBody.setStatusCode(statusCode);
        return getResponseBody;





    }

    public CreateUserResponseBody createUser(CreateUserRequestBody body){
        Response response = usersClinet.create(body);
        CreateUserResponseBody createUserResponseBody = response.as(CreateUserResponseBody.class);
        createUserResponseBody.setStatusCode(response.getStatusCode());
        return createUserResponseBody;
    }

    public int deleteUser(int id){
        Response response = usersClinet.delete(id);
        int statusCode = response.getStatusCode();
return statusCode;

    }

    public GETDataNotfoundResponseBody getUserErrorResponse(int id){
            Response response = usersClinet.getUser(id);
      GETDataNotfoundResponseBody getDataNotfoundResponseBody = response.as(GETDataNotfoundResponseBody.class);
      getDataNotfoundResponseBody.setStatusCode(response.getStatusCode());
return getDataNotfoundResponseBody;

    }

}
