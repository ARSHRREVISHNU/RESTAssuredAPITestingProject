package secondproject.ResponseBody;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
public class GetResponseBody {

    @Setter
    public int statusCode;

    @JsonProperty("firmness")
    private Firmness firmness;
    @JsonProperty("flavors")
    private List<Flavours> flavours;
    @JsonProperty("growth_time")
    private int growthTime;
    @JsonProperty("id")
    private int id;
    @JsonProperty("item")
    private Item item;
    @JsonProperty("max_harvest")
    private int max_harvest;
    @JsonProperty("name")
    private String name;
    @JsonProperty("natural_gift_power")
    private int naturalGiftPower;
    @JsonProperty("natural_gift_type")
    private NaturalGiftType naturalGiftType;
    @JsonProperty("size")
    private int size;
    @JsonProperty("smoothness")
    private int smoothness;
    @JsonProperty("soil_dryness")
    private int soilDryness;


    @Getter
    public class Firmness{
        private String name;
        private String url;

    }

    @Getter
    public static class Flavours{
        private Flavor flavor;

        private String potency;


        @Getter
        public class Flavor{
            private String name;

            private String url;
        }

    }



    @Getter
    public class Item{
        private String name;
        private String url;
    }

    @Getter
    public class NaturalGiftType{
        private String name;
        private String url;
    }
}
