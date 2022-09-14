package users.getAll;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class GetAllUsersResponse {

@Setter
public int statusCode;
private Meta meta;

@JsonProperty("data")
private List<Data> dataList;

    public boolean checkMaleUser() {
        return  dataList
                .stream()
                .filter(data->data.getGender().equals("male"))
                .findFirst()
                .isPresent();
    }
    @Getter
public static class Meta{
    private Pagination pagination;
}

@Getter
public static class Pagination{
    private String total;
    private String pages;
    private String page;
    private String limit;
    private Links links;

}

@Getter
public static class Links{
    private String previous;
    private String current;
    private String next;
}

@Getter
private static class Data{
private int id;
private String name;
private String gender;
private String email;
private String status;
}



}
