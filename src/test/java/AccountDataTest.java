import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

/**
 * 账户资料
 */
public class AccountDataTest {
    String custid="1300022253";
    String fundid="1300022253";
    @Test
    void test100902(){

        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "100902")
                .queryParam("trade_no", custid)
                .queryParam("branch_no", "0013")
                .when()
                .post(GlobalConfig.url)
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test100947(){

        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "100947")
                .queryParam("trade_no", custid)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].ext_org",equalTo("2003"));
    }

    @Test
    void test101001(){

        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "101001")
                .queryParam("trade_no", custid)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test100966(){

        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "100966")
                .queryParam("trade_no", custid)
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test100928(){

        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "100928")
                .queryParam("trade_no", custid)
                .queryParam("id_type", "00")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"));
    }

    @Test
    void test100904(){

        given()
                .log().all()
                .filter(SignAgreementTest.myFilter)
                .queryParam("login_test", 1)
                .queryParam("funcNo", "100904")
                .queryParam("trade_no", custid)
                .queryParam("branch_no", "0013")
                .queryParam("riskkind", "3")
                .when()
                .post("url")
                .then().log().all()
                .statusCode(200).body("error_no", equalTo("0"))
                .body("results[0].result",containsString("型"));
    }
}
