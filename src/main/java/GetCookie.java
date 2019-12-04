import io.restassured.response.Response;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetCookie {

    public static String cookie;
    public static String cookie2;
    public static String cookie3;
    public static String cookie4;

    public static String getCookie(){
        if (cookie == null){
            cookie=getCookieWithLogin("1300022253");
        }
        return cookie;
    }

    public static String getCookie2(){
        if (cookie == null){
            cookie=getCookieWithLogin("1100001235");
        }
        return cookie2;
    }

    public static String getCookie3(){
        if (cookie == null){
            cookie=getCookieWithLogin("1100001022");
        }
        return cookie3;
    }

    public static String getCookie4(){
        if (cookie == null){
            cookie=getCookieWithLogin("1100003755");
        }
        return cookie4;
    }

    public static String getCookieWithLogin(String userAccount){
        Response response=given()
                .log().all()
                .formParam("funcNo", "100201")
                .formParam("login_name", userAccount)
                .formParam("login_password","147258")
                .formParam("img_ticket","8888")
                .formParam("password_encrypt_type","normal")
                .formParam("safe_type","1")
                .formParam("dynamic_code","")
                .formParam("user_mac","")
                .formParam("user_disk_id","")
                .formParam("user_ip","")
                .formParam("user_agent","")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).extract().response();

        Map<String, String> map=response.getCookies();
        String s=map.get("sso_cookie");
        String sso_cookie="sso_cookie" + "=" + s;
        return sso_cookie;
    }
}
