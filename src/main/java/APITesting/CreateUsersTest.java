package APITesting;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import users.Create.JSONObject;
import users.UsersClinet;

import java.util.UUID;

import static io.restassured.RestAssured.given;

public class CreateUsersTest {

   private UsersClinet client;
@BeforeClass
public void beforeClass(){
    client = new UsersClinet();
 }
    @Test
    public void toCreateMaleUser(){
//Arrange

        JSONObject obj;
        String name = "Tenali Ramakrishna";
        String gender = "male";
        String status = "active";
        String email = String.format("%@gmail.com", UUID.randomUUID());

        String body = String.format("{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"gender\": \""+gender+"\",\n" +
                "  \"email\": \"%s\",\n" +
                "  \"status\": \""+status+"\"\n" +
                "}", email);

        obj = new JSONObject(name,gender,status,email);
    //Act
    client.getUser(obj)
                //Assert
                .then()
                .log().body()
                .statusCode(201)
                .body("data.id", Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email));



    }


    @Test
    public void toGETUsers(){

                client.getUsers()
                        .then()
                .log().body()
                .statusCode(200)
                .body("data",Matchers.hasItem(Matchers.hasEntry("email", "bobbie_metz@collins.info")));






    }

    @Test
    public void toCreateFemaleUser(){
//Arrange
        JSONObject obj;
        String name = "Tenali Ramakrishna";
        String gender = "male";
        String status = "active";
        String email = String.format("%s@gmail.com", UUID.randomUUID());
        String body = String.format("{\n" +
                "  \"name\": \""+name+"\",\n" +
                "  \"gender\": \""+gender+"\",\n" +
                "  \"email\": \"%s\",\n" +
                "  \"status\": \""+status+"\"\n" +
                "}", email);
        obj = new JSONObject(name,gender,email, status);
       //Act
     client.getUser(obj)
                .then()
                .log().body()
                .statusCode(201)
                .body("data.id",Matchers.notNullValue())
                .body("data.email", Matchers.equalTo(email));
    }

}
