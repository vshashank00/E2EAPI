Feature: Validating Place API's
@Addplace
  Scenario Outline: Verify if Place is being Succesfully added using AddPlaceAPI
    Given Add Place Payload "<name>" "<language>"
    When user calls "AddPlaceAPI" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"
    And "scope" in response body is "APP"
    And verify the place with "getPlaceApi" with "<name>"
    Examples:
      | name     | language |
      | Shashank | English  |

@Deleteplace
  Scenario: Verify if Delete Api works
    Given Add Place Payload
    When user calls "deletePlace" with "POST" http request
    Then the API call got success with status code 200
    And "status" in response body is "OK"

