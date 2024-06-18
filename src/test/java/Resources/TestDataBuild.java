package Resources;

import pojo.AddPlace;
import pojo.Location;

import java.util.Arrays;

public class TestDataBuild
{
    public AddPlace testdata(String a,String b){
        AddPlace maps=new AddPlace();
        maps.setAccuracy(50);
        maps.setAddress("29, side layout, cohen 09");
        maps.setLanguage(b);
        maps.setPhone_number("(+91) 983 893 3937");
        maps.setName(a);
        maps.setTypes(Arrays.asList("shoe park","shop"));
        maps.setWebsite("http://google.com");
        Location location=new Location();
        location.setLat(-38.383494);
        location.setLng(33.427362);
        maps.setLocation(location);
        return maps;
    }
}
