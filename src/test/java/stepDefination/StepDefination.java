package stepDefination;

import Resources.ApiResources;
import Resources.TestDataBuild;
import Resources.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefination extends Utils {
    RequestSpecification s;
    Response res;
    TestDataBuild testDataBuild=new TestDataBuild();
   static String place_id;

    @Given("Add Place Payload {string} {string}")
    public void addPlacePayload(String arg0, String arg1) throws IOException {
        s= given().log().all().spec(specs()).body(testDataBuild.testdata(arg0,arg1));

    }
    @When("user calls {string} with {string} http request")
    public void user_calls_with_http_request(String apimethod, String string2) {
       ApiResources apiResources= ApiResources.valueOf(apimethod);
       if(string2.equals("POST"))
        res=s.when().post(apiResources.getResourse());//apiResources.getResourse() is a enum which we are getting dynamically see 92
       else if(string2.equals("GET"))
           res=s.when().post(apiResources.getResourse());
       else if (string2.equals("PUT")) {
           res=s.when().put(apiResources.getResourse());

       }

    }
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(int int1) {
       Response response= res.then().log().all().extract().response();

        assertEquals(Integer.parseInt(String.valueOf(response.getStatusCode())),int1);

    }
    @And("{string} in response body is {string}")
    public void in_response_body_is(String string, String string2) {
        // Write code here that turns the phrase above into concrete actions
        JsonPath jsonPath=new JsonPath(res.asString());
        assertEquals(jsonPath.getString(string),string2);
         place_id=jsonPath.getString("place_id");

    }


    @And("verify the place with {string} with {string}")//hiting get appi
    public void verifyThePlaceWithWith(String api, String name) throws IOException {
        s=given().log().all().spec(specs()).queryParam("place_id",place_id);
        user_calls_with_http_request(api,"GET");
        JsonPath jsonPath=new JsonPath(res.asString());
        assertEquals(jsonPath.getString("name"),name);

    }
// delete place api
    @Given("Add Place Payload")
    public void addPlacePayload() throws IOException {
        s=given().log().all().given().log().all().spec(specs()).body("{\n" +
                "    \"place_id\":\""+place_id+"\"\n" +
                "}\n");

    }
}
