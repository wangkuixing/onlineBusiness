import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class ContractRenewalTest {
    String creditAccount="1290000019";
    String custid="1100003755";

    @Test
    void test106011(){

        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "106011")
                .queryParam("rzrq_creditAccount", creditAccount)
                .queryParam("branch_no", "0012")
                .queryParam("trade_no", custid)
                .when()
                .get("http://t0st.ytzq.com:8443/web/bus/json")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].sno",equalTo("11"));
    }

    @Test
    void test106050(){

        //"error_info": "系统出现异常",
        // "error_no": "-1000"
        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "106050")
                .queryParam("rzrq_creditAccount", creditAccount)
                .queryParam("branch_no", "0012")
                .queryParam("trade_no", custid)
                .queryParam("jsondata", "5")
                .queryParam("findavl", "6666")
                .when()
                .get("http://t0st.ytzq.com:8443/web/bus/json")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0]",equalTo("true"));
    }
}
