import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ESignatureTest {

    static String user_id="";
    @Test
    void test102010(){
        //电子签名约定书-查询柜台是否已签署
        Response response=
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "102010")
                .when()
                .post("http://t0st.ytzq.com:8443/web/bus/json")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .extract().response();

        user_id=response.jsonPath().get("results[0].user_id");
    }

    @Test
    void test102027(){
        //电子签名约定书-客户点击下一步的时间记录到DB
        test102010();
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie2())
                .formParam("funcNo", "102027")
                .formParam("user_id", user_id)
                .when()
                .post("http://t0st.ytzq.com:8443/web/bus/json")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }
}
