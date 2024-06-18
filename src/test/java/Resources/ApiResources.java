package Resources;

public enum ApiResources {
    AddPlaceAPI("maps/api/place/add/json"),
    getPlaceApi("/maps/api/place/get/json"),
    deletePlace("maps/api/place/delete/json");
    private String res;

    ApiResources(String res) {//this will asigh add place api value
        this.res=res;
    }
    public String getResourse(){ //return of res will happen
        return res;
    }

}
