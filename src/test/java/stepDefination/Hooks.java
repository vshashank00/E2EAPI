package stepDefination;


import io.cucumber.java.Before;

import java.io.IOException;

public class Hooks {
    @Before("@Deleteplace")
    public void beforesce() throws IOException {

        StepDefination stepDefination=new StepDefination();
        if(StepDefination.place_id==null){
        stepDefination.addPlacePayload("Shank","Hindi");
        stepDefination.user_calls_with_http_request("AddPlaceAPI","POST");
        stepDefination.in_response_body_is("status","OK");}

    }
}
