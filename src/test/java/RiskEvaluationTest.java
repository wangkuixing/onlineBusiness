import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

/**
 * 风险测评
 */
public class RiskEvaluationTest {
    String custid="1300022253";

    @Test
    void test100904(){
        //查询风险等级
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("funcNo", "100904")
                .formParam("riskkind", "3")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].result",containsString("型"));
    }

    @Test
    void test100910(){
        //问卷查询
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .header("Cookie" , GetCookie.getCookie())
                .formParam("funcNo", "100910")
                .formParam("riskkind", "3")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("error_info",equalTo("查询成功"))
                .body("results[0].result", containsString("您的主要收入来源是"));
    }
}
