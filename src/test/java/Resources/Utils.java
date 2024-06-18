package Resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.*;
import java.util.Properties;

public class Utils {
    public static RequestSpecification specification;
    public RequestSpecification  specs() throws IOException {
        if(specification==null){
        Properties properties=new Properties();
        FileInputStream fileInputStream=new FileInputStream(System.getProperty("user.dir")+"/src/test/java/Resources/Uri.properties");
        properties.load(fileInputStream);
       PrintStream printStream= new PrintStream(new FileOutputStream("logging.txt"));
         specification= new RequestSpecBuilder().setBaseUri(properties.getProperty("url")).
                setContentType(ContentType.JSON).addQueryParam("key","qaclick123")
                .addFilter(RequestLoggingFilter.logRequestTo(printStream)).addFilter(ResponseLoggingFilter.logResponseTo(printStream))
                .build();
        return specification;
        }
        return specification;
    }
}
